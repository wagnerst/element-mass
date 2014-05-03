/**
 * 
 */
package em;

/**
 * @author wagnerst
 *
 */
public class Element {
	
	private int number;
	private String name;

	public Element(String name, int mass) {
		this.setName(name);
		this.number = mass;
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
