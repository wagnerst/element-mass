package em.ui;

import javax.swing.JToggleButton;

import em.Element;

public class ElementButton extends JToggleButton {
	
	private static final long serialVersionUID = 326361047940014420L;
	private Element element;
	
	public ElementButton(Element h) {
		super(h.getName());
		this.element = h;
	}
	/**
	 * @return the element
	 */
	public Element getElement() {
		return element;
	}
	/**
	 * @param element the element to set
	 */
	public void setElement(Element element) {
		this.element = element;
	}
}
