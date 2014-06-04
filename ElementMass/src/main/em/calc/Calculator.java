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
package em.calc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import em.Element;
import em.Isotope;
import em.Molecule;

/**
 * This class is responsible for calculating the results
 * using the selected elements and the M/C value.
 *
 */
public class Calculator {
	
	private Set<Element> selectedElements;
	private int mByC;
	private Set<Molecule> result = new HashSet<Molecule>();
	private Stack<RestMolecule> backlog = new Stack<RestMolecule>();
	
	/**
	 * This method explores the complete space of possible
	 * isotope combinations from the isotopes of the elements
	 * set as selected elements fitting in mByC.
	 * @return the possibleElements
	 */
	public Set<Molecule> calculatePossibleElements(Set<Element> selectedElements,
			int mByC) {
		this.selectedElements = selectedElements;
		this.mByC = mByC;
		result = new HashSet<Molecule>();
		backlog = new Stack<RestMolecule>();
		List<Isotope> selected = convertToFlatIsotopeList();
		
		fillBacklogInitially(selected);
		
		while (!backlog.isEmpty()) {
			RestMolecule restMolecule = backlog.pop();
			for (Isotope isotope : selected) {
				int restMass = restMolecule.getRest() - isotope.getMass();
				if (restMass == 0) {
					List<Isotope> isotopeList = new LinkedList<Isotope>(); 
					isotopeList.addAll(restMolecule.getIsotopes());
					isotopeList.add(isotope);
					result.add(new Molecule(isotopeList));
				} else if (restMass > 0) {
					List<Isotope> isotopeList = new LinkedList<Isotope>(); 
					isotopeList.addAll(restMolecule.getIsotopes());
					isotopeList.add(isotope);
					RestMolecule newRestMolecule = new RestMolecule(isotopeList, restMass);
					if (notContainedAsPrefix(newRestMolecule)) {
						backlog.push(newRestMolecule);
					}
					
				}
			}
		}
		System.out.println("Final result: " + result);
		return result;
	}

	private boolean notContainedAsPrefix(Molecule newMolecule) {
		for (Molecule molecule : result) {
			if (molecule.hasPrefix(newMolecule)) {
				return false;
			}
		}
		for (Molecule molecule : backlog) {
			if (molecule.hasPrefix(newMolecule)) {
				return false;
			}
		}
		return true;
	}

	private void fillBacklogInitially(List<Isotope> selected) {
		fillBacklog(selected, mByC, new RestMolecule());
	}
	
	private void fillBacklog(List<Isotope> selected, int currentMass, 
			RestMolecule existingRestMolecule) {
		for (Isotope isotope : selected) {
			int restMass = currentMass - isotope.getMass();
			if (restMass == 0) {
				Molecule molecule = new Molecule();
				molecule.add(isotope);
				result.add(molecule);
			} else if (restMass > 0) {
				List<Isotope> isotopeList = new LinkedList<Isotope>(); 
				isotopeList.addAll(existingRestMolecule.getIsotopes());
				isotopeList.add(isotope);
				RestMolecule restMolecule = new RestMolecule(isotopeList, restMass);
				backlog.push(restMolecule);
			}
		}
	}

	private List<Isotope> convertToFlatIsotopeList() {
		List<Isotope> isotopes = new LinkedList<Isotope>(); 
		for (Element element : selectedElements) {
			isotopes.addAll(element.getIsotopes());
		}
		return isotopes;
	}
	
}
