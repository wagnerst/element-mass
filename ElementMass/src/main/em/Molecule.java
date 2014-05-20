	package em;

import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * This class represents molecules. They are the
 * result of the calculation. For our purposes, a
 * molecule is a number of elements with an amount
 * of occurrences each.
 *
 */
public class Molecule {
	private SortedMap<Element, Integer> elements = new TreeMap<Element, Integer>();

	public Molecule() {
		super();
	}
	
	public Molecule(List<Element> elementList) {
		super();
		buildMap(elementList);
	}
	
	public SortedMap<Element, Integer>getSortedElementsMap() {
		return elements;
	}
	
	public void setSortedElementsMap(SortedMap<Element, Integer>elements) {
		this.elements = elements;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Element element : elements.keySet()) {
			sb.append(element);
			if (elements.get(element).intValue() > 1) {
				sb.append(elements.get(element));
			}
			
		}
		return sb.toString();
	}

	private void buildMap(List<Element> elementList) {
		for (Element element : elementList) {
			add(element);
		}
	}

	public boolean contains(Element element) {
		return this.elements.containsKey(element);
	}

	public Set<Element> getElements() {
		return elements.keySet();
	}

	/**
	 * Adds one occurrence of the given element
	 * to the molecule.
	 * @param element to add
	 */
	public void add(Element element) {
		if (elements.containsKey(element)) {
			Integer count = elements.get(element);
			int newCount = count.intValue() + 1;
			elements.put(element, newCount);
		} else {
			elements.put(element, Integer.valueOf(1));
		}	
	}

	/**
	 * Removes one occurrence of the given in the
	 * molecule. If the element is not part of the
	 * molecule, it does nothing.
	 * @param element to remove
	 */
	public void remove(Element element) {
		if (elements.containsKey(element)) {
			Integer count = elements.get(element);
			int newCount = count.intValue() - 1;
			elements.put(element, newCount);
		}
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
	
	

}
