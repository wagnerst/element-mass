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

		Element h = new Element("H", 1);
		h.addIsotopes(1, 2);
		addElementButton(h);
		addEmptyLabels(16);
		
		Element he = new Element("He", 2);
		he.addIsotopes(3, 4);
		addElementButton(he);
		
		Element li = new Element("Li", 3);
		li.addIsotopes(6, 7);
		addElementButton(li);
		
		Element be = new Element("Be", 4);
		be.addIsotopes(9);
		addElementButton(be);
		addEmptyLabels(10);
		
		Element b = new Element("B", 5);
		b.addIsotopes(10, 11);
		addElementButton(b);
		
		Element c = new Element("C", 6);
		c.addIsotopes(12, 13);
		addElementButton(c);
		
		Element n = new Element("N", 7);
		c.addIsotopes(14, 15);
		addElementButton(n);
		
		Element o = new Element("O", 8);
		o.addIsotopes(16, 17, 18);
		addElementButton(o);
		
		Element f = new Element("F", 9);
		f.addIsotopes(19);
		addElementButton(f);
		
		Element ne = new Element("Ne", 10);
		ne.addIsotopes(20, 21, 22);
		addElementButton(ne);
		
		Element na = new Element("Na", 11);
		na.addIsotopes(23);
		addElementButton(na);
		
		Element mg = new Element("Mg", 12);
		mg.addIsotopes(24, 25, 26);
		addElementButton(mg);
		addEmptyLabels(10);
		
		Element al = new Element("Al", 13);
		al.addIsotopes(27);
		addElementButton(al);
		
		Element si = new Element("Si", 14);
		si.addIsotopes(28, 29, 30);
		addElementButton(si);
		
		Element p = new Element("P", 15);
		p.addIsotopes(31);
		addElementButton(p);
		
		Element s = new Element("S", 16);
		s.addIsotopes(32, 33, 34, 36);
		addElementButton(s);
		
		Element cl = new Element("Cl", 17);
		cl.addIsotopes(35, 37);
		addElementButton(cl);
		
		Element ar = new Element("Ar", 18);
		ar.addIsotopes(36, 38, 40);
		addElementButton(ar);
		
		Element k = new Element("K", 19);
		k.addIsotopes(39, 40, 41);
		addElementButton(k);
		
		Element ca = new Element("Ca", 20);
		ca.addIsotopes(40, 42, 43, 44, 46, 48);
		addElementButton(ca);
		
		Element sc = new Element("Sc", 21);
		sc.addIsotopes(45);
		addElementButton(sc);
		
		Element ti = new Element("Ti", 22);
		ti.addIsotopes(46, 47, 48, 49, 50);
		addElementButton(ti);
		
		Element v = new Element("V", 23);
		v.addIsotopes(50, 51);
		addElementButton(v);
		
		Element cr = new Element("Cr", 24);
		cr.addIsotopes(50, 52, 53, 54);
		addElementButton(cr);
		
		Element mn = new Element("Mn", 25);
		mn.addIsotopes(55);
		addElementButton(mn);
		
		Element fe = new Element("Fe", 26);
		fe.addIsotopes(54, 56, 57, 58);
		addElementButton(fe);
		
		Element co = new Element("Co", 27);
		co.addIsotopes(59);
		addElementButton(co);
		
		Element ni = new Element("Ni", 28);
		ni.addIsotopes(58, 60, 61, 62, 64);
		addElementButton(ni);
		
		Element cu = new Element("Cu", 29);
		cu.addIsotopes(63, 65);
		addElementButton(cu);
		
		Element zn = new Element("Zn", 30);
		zn.addIsotopes(64, 66, 67, 68, 70);
		addElementButton(zn);
		
		Element ga = new Element("Ga", 31);
		ga.addIsotopes(69, 71);
		addElementButton(ga);
		
		Element ge = new Element("Ge", 32);
		ge.addIsotopes(70, 72, 73, 74, 76);
		addElementButton(ge);
		
		Element as = new Element("As", 33);
		as.addIsotopes(75);
		addElementButton(as);
		
		Element se = new Element("Se", 34);
		se.addIsotopes(74, 76, 77, 78, 80, 82);
		addElementButton(se);
		
		Element br = new Element("Br", 35);
		br.addIsotopes(79, 81);
		addElementButton(br);
		
		Element kr = new Element("Kr", 36);
		kr.addIsotopes(79, 80, 82, 83, 84, 86);
		addElementButton(kr);
		
		Element rb = new Element("Rb", 37);
		rb.addIsotopes(85, 87);
		addElementButton(rb);
		
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