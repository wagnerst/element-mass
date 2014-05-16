package em;

import static org.junit.Assert.*;
import static em.Element.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class MoleculeTest {
	
	Molecule molecule;
	
	@Before
	public void setupMolecule() {
		List<Element> elementList = new LinkedList<Element>();
		elementList.add(H);
		elementList.add(H);
		elementList.add(O);
		molecule = new Molecule(elementList);
	}

	@Test
	public void testToString() {
		assertTrue(molecule.toString().equals("H2O"));
	}
	
	@Test 
	public void testAdd() {
		molecule.add(O);
		assertTrue(molecule.toString().equals("H2O2"));
	}
	
	@Test 
	public void testRemove() {
		molecule.remove(H);
		assertTrue(molecule.toString().equals("HO"));
	}
	
	@Test
	public void testGetElements() {
		Set<Element> elementSet = new HashSet<Element>();
		elementSet.add(H);
		elementSet.add(O);
		assertTrue(molecule.getElements().equals(elementSet));
	}
	
	

}
