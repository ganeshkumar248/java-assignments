package test;

import static org.junit.jupiter.api.Assertions.*;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import ds.MySqlDataSource;
import ds.OracleDataSource;
import trade.LondonDao;
import trade.NewyorkDao;

class NewYorkDaoTest {

	@Test 
	void positiveTest() {
		NewyorkDao dao = new NewyorkDao();
		Class<? extends DataSource> actual = dao.getDataSource().getClass();
		Class<? extends OracleDataSource> expected = new OracleDataSource().getClass();
		
		assertEquals(expected, actual);
	}
	
	@Test 
	void Negative_Test() {
		LondonDao dao = new LondonDao();
		Class<? extends DataSource> actual = dao.getDataSource().getClass();
		Class<? extends DataSource> expected = new MySqlDataSource().getClass();
				
		assertNotEquals(expected, actual);
	}

}
 