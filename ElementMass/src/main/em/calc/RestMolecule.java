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
