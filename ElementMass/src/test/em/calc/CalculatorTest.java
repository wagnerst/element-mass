package em.calc;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import em.Element;
import em.calc.Calculator;

import org.junit.Test;

public class CalculatorTest {

	private Calculator calc = new Calculator();
	private List<Element> elementList = new LinkedList<Element>();
	
	@Test
	public void testOutputSelectedMasses() {
		elementList.add(new Element("X", 37));
		calc.setSelectedElements(elementList);
		assertTrue(elementList.equals(calc.getSelectedElements()));
	}
	
	@Test
	public void testReturnMByC() {
		calc.setmByC(1.5);
		assertTrue(1.5 == calc.getmByC());
	}
	
	@Test
	public void testElementsInMass() {
		Element thirty = new Element("Thirty", 30);
		thirty.addIsotopes(30);
		elementList.add(thirty);
		Element ten = new Element("Ten", 10);
		ten.addIsotopes(10);
		elementList.add(ten);
		calc.setSelectedElements(elementList);
		calc.setmByC(100);
		Set<Element> result = calc.elementsInMass();
		assertTrue(result.contains(ten));
		assertFalse(result.contains(thirty));
	}

}
