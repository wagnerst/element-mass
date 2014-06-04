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
/**
 * 
 */
package fixtures;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import fit.ColumnFixture;

import em.Element;
import em.Molecule;
import em.calc.Calculator;

/**
 * This class connects the acceptance test in the
 * HTML table to the implementation of Calculator.
 */
public class ElementsFixture extends ColumnFixture {

	public String selectedElements;
	public String mByC;
	
	public String calculateElements() {
		Calculator calc = new Calculator();
		Set<Molecule> possibleElements = calc.calculatePossibleElements(parseElements(), parseMByC());
		return elements2String(possibleElements);
	}
	
	private String elements2String(Set<Molecule> possibleElements) {
		StringBuffer buffer = new StringBuffer();
		return buffer.toString().trim();
	}

	private Set<Element> parseElements() {
		Set<Element> elements = new HashSet<Element>();
		StringTokenizer st = new StringTokenizer(selectedElements, ",");
		while (st.hasMoreTokens()) {
			String name = st.nextToken();
			name = name.trim();
			Element element = Element.getElementByName(name);
			elements.add(element);
		}
		return elements;		
	}
	
	private int parseMByC() {
		return Integer.parseInt(mByC);
	}
}
