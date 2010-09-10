package org.ojqa.domain.repository.jpa;

import java.io.FileInputStream;
import java.sql.Connection;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/**
 * @author ybak
 * 
 */
@SuppressWarnings("deprecation")
public abstract class BaseJPATest extends AbstractTransactionalDataSourceSpringContextTests {

    public BaseJPATest() {
        super();
    }

    public BaseJPATest(String name) {
        super(name);
    }

    @Override
    protected String[] getConfigLocations() {
        return new String[] { "applicationContext.xml", "applicationContext-test.xml" };
    }

    @Override
    protected void onSetUpInTransaction() throws Exception {
        DataSource dataSource = jdbcTemplate.getDataSource();
        Connection con = DataSourceUtils.getConnection(dataSource);
        IDatabaseConnection dbUnitCon = new DatabaseConnection(con);
        IDataSet dataSet = new FlatXmlDataSet(new FileInputStream("./src/test/resources/dbunit-test-data/User.xml"));

        try {
            DatabaseOperation.REFRESH.execute(dbUnitCon, dataSet);
        } finally {
            DataSourceUtils.releaseConnection(con, dataSource);
        }
    }

}
