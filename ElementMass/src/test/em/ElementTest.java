package em;

import static org.junit.Assert.*;

import java.util.Set;

import em.Isotope;
import static em.Element.*;

import org.junit.Test;

public class ElementTest {
		
	
	@Test
	public void testMostFrequentIsotope() {
		assertTrue(B.getMostFrequentIsotope().equals(new Isotope(B, 11)));
	}
	
	@Test
	public void testReflection() {
		Set<Element> elements = Element.allElements();
		assertTrue(elements.contains(CO));
		assertTrue(elements.contains(UUO));
	}

}
