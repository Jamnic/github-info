package org.satanjamnic.gitpository.parent

import com.fasterxml.jackson.databind.ObjectMapper
import org.satanjamnic.gitpository.parent.connection.GetConnectionExecutor
import org.satanjamnic.gitpository.parent.connection.factory.GetConnectionFactory

// TODO consider changing name
class GitApi (){

    fun getRepositoryInfo(
            owner: String,
            repo: String
    ): GitApiResponse {

        // TODO DependencyInjection
        val connectionFactory = GetConnectionFactory("https://api.github.com/repos/$owner/$repo", 5000)

        // TODO DependencyInjection
        val data = GetConnectionExecutor(connectionFactory).response()

        // TODO delegate to response class + DependencyInjection
        val json = ObjectMapper().readTree(data.data())

        return GitApiResponse(
                json["full_name"].asText(),
                json["description"].asText(),
                json["clone_url"].asText(),
                json["stargazers_count"].asInt(),
                json["created_at"].asText())
    }
}