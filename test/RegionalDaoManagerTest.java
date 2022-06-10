package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Mockito;

import trade.LondonDao;
import trade.NewyorkDao;
import trade.Region;
import trade.RegionalDao;
import trade.RegionalDaoManager;
import trade.TokyoDao;

class RegionalDaoManagerTest {
	
	  @Mock
	   RegionalDao regionalDao;
	  
	  RegionalDaoManager regionalDaoManager = new RegionalDaoManager();

	@Test  
	void Positive_Test_London() {
		RegionalDaoManager rdm = new RegionalDaoManager();
		
		Class<? extends RegionalDao> actual = rdm.getRegionalDao(Region.LONDON).getClass();
		Class<? extends LondonDao> expected = new LondonDao().getClass();
		
		assertEquals(expected, actual);
	}
	
	@Test 
	void Positive_Test_Tokyo() {
		RegionalDaoManager rdm = new RegionalDaoManager();
		
		Class<? extends RegionalDao> actual = rdm.getRegionalDao(Region.TOKYO).getClass();
		Class<? extends TokyoDao> expected = new TokyoDao().getClass();
		
		assertEquals(expected, actual);
	}  
	 
	@Test 
	void Positive_Test_Newyork() {
		RegionalDaoManager rdm = new RegionalDaoManager();
		
		Class<? extends RegionalDao> actual = rdm.getRegionalDao(Region.NEWYORK).getClass();
		Class<? extends NewyorkDao> expected = new NewyorkDao().getClass();
		
		assertEquals(expected, actual);
	}  
	
	@Test
    public void Exception_Test() {

        Executable e  = () -> regionalDaoManager.getRegionalDao(Region.valueOf("someother value"));

        assertThrows(IllegalArgumentException.class,e);

    }
	
}
