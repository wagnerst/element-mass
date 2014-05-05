package em.test;

import static org.junit.Assert.*;
import em.Element;
import em.Isotope;

import org.junit.Test;

public class ElementTest {
	
	Element e = new Element("X", 1);

	@Test
	public void testMass() {
		e = new Element("Y", 12);
		assertEquals(e.getNumber(), 12);
	}
	
	@Test
	public void addThreeIsotopes() {
		e.addIsotopes(2, 3, 4);
		assertTrue(e.getIsotopes().contains(new Isotope(2)));
	}

}
