package org.satanjamnic.gitpository.parent.connection

import org.satanjamnic.gitpository.parent.connection.open.BaseOpenConnection
import org.satanjamnic.gitpository.parent.connection.open.OpenConnection
import java.net.HttpURLConnection

class BaseConnection(
        private val connection: HttpURLConnection
) : Connection {

    override fun connect(): OpenConnection {
        connection.connect()
        return BaseOpenConnection(connection)
    }

    override fun disconnect() {
        connection.disconnect()
    }
}