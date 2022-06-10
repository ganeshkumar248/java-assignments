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
	 
	

}
