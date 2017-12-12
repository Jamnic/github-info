package org.satanjamnic.gitpository.parent.connection

import org.satanjamnic.gitpository.parent.connection.factory.ConnectionFactory
import org.satanjamnic.gitpository.parent.connection.response.*
import java.io.IOException
import java.net.MalformedURLException

// TODO rename
class GetConnectionExecutor(
        private val connectionFactory: ConnectionFactory
) {

    // TODO coroutines or threads
    fun response(): Response {
        var connection: Connection? = null

        return try {
            connection = connectionFactory.create()

            val openConnection = connection.connect()

            when (openConnection.responseCode()) {
                200, 201 -> OkResponse(openConnection.inputStream(), openConnection.responseCode())
                500 -> ServerErrorResponse(openConnection.responseMessage(), openConnection.responseCode())
                400 -> MethodNotAllowedResponse(openConnection.responseMessage(), openConnection.responseCode())
                404 -> NotFoundResponse(openConnection.responseMessage(), openConnection.responseCode())
                else -> ErrorResponse(openConnection.responseMessage(), openConnection.responseCode())
            }

        } catch (ex: IOException) {
            IOExceptionResponse(ex.message)
        } finally {
            if (connection != null) {
                try {
                    connection.disconnect()
                } catch (ex: Exception) {
                    ErrorResponse(ex.message)
                }
            }
        }
    }
}