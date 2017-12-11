package org.satanjamnic.gitpository.parent

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.util.logging.Level
import java.util.logging.Logger

// TODO rename it
class GetConnection(
        private val connectionFactory: ConnectionFactory
) {

    fun json(): String {
        val connection = connectionFactory.create()

        // TODO coroutines or threads
        try {
            connection.connect()

            when (connection.responseCode) {
                200, 201 -> {
                    return readDataFromStream(connection.inputStream)
                }
            // TODO handle other response codes
            }

            // TODO use SLF4J
        } catch (ex: MalformedURLException) {
            Logger.getLogger(javaClass.name).log(Level.SEVERE, null, ex)
        } catch (ex: IOException) {
            Logger.getLogger(javaClass.name).log(Level.SEVERE, null, ex)
        } finally {
            try {
                connection.disconnect()
                // TODO remove any exception
            } catch (ex: Exception) {
                Logger.getLogger(javaClass.name).log(Level.SEVERE, null, ex)
            }
        }

        return ""
    }

    // TODO delegate it to other class, DependencyInjection
    private fun readDataFromStream(inputStream: InputStream): String {
        BufferedReader(InputStreamReader(inputStream)).use {
            return it
                    .lineSequence()
                    .fold(StringBuilder(), { stringBuilder, line -> stringBuilder.append(line) })
                    .toString()

        }
    }
}