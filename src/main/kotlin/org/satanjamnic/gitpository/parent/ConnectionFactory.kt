package org.satanjamnic.gitpository.parent

import java.net.HttpURLConnection
import java.net.URL

// TODO try to generify that
class ConnectionFactory(
        private val url: URL,
        private val timeout: Int
) {

    constructor(
            urlString: String,
            timeout: Int
    ) : this(
            URL(urlString),
            timeout)

    fun create(): HttpURLConnection {
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.setRequestProperty("Content-length", "0")
        connection.useCaches = false
        connection.allowUserInteraction = false
        connection.connectTimeout = timeout
        connection.readTimeout = timeout
        return connection
    }
}