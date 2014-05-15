package em.calc;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import em.Element;
import em.calc.Calculator;
import static em.Element.*;

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
	
	@Test
	public void testCalculatePossibleElements() {
		elements.add(FE);
		elements.add(C);
		calc.setSelectedElements(elements); 
		calc.setmByC(68);
		Set<List<Element>> result = calc.calculatePossibleElements();
		assertFalse(result.isEmpty());
//		for (List<Element> l : result) {
//			assertTrue(l.contains(FE));
//			assertTrue(l.contains(C));
//			assertFalse(l.contains(UUO));
//		}
	}

}
