package org.satanjamnic.gitpository.parent.connection.response

class ErrorResponse(
        private val responseMessage: String,
        private val responseCode: Int,
        private val responseDelegate: Response = MessageWithCodeResponse(responseCode, responseMessage)
) : Response by responseDelegate {

    constructor(
            responseMessage: String?
    ) : this(
            responseMessage ?: "Unrecognized error",
            -1)
}