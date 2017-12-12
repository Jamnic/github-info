package org.satanjamnic.gitpository.parent.connection.response

class MalformedUrlResponse(
        private val responseMessage: String?,
        private val responseDelegate: Response =
        MessageWithCodeResponse(-1, responseMessage ?: "MalformedUrlException error")
) : Response by responseDelegate