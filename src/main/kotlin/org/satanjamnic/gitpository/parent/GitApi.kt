package org.satanjamnic.gitpository.parent

import com.fasterxml.jackson.databind.ObjectMapper

// TODO consider changing name
class GitApi {

    fun getRepositoryInfo(
            owner: String,
            repo: String
    ): GitApiResponse {

        // TODO DependencyInjection
        val connectionFactory = ConnectionFactory("https://api.github.com/repos/$owner/$repo", 5000)

        // TODO DependencyInjection
        val data = GetConnection(connectionFactory).json()

        // TODO delegate to json class + DependencyInjection
        val json = ObjectMapper().readTree(data)

        return GitApiResponse(
                json["full_name"].asText(),
                json["description"].asText(),
                json["clone_url"].asText(),
                json["stargazers_count"].asInt(),
                json["created_at"].asText())
    }
}