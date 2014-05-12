package em;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import em.calc.Calculator;
import em.ui.ElementButton;
import em.ui.PeriodicTable;
import em.ui.ResultWindow;

/**
 * This class is the main application window. It shows the
 * periodic table, allows selecting elements and creates
 * the result window. 
 * @author wagnerst
 *
 */
public class Main extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1101541789786543434L;
	private Set<Element> selectedElements;
	private PeriodicTable periodicTable = new PeriodicTable();
	public JPanel panel;
	private JTextField mByCField = new JTextField();
	private Calculator calc;
	private ResultWindow resultWindow;

	public Main(String string) {
		super(string);
		calc = new Calculator();
		initUI();
	}
	
	/**
	 * Creates buttons for the periodic table.
	 */
	public final void initUI() {

		panel = new JPanel();
		panel.setLayout(new GridLayout(10, 18, 1, 1));
	
		periodicTable.createElementButtons(panel);
		
		periodicTable.addEmptyLabels(1);
		panel.add(new JLabel("M/C"));
		panel.add(mByCField);
	
		JButton button = new JButton("Run");
		button.addActionListener(this);
		panel.add(button);
		periodicTable.addEmptyLabels(14);
	
		add(panel);

		pack();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	/**
	 * Creates a threat for running the windows.
	 * @param args
	 */
	public static void main(String[] args) {	
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                Main appFrame = new Main("ElementMass");
                ResultWindow resultWindow = new ResultWindow();
                appFrame.setResultWindow(resultWindow);
                resultWindow.setMain(appFrame);
                resultWindow.setCalc(appFrame.getCalc());
                appFrame.setVisible(true);
            }
        });
     
	}

	public Calculator getCalc() {
		return this.calc;
	}

	public void setResultWindow(ResultWindow resultWindow) {
		this.resultWindow = resultWindow;
		
	}

	public void setSelectedElements(Set<Element> selectedElements) {
		this.selectedElements = selectedElements;
	}

	public Set<Element> getSelectedElements() {
		return selectedElements;
	}

	/**
	 * If the run button was pressed, it checks
	 * all element buttons if they have been selected,
	 * passes the corresponding elements to the calculation
	 * and notifies the resultWindow.
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 **/
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Run")) {
			List<Element> elementList = new LinkedList<Element>();
			for (ElementButton eb : periodicTable.getButtonList()) {
				if (eb.getSelectedObjects() != null) {
					elementList.add(eb.getElement());
				}
			}
			calc.setSelectedElements(elementList);
			calc.setmByC(Double.parseDouble(mByCField.getText()));
			calc.elementsInMass();
			resultWindow.update();
		}
	}

}
