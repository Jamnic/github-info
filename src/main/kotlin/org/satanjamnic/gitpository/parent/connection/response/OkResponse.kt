package org.satanjamnic.gitpository.parent.connection.response

import org.satanjamnic.gitpository.parent.StringInputStream
import java.io.InputStream

class OkResponse(
        private val data: String,
        private val responseCode: Int
) : Response {

    constructor(
            inputStream: InputStream?,
            responseCode: Int
    ) : this(
            StringInputStream(inputStream).read(),
            responseCode)

    override fun data(): String {
        return data
    }

    override fun code(): Int {
        return responseCode
    }
}