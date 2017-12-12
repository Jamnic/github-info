package org.satanjamnic.gitpository.parent.connection.factory

import org.satanjamnic.gitpository.parent.connection.BaseConnection
import org.satanjamnic.gitpository.parent.connection.Connection
import java.net.HttpURLConnection
import java.net.URL

class GetConnectionFactory(
        private val url: URL,
        private val timeout: Int
) : ConnectionFactory {

    constructor(
            urlString: String,
            timeout: Int
    ) : this(
            URL(urlString),
            timeout)

    override fun create(): Connection {
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.setRequestProperty("Content-length", "0")
        connection.useCaches = false
        connection.allowUserInteraction = false
        connection.connectTimeout = timeout
        connection.readTimeout = timeout
        return BaseConnection(connection)
    }
}