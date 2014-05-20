package em.calc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import em.Element;
import em.Isotope;
import em.Molecule;

/**
 * This class is responsible for calculating the results
 * using the selected elements and the M/C value.
 * @author wagnerst
 *
 */
public class Calculator {
	
	private Set<Element> selectedElements;
	private int mByC;
	private Set<Molecule> result = new HashSet<Molecule>();
	private Set<RestMolecule> backlog = new HashSet<RestMolecule>();

	/**
	 * This method explores the complete space of possible
	 * isotope combinations from the isotopes of the elements
	 * set as selected elements fitting in mByC.
	 * @return the possibleElements
	 */
	public Set<Molecule> calculatePossibleElements() {
		result = new HashSet<Molecule>();
		backlog = new HashSet<RestMolecule>();
		System.out.println("At start of calculatePossibleElements: " + result);
		Molecule empty = new Molecule();
		List<Isotope> selected = convertToFlatIsotopeList();
		for (Isotope isotope : selected) {
			int restMass = mByC - isotope.getMass();
			if (restMass == 0) {
				empty = new Molecule();
				empty.add(isotope.getElement());
				result.add(empty);
			} else if (restMass > 0) {
				for (Isotope isotope2 : selected) {
					int restMass2 = restMass - isotope2.getMass();
					if (restMass2 == 0) {
						empty = new Molecule();
						empty.add(isotope.getElement());
						empty.add(isotope2.getElement());
						result.add(empty);
					} else if (restMass2 > 0) {
						for (Isotope isotope3 : selected) {
							int restMass3 = restMass2 - isotope3.getMass();
							if (restMass3 == 0) {
								empty = new Molecule();
								empty.add(isotope.getElement());
								empty.add(isotope2.getElement());
								empty.add(isotope3.getElement());
							} else if (restMass3 > 0) {
								System.out.println("There could be more solutions!");
							}
						}
					}
				}
			}
		}
		System.out.println("Result: " + result);
		return result;
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
