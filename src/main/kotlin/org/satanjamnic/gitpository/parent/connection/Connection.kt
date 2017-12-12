package org.satanjamnic.gitpository.parent.connection

import org.satanjamnic.gitpository.parent.connection.open.OpenConnection
import java.io.IOException

interface Connection {

    @Throws(IOException::class)
    fun connect(): OpenConnection
    fun disconnect()
}