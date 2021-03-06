package org.javers.repository.sql.integration

import org.javers.repository.sql.DialectName
import org.javers.repository.sql.JaversSqlRepositoryE2ETest

import java.sql.Connection
import java.sql.DriverManager

class MySqlIntegrationTest extends JaversSqlRepositoryE2ETest {

    Connection getConnection() {
        DriverManager.getConnection("jdbc:mysql://localhost/travis_ci_test", "travis", "");
    }

    DialectName getDialect() {
        DialectName.MYSQL
    }
}
