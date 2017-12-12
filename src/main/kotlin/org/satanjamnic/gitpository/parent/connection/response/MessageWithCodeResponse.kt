package org.satanjamnic.gitpository.parent.connection.response

class MessageWithCodeResponse(
        private val responseCode: Int,
        private val responseMessage: String?
) : Response {

    override fun code(): Int {
        return responseCode
    }

    override fun data(): String {
        return responseMessage ?: "Unrecognized error"
    }
}