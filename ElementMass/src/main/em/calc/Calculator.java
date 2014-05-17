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
	private static Set<Molecule> result = new HashSet<Molecule>();

	/**
	 * This method explores the complete space of possible
	 * isotope combinations from the isotopes of the elements
	 * set as selected elements fitting in mByC.
	 * @return the possibleElements
	 */
	public Set<Molecule> calculatePossibleElements() {
		result = new HashSet<Molecule>();
		System.out.println("At start of calculatePossibleElements: " + result);
		Molecule empty = new Molecule();
		List<Isotope> selected = convertToFlatIsotopeList();
		for (Isotope isotope : selected) {
			recursiveSubtract(mByC, isotope, empty);
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
