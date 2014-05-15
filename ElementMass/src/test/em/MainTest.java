package em;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import em.Main;
import em.Element;

import org.junit.Test;

public class MainTest {

	Main m = new Main("Test");
	
	@Test
	public void testElementSet() {
		Set<Element> s = new HashSet<Element>();
		s.add(Element.BE);
		s.add(Element.H);
		s.add(Element.HE);
		m.setSelectedElements(s);
		assertEquals(s, m.getSelectedElements());
	}

}
