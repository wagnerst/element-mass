package em.calc;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import em.Element;
import em.Isotope;

/**
 * This class is responsible for calculating the results
 * using the selected elements and the M/C value.
 * @author wagnerst
 *
 */
public class Calculator {
	
	private Set<Element> selectedElements;
	private int mByC;
	private Set<List<Element>> result = new HashSet<List<Element>>();

	/**
	 * @return the possibleElements
	 */
	public Set<List<Element>> calculatePossibleElements() {
		List<Element> initial = new LinkedList<Element>();
		List<Isotope> selected = convertToFlatIsotopeList();
		Iterator<Isotope> iterator = selected.iterator();
		recursiveSubtract(mByC, iterator, initial);
		return result;
	}

	private List<Isotope> convertToFlatIsotopeList() {
		List<Isotope> isotopes = new LinkedList<Isotope>(); 
		for (Element element : selectedElements) {
			isotopes.addAll(element.getIsotopes());
		}
		return isotopes;
	}

	private List<Element> recursiveSubtract(int in, Iterator<Isotope> verticalIterator, 
			List<Element> current) {
		Isotope isotope = verticalIterator.next();
		int newIn = in - isotope.getMass();
		System.out.print("Isotope of " + isotope.getElement() + " (" 
				+ in + " - " + isotope.getMass() + " = " + newIn + ")");
		if (newIn > 0) {
			List<Element> returnedCurrent = goRight(current, isotope, newIn);
			if (verticalIterator.hasNext()) {
				System.out.println("goDown1");
				returnedCurrent = goDown(verticalIterator, newIn, returnedCurrent);	
			}
			System.out.println(" goLeft");
			return returnedCurrent;
			
		} else if (newIn == 0) {
			foundSolution(current, isotope);
			return goLeft(current);
		} else {
			if (verticalIterator.hasNext()) {
				System.out.println("goDown2");
				return goDown(in, verticalIterator, current);
			} else {
				return goUp(current);
			}
		}
	}

	private void foundSolution(List<Element> current, Isotope isotope) {
		current.add(isotope.getElement());
		result.add(current);
	}

	private List<Element> goDown(int in, Iterator<Isotope> iterator,
			List<Element> current) {
		System.out.println(" goDown");
		List<Element> currentResult = recursiveSubtract(in, iterator, current);
		return currentResult;
	}

	private List<Element> goLeft(List<Element> current) {
		System.out.println(" goLeft");
		return current;
	}

	private List<Element> goUp(List<Element> currentResult) {
		System.out.println(" goUp");
		return currentResult;
	}

	private List<Element> goDown(Iterator<Isotope> iterator, int newIn,
			List<Element> returnedCurrent) {
		System.out.println(" goDown");
		List<Element> backtrackedCurrent = recursiveSubtract(newIn, iterator, returnedCurrent);
		return backtrackedCurrent;
	}

	private List<Element> goRight(List<Element> current, Isotope isotope,
			int newIn) {
		System.out.println(" goRight");
		current.add(isotope.getElement());
		List<Isotope> selected = convertToFlatIsotopeList();
		Iterator<Isotope> selectedIterator = selected.iterator();
		List<Element> returnedCurrent = recursiveSubtract(newIn, selectedIterator, current);
		return returnedCurrent;
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
