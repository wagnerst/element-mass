package em.calc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import em.Element;
import em.Isotope;

/**
 * This class is responsible for calculating the results
 * using the selected elements and the M/C valude.
 * @author wagnerst
 *
 */
public class Calculator {
	
	private List<Element> selectedElements;
	private double mByC;
	private Set<Element> possibleElements = new HashSet<Element>();

	/**
	 * @return the possibleElements
	 */
	public Set<Element> getPossibleElements() {
		return possibleElements;
	}

	/**
	 * @param selectedElements the elements to set
	 */
	public void setSelectedElements(List<Element> selectedElements) {
		this.selectedElements = selectedElements;
	}

	/**
	 * @return the selected elements
	 */
	public List<Element> getSelectedElements() {
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
	public void setmByC(double mByC) {
		this.mByC = mByC;
	}

	public Set<Element> elementsInMass() {
		for (Element element : selectedElements) {
			for (Isotope iso : element.getIsotopes()) {
				if ((this.mByC % iso.getMass()) == 0)					
					possibleElements.add(element);
			}
		}
		return possibleElements;
	}

}
