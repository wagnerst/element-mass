package em;

import static org.junit.Assert.*;
import static em.Element.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MoleculeTest {
	
	Molecule molecule;
	
	@Before
	public void setupMolecule() {
		List<Isotope> isotopeList = new LinkedList<Isotope>();
		isotopeList.add(H.getMostFrequentIsotope());
		isotopeList.add(H.getMostFrequentIsotope());
		isotopeList.add(O.getMostFrequentIsotope());
		molecule = new Molecule(isotopeList);
	}

	@Test
	public void testToString() {
		assertTrue(molecule.toString().equals("H2O"));
	}
	
	@Test 
	public void testAdd() {
		molecule.add(O.getMostFrequentIsotope());
		assertTrue(molecule.toString().equals("H2O2"));
	}
	
	@Test
	public void testHasPrefix() {
		List<Isotope> shorterIsotopeList = new LinkedList<Isotope>();
		shorterIsotopeList.add(H.getMostFrequentIsotope());
		shorterIsotopeList.add(H.getMostFrequentIsotope());
		Molecule prefix = new Molecule(shorterIsotopeList);
		assertTrue(molecule.hasPrefix(prefix));
	}
	
	@Test
	public void getMostFrequentMass() {
		assertTrue(molecule.getMostFrequentMass() == 18);
	}
	
	

}
