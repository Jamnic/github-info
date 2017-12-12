package org.satanjamnic.gitpository.parent.connection.factory

import org.satanjamnic.gitpository.parent.connection.Connection
import java.io.IOException

interface ConnectionFactory {

    @Throws(IOException::class)
    fun create(): Connection
}