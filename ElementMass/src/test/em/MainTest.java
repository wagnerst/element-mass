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
		s.add(new Element("A", 1));
		s.add(new Element("B", 2));
		s.add(new Element("C", 3));
		m.setSelectedElements(s);
		assertEquals(s, m.getSelectedElements());
	}

}
