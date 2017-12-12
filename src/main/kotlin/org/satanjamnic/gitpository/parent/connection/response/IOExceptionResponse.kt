package org.satanjamnic.gitpository.parent.connection.response

class IOExceptionResponse(
        private val responseMessage: String?,
        private val responseDelegate: Response =
        MessageWithCodeResponse(-1, responseMessage ?: "IOException error")
) : Response by responseDelegate