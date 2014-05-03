package em.calc.test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import em.Element;
import em.calc.Calculator;

import org.junit.Test;

public class CalculatorTest {

	Calculator calc = new Calculator();
	
	@Test
	public void testOutputSelectedMasses() {
		List<Element> elementList = new LinkedList<Element>();
		elementList.add(new Element("X", 37));
		calc.setSelectedElements(elementList);
		assertTrue(elementList.equals(calc.getSelectedElements()));
	}
	
	@Test
	public void returnMByC() {
		calc.setmByC(1.5);
		assertTrue(1.5 == calc.getmByC());
	}

}
