package em;

import static org.junit.Assert.*;

import org.junit.Test;

public class IsotopeTest {

	@Test
	public void testToString() {
		Isotope isotope = Element.H.getMostFrequentIsotope();
		assertTrue(isotope.toString().equals("1"));
	}

}
