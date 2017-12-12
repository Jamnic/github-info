package org.satanjamnic.gitpository.parent.connection.open

import java.io.InputStream
import java.net.HttpURLConnection

class BaseOpenConnection(
        private val connection: HttpURLConnection
) : OpenConnection {

    override fun responseCode(): Int {
        return connection.responseCode
    }

    override fun responseMessage(): String {
        return connection.responseMessage ?: "No response"
    }

    override fun inputStream(): InputStream {
        return connection.inputStream
    }
}