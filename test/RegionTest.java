package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import trade.Region;

class RegionTest {

	@Test
	void Region_Positive_Test() {
		
		Region actual = Region.LONDON;
		Region expected = Region.valueOf("LONDON");
		assertEquals(expected, actual);
	}

}
   