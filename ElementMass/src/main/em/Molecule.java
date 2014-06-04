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
package em;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class represents molecules. They are the
 * result of the calculation. For our purposes, a
 * molecule is a number of elements with an amount
 * of occurrences each.
 *
 */
public class Molecule {
	private List<Isotope> isotopes = new LinkedList<Isotope>();

	public Molecule() {
		super();
	}
	
	public Molecule(List<Isotope> isotopes) {
		this.isotopes = isotopes;
	}
	
	public List<Isotope> getIsotopes() {
		return isotopes;
	}
	
	public void setIsotopes(List<Isotope> isotopes) {
		this.isotopes = isotopes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		Map<Element, Integer> elementMap = new TreeMap<Element, Integer>();
		for (Isotope isotope : isotopes) {
			Element element = isotope.getElement();
			if (elementMap.containsKey(element)) {
				Integer count = elementMap.get(element);
				elementMap.put(element, new Integer(count.intValue() + 1));
			} else {
				elementMap.put(element, new Integer(1));
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Element element : elementMap.keySet()) {
			sb.append(element);
			if (elementMap.get(element).intValue() > 1) {
				sb.append(elementMap.get(element));
			}
		}
		return sb.toString();
	}

	/**
	 * @param element
	 * @return whether the given element is already in the molecule
	 */
	public boolean contains(Element element) {
		return this.isotopes.contains(element);
	}


	/**
	 * Adds one occurrence of the given element
	 * to the molecule.
	 * @param isotope to add
	 */
	public void add(Isotope isotope) {
		isotopes.add(isotope);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	
	public int getMostFrequentMass() {
		int mostFrequentMass = 0;
		for (Isotope isotope : isotopes) {
			mostFrequentMass += isotope.getElement().getMostFrequentIsotope().getMass();
		}
		return mostFrequentMass;
	}

	/**
	 * @param newMolecule
	 * @return if the new molecule is a prefix of this molecule
	 */
	public boolean hasPrefix(Molecule newMolecule) {
		List<Isotope> newIsotopes = newMolecule.getIsotopes();		
		return isotopes.containsAll(newIsotopes);
	}
	
	

}
