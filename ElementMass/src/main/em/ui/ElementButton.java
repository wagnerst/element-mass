package em.ui;

import javafx.scene.control.ToggleButton;

import em.Element;

public class ElementButton extends ToggleButton {
	
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
