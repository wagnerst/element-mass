package em.ui;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import em.Element;
import em.calc.Calculator;

public class ResultWindow extends JFrame {

	public ResultWindow() throws HeadlessException {
		super();
		initUI();
	}

	private static final long serialVersionUID = -587902911845301729L;
	private JPanel panel;
	private Calculator calc;

	public final void initUI() {

		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		add(panel);

		pack();

		setLocationRelativeTo(null);
	}

	/**
	 * @return the calc
	 */
	public Calculator getCalc() {
		return calc;
	}

	/**
	 * @param calc the calc to set
	 */
	public void setCalc(Calculator calc) {
		this.calc = calc;
	}
	
	public void update() {
		panel.removeAll();
		for (List<Element> l : calc.calculatePossibleElements()) {
			for (Element e : l) {
				panel.add(new JLabel(e.getName()));
			}
		}
		pack();
		setVisible(true);
		toFront();
	}
	
}
