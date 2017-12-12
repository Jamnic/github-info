package org.satanjamnic.gitpository.parent

import spock.lang.Specification

class GitApiSpecIT extends Specification {

    def "should return git repository info for given owner and repository name"(
            String owner,
            String repo) {

        expect:
          def repositoryInfo = new GitApi().getRepositoryInfo(owner, repo)

          repositoryInfo.fullName == owner + "/" + repo
          repositoryInfo.cloneUrl == "https://github.com/" + owner + "/" + repo + ".git"
          repositoryInfo.description
          repositoryInfo.stars >= 0
          repositoryInfo.createdAt
        where:
          owner    | repo
          "Jamnic" | "BuildBat"
          "Jamnic" | "BuildBat-web"
          "Jamnic" | "spaceGame"
    }
}