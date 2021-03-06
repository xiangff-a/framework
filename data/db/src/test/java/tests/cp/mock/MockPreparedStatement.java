/*
 *
 *  * Copyright 2016 the original author or authors.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package tests.cp.mock;

import leap.lang.jdbc.PreparedStatementAdapter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MockPreparedStatement extends PreparedStatementAdapter {

    private final MockConnection conn;

    public MockPreparedStatement(MockConnection conn) {
        this.conn = conn;
        conn.increaseOpeningStatement();
    }

    @Override
    public ResultSet executeQuery() throws SQLException {
        return new MockResultSet(conn);
    }

    @Override
    public void close() throws SQLException {
        conn.decreaseOpeningStatement();
        super.close();
    }
}
