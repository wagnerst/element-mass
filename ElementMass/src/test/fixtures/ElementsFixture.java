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
		calc.setmByC(parseMByC());
		calc.setSelectedElements(parseElements());
		Set<Molecule> possibleElements = calc.calculatePossibleElements();
		return elements2String(possibleElements);
	}
	
	private String elements2String(Set<Molecule> possibleElements) {
		StringBuffer buffer = new StringBuffer();
		for (Molecule molecule : possibleElements) {
			int mass = 0;
			for (Element e : molecule.getElements()) {
				buffer.append(e.getName());
				mass += e.getMostFrequentIsotope().getMass();
			}
			buffer.append(", " + mass + "; ");
		}
		int lastSemicolonIndex = buffer.lastIndexOf("; ");
		buffer.delete(lastSemicolonIndex, lastSemicolonIndex+1);
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
