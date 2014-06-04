/*
 *  Copyright 2014 Stefan Wagner
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
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
