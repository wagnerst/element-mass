/**
 * 
 */
package em.calc;

import java.util.TreeMap;

import em.Element;
import em.Molecule;

/**
 * Adds the remaining mass to the molecule.
 * It is only used in the calculation.
 */
public class RestMolecule extends Molecule {

	private int rest;

	public RestMolecule(Element element, int restMass) {
		add(element);
		rest = restMass;
	}

	public RestMolecule(RestMolecule restMolecule, Element element, int restMass) {
		setSortedElementsMap(new TreeMap<Element, Integer>(restMolecule.getSortedElementsMap()));
		add(element);
		rest = restMass;
	}

	/**
	 * @return the rest
	 */
	public int getRest() {
		return rest;
	}

	/**
	 * @param rest the rest to set
	 */
	public void setRest(int rest) {
		this.rest = rest;
	}
	
	

}
