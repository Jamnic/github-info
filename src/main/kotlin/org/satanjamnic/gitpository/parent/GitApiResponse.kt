package org.satanjamnic.gitpository.parent

data class GitApiResponse(
        private val fullName: String = "",
        private val description: String = "",
        private val cloneUrl: String = "",
        private val stars: Int = 0,
        // TODO convert to date
        private val createdAt: String = ""
)