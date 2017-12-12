package org.satanjamnic.gitpository.parent.connection.response

interface Response {
    fun code(): Int
    fun data(): String
}