package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Mockito;

import trade.RegionalDao;
import trade.RegionalDaoManager;
import trade.TradeDetails;

class RegionalDaoTest {

	
	@Mock
    RegionalDao regionalDao;
    RegionalDaoManager regionalDaoManager = new RegionalDaoManager();
	
	 @Test
	    public void getTradeDetails_Test() {
		 
	        Mockito.when(regionalDao.getTradeDetails(Mockito.any(long.class))).thenReturn(new TradeDetails());
	        TradeDetails td = regionalDao.getTradeDetails(1214578);
	        assertNotNull(td);
	    }
	 
	 @Test
	    public void Exception_Test() {
		 
	        Mockito.doThrow(RuntimeException.class).when(regionalDao.getTradeDetails(Mockito.any(long.class)));
	        Executable e = () -> regionalDao.getTradeDetails(12345678);
	        assertThrows(RuntimeException.class,e);
	    }
 
}
   