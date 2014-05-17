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
	
	@Test
	public void testOutputSelectedMasses() {
		elements.add(BE);
		calc.setSelectedElements(elements);
		assertTrue(elements.equals(calc.getSelectedElements()));
	}
	
	@Test
	public void testReturnMByC() {
		calc.setmByC(2);
		assertTrue(2 == calc.getmByC());
	}
	
	@Before
	public void setup() {
		elements = new HashSet<Element>();
		calc = new Calculator();
		elements.add(FE);
		elements.add(C);
		calc.setSelectedElements(elements); 
		calc.setmByC(68);
	}
	
	@Test
	public void testCalculatePossibleElementsNotEmpty() {
		Set<Molecule> result = calc.calculatePossibleElements();
		assertFalse(result.isEmpty());
	}
	
	@Test
	public void testCalculatePossibleElementsContainsElements() {
		Set<Molecule> result = calc.calculatePossibleElements();
		for (Molecule m : result) {
			assertTrue(m.contains(FE));
			assertTrue(m.contains(C));
			assertFalse(m.contains(UUO));
		}
	}
	
	@Test
	public void testCalculatePossibleElementsExactly() {
		Set<Molecule> result = calc.calculatePossibleElements();
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
		calc.setSelectedElements(elements); 
		calc.setmByC(70);
		Set<Molecule> result = calc.calculatePossibleElements();
		for (Molecule m : result) {
			assertTrue(m.toString().equals("CFe") ||
					m.toString().equals("CNi"));
		}
	}

}
