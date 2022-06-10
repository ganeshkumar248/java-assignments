package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import trade.LondonDao;
import trade.Region;
import trade.RegionalDao;
import trade.RegionalDaoManager;
import trade.TokyoDao;
import trade.TradeDetails;
import trade.TradeService;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
	
	 @Spy
	    private TradeService tradeService = new TradeService();

	    @InjectMocks
	    private TradeService mts;
 
	    @Mock
	    private RegionalDao regionalDao;

	    @Mock
	    private RegionalDaoManager regionalDaoManager;

	    @Mock
	    private TradeDetails tradeDetails;

	@Test
	void London_Test() {
		TradeService ts = new TradeService();
		Region actual = ts.getTradeRegion(12145671);
		Region expected = Region.LONDON;
		
		assertEquals(expected, actual);
	} 
	
	@Test
	void Newyork_Test() {
		TradeService ts = new TradeService();
		Region actual = ts.getTradeRegion(12232140);
		Region expected = Region.NEWYORK;
		
		assertEquals(expected, actual);
	}
	
	@Test
	void Tokyo_Test() {
		TradeService ts = new TradeService();
		Region actual = ts.getTradeRegion(12345678);
		Region expected = Region.TOKYO;
		
		assertEquals(expected, actual);
	} 
	
	@Test 
	void Exception_Test() {
		TradeService ts = new TradeService();
		Executable e = () -> ts.getTradeRegion(12576615);
		
		assertThrows(IllegalArgumentException.class, e);
	}
	 
	@Test
	void getTradeDetails_London() throws SQLException {
		
		Mockito.when(regionalDaoManager.getRegionalDao(Region.LONDON)).thenReturn(new LondonDao());
        Mockito.when(regionalDao.getDataSource().getConnection()).thenReturn(Mockito.any());
        
        Mockito.when(regionalDao.getTradeDetails(121456789)).thenReturn(new TradeDetails(121456789,Region.LONDON,1));
        Mockito.when(mts.getTradeDetails(121456789)).thenReturn(new TradeDetails());
	    
        TradeDetails actual = mts.getTradeDetails(12145678);
        TradeDetails expected = new TradeDetails();
        expected.setTradeId(12145678);
        expected.setStatus(0);
        expected.setRegion(Region.LONDON);

        assertEquals(expected,actual);
		
	} 
	
	@Test
	void getTradeDetails_Tokyo() throws SQLException {
		
		Mockito.when(regionalDaoManager.getRegionalDao(Region.TOKYO)).thenReturn(new TokyoDao());
        Mockito.when(regionalDao.getDataSource().getConnection()).thenReturn(Mockito.any());
        
        Mockito.when(regionalDao.getTradeDetails(123456789)).thenReturn(new TradeDetails(123456789,Region.TOKYO,1));
        Mockito.when(mts.getTradeDetails(123456789)).thenReturn(new TradeDetails());
	    
        TradeDetails actual = mts.getTradeDetails(12145678);
        TradeDetails expected = new TradeDetails();
        expected.setTradeId(12345678);
        expected.setStatus(0);
        expected.setRegion(Region.TOKYO); 

        assertEquals(expected,actual);
		
	}

	
	@Test
	void getTradeDetails_Newyork() throws SQLException {
		
		Mockito.when(regionalDaoManager.getRegionalDao(Region.NEWYORK)).thenReturn(new LondonDao());
        Mockito.when(regionalDao.getDataSource().getConnection()).thenReturn(Mockito.any());
        
        Mockito.when(regionalDao.getTradeDetails(122456789)).thenReturn(new TradeDetails(122456789,Region.NEWYORK,1));
        Mockito.when(mts.getTradeDetails(122456789)).thenReturn(new TradeDetails());
	    
        TradeDetails actual = mts.getTradeDetails(12245678);
        TradeDetails expected = new TradeDetails();
        expected.setTradeId(12245678);
        expected.setStatus(0);
        expected.setRegion(Region.NEWYORK);

        assertEquals(expected,actual);
		
	}


}
