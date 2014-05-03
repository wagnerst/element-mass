package em.test;

import static org.junit.Assert.*;
import em.Element;

import org.junit.Test;

public class ElementTest {
	
	Element e = new Element("X", 1);

	@Test
	public void testMass() {
		e = new Element("Y", 12);
		assertEquals(e.getNumber(), 12);
	}

}
