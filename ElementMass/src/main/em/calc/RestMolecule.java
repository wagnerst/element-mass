/**
 * 
 */
package em.calc;

import em.Molecule;

/**
 * Adds the remaining mass to the molecule.
 * It is only used in the calculation.
 */
public class RestMolecule extends Molecule {
	
	private int rest;

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
