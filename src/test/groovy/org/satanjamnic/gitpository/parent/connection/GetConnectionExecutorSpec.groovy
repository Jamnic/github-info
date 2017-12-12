package org.satanjamnic.gitpository.parent.connection

import org.satanjamnic.gitpository.parent.connection.factory.ConnectionFactory
import org.satanjamnic.gitpository.parent.connection.open.OpenConnection
import org.satanjamnic.gitpository.parent.connection.response.*
import spock.lang.Specification

class GetConnectionExecutorSpec extends Specification {

    final def mockConnectionFactory = Mock(ConnectionFactory)

    def tested = new GetConnectionExecutor(mockConnectionFactory)

    def "should respond with proper Response"(Integer responseCode, Class<Response> responseClass) {
        def mockConnection = Mock(Connection)
        def mockOpenConnection = Mock(OpenConnection)
        mockConnectionFactory.create() >> mockConnection
        mockConnection.connect() >> mockOpenConnection
        mockOpenConnection.responseCode() >> responseCode

        expect:
          def response = tested.response()
          responseClass.isInstance(response)
        where:
          responseCode | responseClass
          200          | OkResponse.class
          201          | OkResponse.class
          500          | ServerErrorResponse.class
          400          | MethodNotAllowedResponse.class
          404          | NotFoundResponse.class
    }

    def "should respond with proper Response after IOException in Connection"() {
        given:
          def mockConnection = Mock(Connection)
          mockConnectionFactory.create() >> mockConnection
          mockConnection.connect() >> { throw new IOException() }
        when:
          def response = tested.response()
        then:
          response instanceof IOExceptionResponse
    }

    def "should respond with proper Response after IOException in ConnectionFactory"() {
        given:
          mockConnectionFactory.create() >> { throw new IOException() }
        when:
          def response = tested.response()
        then:
          response instanceof IOExceptionResponse
    }
}