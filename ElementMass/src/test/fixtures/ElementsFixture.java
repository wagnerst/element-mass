/**
 * 
 */
package fixtures;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import fit.ColumnFixture;

import em.Element;
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
		Set<List<Element>> possibleElements = calc.calculatePossibleElements();
		return elements2String(possibleElements);
	}
	
	private String elements2String(Set<List<Element>> possibleElements) {
		StringBuffer buffer = new StringBuffer();
		for (List<Element> list : possibleElements) {
			int mass = 0;
			for (Element e : list) {
				buffer.append(e.getName());
				mass += e.getMostFrequentIsotope().getMass();
			}
			buffer.append(", " + mass + ";");
		}
//		int lastSemicolonIndex = buffer.lastIndexOf("; ");
//		buffer.delete(lastSemicolonIndex, lastSemicolonIndex+1);
		return buffer.toString();
	}

	private Set<Element> parseElements() {
		Set<Element> elements = new HashSet<Element>();
		StringTokenizer st = new StringTokenizer(selectedElements, ",");
		while (st.hasMoreTokens()) {
			st.nextToken();
			Element element = Element.H; //FIXME
			elements.add(element);
		}
		return elements;		
	}
	
	private int parseMByC() {
		return Integer.parseInt(mByC);
	}
}
