package em.calc;

import java.util.List;

import em.Element;

/**
 * This class is responsible for calculating the results
 * using the selected elements and the M/C valude.
 * @author wagnerst
 *
 */
public class Calculator {
	
	private List<Element> selectedElements;
	private double mByC;

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

}
