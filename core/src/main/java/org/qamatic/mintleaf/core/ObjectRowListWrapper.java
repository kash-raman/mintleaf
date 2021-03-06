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

package org.qamatic.mintleaf.core;

import org.qamatic.mintleaf.ComparableRow;
import org.qamatic.mintleaf.MetaDataCollection;
import org.qamatic.mintleaf.MintLeafException;
import org.qamatic.mintleaf.RowListWrapper;

import java.sql.ResultSetMetaData;
import java.util.List;

/**
 * Created by qamatic on 3/4/16.
 */
public class ObjectRowListWrapper implements RowListWrapper {

    private List<? extends ComparableRow> list;
    private int current = -1;
    private MetaDataCollection metaDataCollection;

    public ObjectRowListWrapper(List<? extends ComparableRow> list, MetaDataCollection metaDataCollection) {

        this.metaDataCollection = metaDataCollection;
        this.list = list;
    }

    @Override
    public void resetAll() throws MintLeafException {
        current = -1;
    }

    @Override
    public boolean moveNext() throws MintLeafException {
        current++;
        if (this.current >= this.list.size()) {
            return false;
        }

        return true;
    }

    @Override
    public ComparableRow row() throws MintLeafException {
        if (this.current >= this.list.size()) {
            return null;
        }
        ComparableRow row = this.list.get(current);
        row.setMetaData(this.metaDataCollection);
        return row;
    }

    @Override
    public MetaDataCollection getMetaData() throws MintLeafException {
        return this.metaDataCollection;
    }

}
