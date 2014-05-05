package em;

/**
 * An isotope of an element
 * @author wagnerst
 *
 */
public class Isotope {
	
	private int mass;

	/**
	 * @param mass
	 */
	public Isotope(int mass) {
		super();
		this.mass = mass;
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

}
