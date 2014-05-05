/**
 * 
 */
package em;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wagnerst
 *
 */
public class Element {
	
	private int number;
	private String name;
	private List<Isotope> isotopes= new LinkedList<Isotope>();

	public Element(String name, int mass) {
		this.setName(name);
		this.number = mass;
	}
	
	/**
	 * @param isotope
	 */
	public void addIsotopes(int... isotopeMasses) {
		for (int mass : isotopeMasses) {
			this.isotopes.add(new Isotope(mass));
		}
	}

	/**
	 * @return the isotopes
	 */
	public List<Isotope> getIsotopes() {
		return isotopes;
	}

	/**
	 * @param isotopes the isotopes to set
	 */
	public void setIsotopes(List<Isotope> isotopes) {
		this.isotopes = isotopes;
	}

	/**
	 * @return the atomic number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the atomic number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
