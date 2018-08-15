/**
 * Copyright (c) 2017-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.referenceschecker.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author Brian Wing Shun Chan
 */
public class JDBCUtil {

	public static void cleanUp(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		}
		catch (SQLException sqle) {
			_log.warn(sqle.getMessage());
		}
	}

	public static void cleanUp(Connection connection, Statement statement) {
		cleanUp(statement);

		cleanUp(connection);
	}

	public static void cleanUp(
		Connection connection, Statement statement, ResultSet resultSet) {

		cleanUp(resultSet);

		cleanUp(statement);

		cleanUp(connection);
	}

	public static void cleanUp(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		}
		catch (SQLException sqle) {
			_log.warn(sqle.getMessage());
		}
	}

	public static void cleanUp(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		}
		catch (SQLException sqle) {
			_log.warn(sqle.getMessage());
		}
	}

	public static void cleanUp(Statement statement, ResultSet resultSet) {
		cleanUp(resultSet);

		cleanUp(statement);
	}

	public static void deepCleanUp(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				Statement statement = resultSet.getStatement();

				Connection connection = statement.getConnection();

				cleanUp(connection, statement, resultSet);
			}
		}
		catch (SQLException sqle) {
			_log.warn(sqle.getMessage());
		}
	}

	private static Logger _log = LogManager.getLogger(JDBCUtil.class);

}