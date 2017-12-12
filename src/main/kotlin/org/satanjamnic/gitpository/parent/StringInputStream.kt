package org.satanjamnic.gitpository.parent

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class StringInputStream(
        private val inputStream: InputStream?
) {

    fun read(): String {
        if (inputStream != null) {
            BufferedReader(InputStreamReader(inputStream)).use {
                return it
                        .lineSequence()
                        .fold(StringBuilder(), { stringBuilder, line -> stringBuilder.append(line) })
                        .toString()
            }
        } else {
            return ""
        }
    }
}