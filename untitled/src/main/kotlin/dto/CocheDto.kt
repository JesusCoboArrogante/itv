package org.example.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("coche1")
data class CocheDto(
    @SerialName("matricula")
    val matricula: String,

    @SerialName("marca")
    val marca: String,

    @SerialName("motor")
    val motor: String,

    @SerialName("fechaMatriculacion")
    val fechaMatriculacion: String
): java.io.Serializable
