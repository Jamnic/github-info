package org.satanjamnic.gitpository.parent.connection.response

class NotFoundResponse(
        private val responseMessage: String?,
        private val responseCode: Int,
        private val responseDelegate: Response = MessageWithCodeResponse(responseCode, responseMessage)
) : Response by responseDelegate
