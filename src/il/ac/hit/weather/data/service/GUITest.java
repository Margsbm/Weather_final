package il.ac.hit.weather.data.service;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class GUITest {

	@Before
	public void setUp() throws Exception {
	
	}

	@Test
	public void testRoundTo2Decimals() throws IOException {
		GUI gui = new GUI();
		Double val = 25.433;
		assertEquals("25.4", gui.RoundTo2Decimals(val));
	}

}
