package em;

/**
 * An isotope of an element
 * @author wagnerst
 *
 */
public class Isotope {
	
	private int mass;
	private Element element;

	/**
	 * @param mass
	 */
	public Isotope(Element element, int mass) {
		super();
		this.mass = mass;
		this.element = element;
	}

	/**
	 * @return the mass
	 */
	public int getMass() {
		return mass;
	}

	/**
	 * @param mass the mass to set
	 */
	public void setMass(int mass) {
		this.mass = mass;
	}

	/**
	 * @return the element
	 */
	public Element getElement() {
		return element;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass().equals(this.getClass())) {
			return ((Isotope)obj).getMass() == this.getMass();
		} else {
			return super.equals(obj);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "" + mass;
	}

}
