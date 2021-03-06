/*
 *
 *  *
 *  *  * <!--
 *  *  *   ~
 *  *  *   ~ The MIT License (MIT)
 *  *  *   ~
 *  *  *   ~ Copyright (c) 2010-2017 QAMatic
 *  *  *   ~
 *  *  *   ~ Permission is hereby granted, free of charge, to any person obtaining a copy
 *  *  *   ~ of this software and associated documentation files (the "Software"), to deal
 *  *  *   ~ in the Software without restriction, including without limitation the rights
 *  *  *   ~ to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  *  *   ~ copies of the Software, and to permit persons to whom the Software is
 *  *  *   ~ furnished to do so, subject to the following conditions:
 *  *  *   ~
 *  *  *   ~ The above copyright notice and this permission notice shall be included in all
 *  *  *   ~ copies or substantial portions of the Software.
 *  *  *   ~
 *  *  *   ~ THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  *  *   ~ IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  *  *   ~ FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  *  *   ~ AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  *  *   ~ LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  *  *   ~ OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  *  *   ~ SOFTWARE.
 *  *  *   ~
 *  *  *   ~
 *  *  *   -->
 *  *
 *  *
 *
 */

package org.qamatic.mintleaf;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public interface DbQueries {

    int getCount(String tableName, String whereClause, Object[] whereClauseValues);

    default boolean isSqlObjectExists(String objectName, String objectType, boolean ignoreValidity) throws MintLeafException {
        throw new NotImplementedException();
    }

    int getCount(String tableName);

    default boolean isTableExists(String tableName) throws SQLException, MintLeafException {
        throw new NotImplementedException();
    }

    default boolean isdbFeatureExists(String featureName) {
        throw new NotImplementedException();
    }


    <T> List<T> query(String sql, final DataRowListener<T> listener) throws SQLException, MintLeafException;

    int queryInt(String sql, Object[] whereClauseValues);

    default void truncateTable(String tableName) throws SQLException, MintLeafException {
        throw new NotImplementedException();
    }

    default boolean isUserExists(String userName) {
        throw new NotImplementedException();
    }

    default List<String> getSqlObjects(String objectType) throws SQLException, MintLeafException {
        throw new NotImplementedException();
    }

    default List<String> getPrimaryKeys(String ownerName, String tableName) throws SQLException, MintLeafException {
        throw new NotImplementedException();
    }

    default ColumnMetaDataCollection getMetaData(String objectName) throws SQLException, MintLeafException {
        throw new NotImplementedException();
    }

    default boolean isPrivilegeExists(String granteeName, String privilegeName, String objectName) {
        throw new NotImplementedException();
    }

    default boolean isColumnExists(String tableName, String columnName) throws MintLeafException {
        throw new NotImplementedException();
    }


    default String[] getObjectNames(String objectName) throws MintLeafException {
        final String[] objectNames = objectName.split(Pattern.quote("."));
        if (objectNames.length != 2) {
            throw new MintLeafException(String.format("getMetaData expects objectName parameter to be <SCHEMA NAME>.<OBJECT NAME> for example HRDB.COUNTRIES.  Invalid value: %s", objectName));
        }
        return objectNames;
    }

}
