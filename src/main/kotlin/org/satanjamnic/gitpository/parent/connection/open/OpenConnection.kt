package org.satanjamnic.gitpository.parent.connection.open

import java.io.InputStream

interface OpenConnection {

    fun inputStream(): InputStream
    fun responseMessage(): String
    fun responseCode(): Int
}
