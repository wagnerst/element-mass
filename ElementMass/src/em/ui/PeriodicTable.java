package em.ui;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import em.Element;


/**
 * This class is responsible for generating the
 * periodic table to display in the main window.
 * @author wagnerst
 *
 */
public class PeriodicTable {
	public List<ElementButton> buttonList;
	public JPanel panel;

	public PeriodicTable() {
	}
	
	private void addElementButton(Element e) {
		ElementButton eb = new ElementButton(e);
		buttonList.add(eb);
		panel.add(eb);
	}
	
	public void addEmptyLabels(int j) {
		for (int i = 0; i < j; i++) {
			panel.add(new JLabel(""));
		}
	}
	
	public void createElementButtons(JPanel panel) {
		buttonList = new LinkedList<ElementButton>();
		this.panel = panel;
	
		addElementButton(new Element("H", 1));
		addEmptyLabels(16);
		addElementButton(new Element("He", 2));
		addElementButton(new Element("Li", 3));
		addElementButton(new Element("Be", 4));
		addEmptyLabels(10);
		addElementButton(new Element("B", 5));
		addElementButton(new Element("C", 6));
		addElementButton(new Element("N", 7));
		addElementButton(new Element("O", 8));
		addElementButton(new Element("F", 9));
		addElementButton(new Element("Ne", 10));
		addElementButton(new Element("Na", 11));
		addElementButton(new Element("Mg", 12));
		addEmptyLabels(10);
		addElementButton(new Element("Al", 13));
		addElementButton(new Element("Si", 14));
		addElementButton(new Element("P", 15));
		addElementButton(new Element("S", 16));
		addElementButton(new Element("Cl", 17));
		addElementButton(new Element("Ar", 18));
		addElementButton(new Element("K", 19));
		addElementButton(new Element("Ca", 20));
		addElementButton(new Element("Sc", 21));
		addElementButton(new Element("Ti", 22));
		addElementButton(new Element("V", 23));
		addElementButton(new Element("Cr", 24));
		addElementButton(new Element("Mn", 25));
		addElementButton(new Element("Fe", 26));
		addElementButton(new Element("Co", 27));
		addElementButton(new Element("Ni", 28));
		addElementButton(new Element("Cu", 29));
		addElementButton(new Element("Zn", 30));
		addElementButton(new Element("Ga", 31));
		addElementButton(new Element("Ge", 32));
		addElementButton(new Element("As", 33));
		addElementButton(new Element("Se", 34));
		addElementButton(new Element("Br", 35));
		addElementButton(new Element("Kr", 36));
		addElementButton(new Element("Rb", 37));
		addElementButton(new Element("Sr", 38));
		addElementButton(new Element("Y", 39));
		addElementButton(new Element("Zr", 40));
		addElementButton(new Element("Nb", 41));
		addElementButton(new Element("Mo", 42));
		addElementButton(new Element("Tc", 43));
		addElementButton(new Element("Ru", 44));
		addElementButton(new Element("Rh", 45));
		addElementButton(new Element("Pd", 46));
		addElementButton(new Element("Ag", 47));
		addElementButton(new Element("Cd", 48));
		addElementButton(new Element("In", 49));
		addElementButton(new Element("Sn", 50));
		addElementButton(new Element("Sb", 51));
		addElementButton(new Element("Te", 52));
		addElementButton(new Element("I", 53));
		addElementButton(new Element("Xe", 54));
		addElementButton(new Element("Cs", 55));
		addElementButton(new Element("Ba", 56));
		addEmptyLabels(1);
		addElementButton(new Element("Hf", 72));
		addElementButton(new Element("Ta", 73));
		addElementButton(new Element("W", 74));
		addElementButton(new Element("Re", 75));
		addElementButton(new Element("Os", 76));
		addElementButton(new Element("Ir", 77));
		addElementButton(new Element("Pt", 78));
		addElementButton(new Element("Au", 79));
		addElementButton(new Element("Hg", 80));
		addElementButton(new Element("Tl", 81));
		addElementButton(new Element("Pb", 82));
		addElementButton(new Element("Bi", 83));
		addElementButton(new Element("Po", 84));
		addElementButton(new Element("At", 85));
		addElementButton(new Element("Rn", 86));
		addElementButton(new Element("Fr", 87));
		addElementButton(new Element("Ra", 88));
		addEmptyLabels(1);
		addElementButton(new Element("Rf", 104));
		addElementButton(new Element("Db", 105));
		addElementButton(new Element("Sg", 106));
		addElementButton(new Element("Bh", 107));
		addElementButton(new Element("Hs", 108));
		addElementButton(new Element("Mt", 109));
		addElementButton(new Element("Ds", 110));
		addElementButton(new Element("Rg", 111));
		addElementButton(new Element("Cn", 112));
		addElementButton(new Element("Uut", 113));
		addElementButton(new Element("Fl", 114));
		addElementButton(new Element("Uup", 115));
		addElementButton(new Element("Lv", 116));
		addElementButton(new Element("Uus", 117));
		addElementButton(new Element("Uuo", 118));
		addEmptyLabels(3);
		addElementButton(new Element("La", 57));
		addElementButton(new Element("Ce", 58));
		addElementButton(new Element("Pr", 59));
		addElementButton(new Element("Nd", 60));
		addElementButton(new Element("Pm", 61));
		addElementButton(new Element("Sm", 62));
		addElementButton(new Element("Eu", 63));
		addElementButton(new Element("Gd", 64));
		addElementButton(new Element("Tb", 65));
		addElementButton(new Element("Dy", 66));
		addElementButton(new Element("Ho", 67));
		addElementButton(new Element("Er", 68));
		addElementButton(new Element("Tm", 69));
		addElementButton(new Element("Yb", 70));
		addElementButton(new Element("Lu", 71));
		addEmptyLabels(3);
		addElementButton(new Element("Ac", 89));
		addElementButton(new Element("Th", 90));
		addElementButton(new Element("Pa", 91));
		addElementButton(new Element("U", 92));
		addElementButton(new Element("Np", 93));
		addElementButton(new Element("Pu", 94));
		addElementButton(new Element("Am", 95));
		addElementButton(new Element("Cm", 96));
		addElementButton(new Element("Bk", 97));
		addElementButton(new Element("Cf", 98));
		addElementButton(new Element("Es", 99));
		addElementButton(new Element("Fm", 100));
		addElementButton(new Element("Md", 101));
		addElementButton(new Element("No", 102));
		addElementButton(new Element("Lw", 103));
	}

	public List<ElementButton> getButtonList() {
		return buttonList;
	}
}