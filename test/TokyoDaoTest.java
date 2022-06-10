package test;

import static org.junit.jupiter.api.Assertions.*;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import ds.OracleDataSource;
import ds.SqlServerDataSource;
import trade.LondonDao;
import trade.TokyoDao;

class TokyoDaoTest {

	@Test
	void test() {
		TokyoDao dao = new TokyoDao();
		Class<? extends DataSource> actual = dao.getDataSource().getClass();
		Class<? extends SqlServerDataSource> expected = new SqlServerDataSource().getClass();
		
		assertEquals(expected, actual);
	}
	
	@Test 
	void Negative_Test() {
		LondonDao dao = new LondonDao();
		Class<? extends DataSource> actual = dao.getDataSource().getClass();
		Class<? extends DataSource> expected = new OracleDataSource().getClass();
				
		assertNotEquals(expected, actual);
	}

}
  