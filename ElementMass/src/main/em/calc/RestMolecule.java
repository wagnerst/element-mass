/**
 * 
 */
package em.calc;

import java.util.List;

import em.Isotope;
import em.Molecule;

/**
 * Adds the remaining mass to the molecule.
 * It is only used in the calculation.
 */
public class RestMolecule extends Molecule {

	private int rest;
	
	public RestMolecule() {
		super();
		rest = 0;
	}

	public RestMolecule(Isotope isotope, int restMass) {
		add(isotope);
		rest = restMass;
	}

	public RestMolecule(List<Isotope> isotopes, int restMass) {
		setIsotopes(isotopes);
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
