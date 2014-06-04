package em.calc;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import em.Element;
import em.Molecule;
import em.calc.Calculator;
import static em.Element.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calc = new Calculator();
	private Set<Element> elements = new HashSet<Element>();
	
	@Before
	public void setup() {
		elements = new HashSet<Element>();
		calc = new Calculator();
		elements.add(FE);
		elements.add(C);
	}
	
	@Test
	public void testCalculatePossibleElementsNotEmpty() {
		Set<Molecule> result = calc.calculatePossibleElements(elements, 68);
		assertFalse(result.isEmpty());
	}
	
	@Test
	public void testCalculatePossibleElementsExactly() {
		Set<Molecule> result = calc.calculatePossibleElements(elements, 68);
		for (Molecule m : result) {
			assertTrue(m.toString().equals("CFe"));
		}
	}
	
	@Test
	public void threeSelectedElements() {
		System.out.println();
		System.out.println("threeSelectedElements");
		elements = new HashSet<Element>();
		calc = new Calculator();
		elements.add(FE);
		elements.add(C);
		elements.add(NI);
		Set<Molecule> result = calc.calculatePossibleElements(elements, 70);
		for (Molecule m : result) {
			assertTrue(m.toString().equals("CFe") ||
					m.toString().equals("CNi"));
		}
	}

}
