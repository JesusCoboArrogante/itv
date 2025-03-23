package org.example.cache


import com.github.benmanes.caffeine.cache.Cache
import com.github.benmanes.caffeine.cache.Caffeine
import org.example.models.Coche
import org.koin.core.annotation.Property
import org.koin.core.annotation.Singleton
import java.util.concurrent.TimeUnit


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


