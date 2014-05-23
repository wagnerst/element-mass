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
	public Set<Molecule> calculatePossibleElements() {
		result = new HashSet<Molecule>();
		backlog = new Stack<RestMolecule>();
		System.out.println("At start of calculatePossibleElements: " + result);
		System.out.println("mByC: " + mByC);
		System.out.println("Selected: " + selectedElements);
		List<Isotope> selected = convertToFlatIsotopeList();
		
		fillBacklogInitially(selected);
		System.out.println("backlog: " + backlog);
		
		while (!backlog.isEmpty()) {
			System.out.println("Backlog: " + backlog);
			RestMolecule restMolecule = backlog.pop();
			System.out.println("RestMolecule: " + restMolecule);
			for (Isotope isotope : selected) {
				System.out.println("Test element: " + isotope.getElement());
				System.out.println("Isotope mass: " + isotope.getMass());
				int restMass = restMolecule.getRest() - isotope.getMass();
				System.out.println("restMass: " + restMass);
				if (restMass == 0) {
					restMolecule = new RestMolecule(restMolecule, isotope.getElement(), restMass);
					result.add(restMolecule);
					System.out.println("Result: " + restMolecule);
				} else if (restMass > 0) {
					RestMolecule newRestMolecule = new RestMolecule(restMolecule, isotope.getElement(), restMass);
					if (notContainedAsPrefix(newRestMolecule)) {
						backlog.push(newRestMolecule);
						System.out.println("Push: " + newRestMolecule + ", " + restMass);
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
		for (Isotope isotope : selected) {
			int restMass = mByC - isotope.getMass();
			if (restMass == 0) {
				Molecule molecule = new Molecule();
				molecule.add(isotope.getElement());
				result.add(molecule);
			} else if (restMass > 0) {
				RestMolecule restMolecule = new RestMolecule(isotope.getElement(), restMass);
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

	private void recursiveSubtract(int in, Isotope isotope, 
			Molecule current) {
		int newIn = in - isotope.getMass();
		if (newIn > 0) {
			subtractAllIsotopeMasses(current, isotope, newIn);	
		} else if (newIn == 0) {
			System.out.println("Isotope: " + isotope + " of " + isotope.getElement());
			System.out.println("Current: " + current);
			System.out.println("in: " + in + ", newIn: " + newIn);
			foundSolution(current, isotope);		
		}
	}

	private void foundSolution(Molecule current, Isotope isotope) {
		current.add(isotope.getElement());
		System.out.println("Result before: " + result);
		result.add(current);
		System.out.println("Solution: " + current);
		System.out.println("Current result: " + result);
	}

	private void subtractAllIsotopeMasses(Molecule current, Isotope isotope,
			int rest) {
		current.add(isotope.getElement());
		List<Isotope> selected = convertToFlatIsotopeList();
		for (Isotope nextIsotope : selected) {
			recursiveSubtract(rest, nextIsotope, current);
		}
		current.remove(isotope.getElement());
	}

	/**
	 * @param selectedElements the elements to set
	 */
	public void setSelectedElements(Set<Element> selectedElements) {
		this.selectedElements = selectedElements;
	}

	/**
	 * @return the selected elements
	 */
	public Set<Element> getSelectedElements() {
		return selectedElements;
	}

	/**
	 * @return the mByC
	 */
	public double getmByC() {
		return mByC;
	}

	/**
	 * @param mByC the mByC to set
	 */
	public void setmByC(int mByC) {
		this.mByC = mByC;
	}
	
}
