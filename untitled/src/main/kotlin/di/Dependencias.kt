package org.example.cache


import com.github.benmanes.caffeine.cache.Cache
import com.github.benmanes.caffeine.cache.Caffeine
import org.example.dao.CocheDao
import org.example.database.JdbiManager
import org.example.error.CocheError
import org.example.models.Coche
import org.example.repository.RepositoryImp
import org.example.service.CocheService
import org.example.service.CocheServiceImpl
import org.example.validador.CocheValidador
import org.example.validador.Validator
import org.jdbi.v3.core.Jdbi
import org.koin.core.annotation.Property
import org.koin.core.annotation.Singleton
import java.util.concurrent.TimeUnit

object Dependecies{

    fun provideDatabaseManager(): Jdbi {
        return JdbiManager.instance

    }

    fun provideCocheDao(jdbi: Jdbi):CocheDao{
        return  jdbi.onDemand(CocheDao::class.java)
    }


    @Singleton
    fun provideCocheCache(
        @Property("cache.capacity")_capacity: String = "10",
        @Property("cache.duration") _duration: String = "300"
    ): Cache<String, Coche> {
        val capacity = _capacity.toLong()
        val duracion = _duration.toLong()
        return Caffeine.newBuilder()
            .maximumSize(capacity)
            .expireAfterWrite(duracion, TimeUnit.SECONDS)
            .build()
    }
    fun provideCocheRepository(dao: CocheDao):RepositoryImp{
        return RepositoryImp(dao)
    }

    fun provideCocheService(
        repository: RepositoryImp,
        cache :Cache<String, Coche>,
        validador: Validator<Coche,CocheError>
    ): CocheService {
        return  CocheServiceImpl(
            repository = repository,
            cache = cache,
            validador = validador
        )
    }

    fun provideValidador():Validator<Coche,CocheError>{
        return CocheValidador()
    }

    fun getCocheService():CocheService{
        return provideCocheService(
            repository = provideCocheRepository(provideCocheDao(provideDatabaseManager())),
            cache = provideCocheCache("10","300"),
            validador = provideValidador()
        )
    }


}




