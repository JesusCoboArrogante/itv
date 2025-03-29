package org.example

import org.example.storage.CocheCsv
import java.io.File

fun main() {
    val cocheCsv = CocheCsv().fileRead(File("data", "coches.csv"))
    cocheCsv.forEach { println(it) }

}