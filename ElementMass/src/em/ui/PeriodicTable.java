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
		
		Element sr = new Element("Sr", 38);
		sr.addIsotopes(84, 86, 87, 88);
		addElementButton(sr);
		
		Element y = new Element("Y", 39);
		y.addIsotopes(89);
		addElementButton(y);
		
		Element zr = new Element("Zr", 40);
		zr.addIsotopes(90, 91, 92, 94, 96);
		addElementButton(zr);
		
		Element nb = new Element("Nb", 41);
		nb.addIsotopes(93);
		addElementButton(nb);
		
		Element mo = new Element("Mo", 42);
		mo.addIsotopes(92, 94, 95, 96, 97, 98, 100);
		addElementButton(mo);
		
		Element tc = new Element("Tc", 43);
		tc.addIsotopes(98, 99);
		addElementButton(tc);
		
		Element ru = new Element("Ru", 44);
		ru.addIsotopes(96, 98, 99, 100, 101, 102, 104);
		addElementButton(ru);
		
		Element rh = new Element("Rh", 45);
		rh.addIsotopes(103);
		addElementButton(rh);
		
		Element pd = new Element("Pd", 46);
		pd.addIsotopes(102, 104, 105, 106, 108, 110);
		addElementButton(pd);
		
		Element ag = new Element("Ag", 47);
		ag.addIsotopes(107, 109);
		addElementButton(ag);
		
		Element cd = new Element("Cd", 48);
		cd.addIsotopes(106, 108, 110, 111, 112, 113, 114, 116);
		addElementButton(cd);
		
		Element in = new Element("In", 49);
		in.addIsotopes(113, 115);
		addElementButton(in);
		
		Element sn = new Element("Sn", 50);
		sn.addIsotopes(112, 114, 115, 116, 117, 118, 119, 120, 122, 124);
		addElementButton(sn);
		
		Element sb = new Element("Sb", 51);
		sb.addIsotopes(121, 123);
		addElementButton(sb);
		
		Element te = new Element("Te", 52);
		te.addIsotopes(120, 122, 123, 124, 125, 126, 128, 130);
		addElementButton(te);
		
		Element i = new Element("I", 53);
		i.addIsotopes(127);
		addElementButton(i);
		
		Element xe = new Element("Xe", 54);
		xe.addIsotopes(124, 126, 128, 129, 130, 131, 132, 134, 136);
		addElementButton(xe);
		
		Element cs = new Element("Cs", 55);
		cs.addIsotopes(133);
		addElementButton(cs);
		
		Element ba = new Element("Ba", 56);
		ba.addIsotopes(130, 132, 134, 135, 136, 137, 138);
		addElementButton(ba);
		addEmptyLabels(1);
		
		Element hf = new Element("Hf", 72);
		hf.addIsotopes(174, 176, 177, 178, 179, 180);
		addElementButton(hf);
		
		Element ta = new Element("Ta", 73);
		ta.addIsotopes(180, 181);
		addElementButton(ta);
		
		Element w = new Element("W", 74);
		w.addIsotopes(180, 182, 183, 184, 186);
		addElementButton(w);
		
		Element re = new Element("Re", 75);
		re.addIsotopes(185, 187);
		addElementButton(re);
		
		Element os = new Element("Os", 76);
		os.addIsotopes(184, 186, 187, 188, 189, 190, 192);
		addElementButton(os);
		
		Element ir = new Element("Ir", 77);
		ir.addIsotopes(191, 193);
		addElementButton(ir);
		
		Element pt = new Element("Pt", 78);
		pt.addIsotopes(190, 192, 194, 195, 196, 198);
		addElementButton(pt);
		
		Element au = new Element("Au", 79);
		au.addIsotopes(197);
		addElementButton(au);
		
		Element hg = new Element("Hg", 80);
		hg.addIsotopes(196, 198, 199, 200, 201, 202, 204);
		addElementButton(hg);
		
		Element tl = new Element("Tl", 81);
		tl.addIsotopes(203, 205);
		addElementButton(tl);
		
		Element pb = new Element("Pb", 82);
		pb.addIsotopes(204, 206, 207, 208);
		addElementButton(pb);
		
		Element bi = new Element("Bi", 83);
		bi.addIsotopes(209);
		addElementButton(bi);
		
		Element po = new Element("Po", 84);
		po.addIsotopes(209);
		addElementButton(po);
		
		Element at = new Element("At", 85);
		at.addIsotopes(210);
		addElementButton(at);
		
		Element rn = new Element("Rn", 86);
		rn.addIsotopes(222);
		addElementButton(rn);
		
		Element fr = new Element("Fr", 87);
		fr.addIsotopes(223);
		addElementButton(fr);
		
		Element ra = new Element("Ra", 88);
		ra.addIsotopes(226);
		addElementButton(ra);
		addEmptyLabels(1);
		
		Element rf = new Element("Rf", 104);
		rf.addIsotopes(253, 254, 255, 256, 257, 258, 259, 260, 261, 262);
		addElementButton(rf);
		
		Element db = new Element("Db", 105);
		db.addIsotopes(261, 262, 263);
		addElementButton(db);
		
		Element sg = new Element("Sg", 106);
		sg.addIsotopes(265, 266);
		addElementButton(sg);
		
		Element bh = new Element("Bh", 107);
		bh.addIsotopes(261, 262, 264);
		addElementButton(bh);
		
		Element hs = new Element("Hs", 108);
		hs.addIsotopes(268, 269, 270);
		addElementButton(hs);
		
		Element mt = new Element("Mt", 109);
		mt.addIsotopes(266, 267, 268, 270, 274, 275, 276);
		addElementButton(mt);
		
		Element ds = new Element("Ds", 110);
		ds.addIsotopes(267, 268, 269, 270, 271, 272, 273, 279, 280, 281, 282);
		addElementButton(ds);
		
		Element rg = new Element("Rg", 111);
		rg.addIsotopes(272, 274, 278, 279, 280);
		addElementButton(rg);
		
		Element cn = new Element("Cn", 112);
		cn.addIsotopes(277, 278, 279, 280, 282, 283, 284, 285);
		addElementButton(cn);
		
		Element uut = new Element("Uut", 113);
		uut.addIsotopes(278, 283, 284, 285, 286, 287);
		addElementButton(uut);
		
		Element fl = new Element("Fl", 114);
		fl.addIsotopes(286, 287, 288, 289);
		addElementButton(fl);
		
		Element uup = new Element("Uup", 115);
		uup.addIsotopes(287, 288, 289, 290, 291);
		addElementButton(uup);
		
		Element lv = new Element("Lv", 116);
		lv.addIsotopes(289, 290, 291, 292, 293);
		addElementButton(lv);
		
		Element uus = new Element("Uus", 117);
		uus.addIsotopes(291, 292);
		addElementButton(uus);
		
		Element uuo = new Element("Uuo", 118);
		uuo.addIsotopes(294);
		addElementButton(uuo);
		addEmptyLabels(3);
		
		Element la = new Element("La", 57);
		la.addIsotopes(138, 139);
		addElementButton(la);
		
		Element ce = new Element("Ce", 58);
		ce.addIsotopes(136, 138, 140, 142);
		addElementButton(ce);
		
		Element pr = new Element("Pr", 59);
		pr.addIsotopes(141);
		addElementButton(pr);
		
		Element nd = new Element("Nd", 60);
		nd.addIsotopes(142, 143, 144, 145, 146, 148, 150);
		addElementButton(nd);
		
		Element pm = new Element("Pm", 61);
		pm.addIsotopes(145);
		addElementButton(pm);
		
		Element sm = new Element("Sm", 62);
		sm.addIsotopes(144, 147, 148, 149, 150, 152, 154);
		addElementButton(sm);
		
		Element eu = new Element("Eu", 63);
		eu.addIsotopes(151, 153);
		addElementButton(eu);
		
		Element gd = new Element("Gd", 64);
		gd.addIsotopes(152, 154, 155, 156, 157, 158, 160);
		addElementButton(gd);
		
		Element tb = new Element("Tb", 65);
		tb.addIsotopes(159);
		addElementButton(tb);
		
		Element dy = new Element("Dy", 66);
		dy.addIsotopes(156, 158, 160, 161, 162, 163, 164);
		addElementButton(dy);
		
		Element ho = new Element("Ho", 67);
		ho.addIsotopes(165);
		addElementButton(ho);
		
		Element er = new Element("Er", 68);
		er.addIsotopes(162, 164, 166, 167, 168, 170);
		addElementButton(er);
		
		Element tm = new Element("Tm", 69);
		tm.addIsotopes(169);
		addElementButton(tm);
		
		Element yb = new Element("Yb", 70);
		yb.addIsotopes(168, 170, 171, 172, 173, 174, 176);
		addElementButton(yb);
		
		Element lu = new Element("Lu", 71);
		lu.addIsotopes(175, 176);
		addElementButton(lu);
		addEmptyLabels(3);
		
		Element ac = new Element("Ac", 89);
		ac.addIsotopes(227);
		addElementButton(ac);
		
		Element th = new Element("Th", 90);
		th.addIsotopes(232);
		addElementButton(th);
		
		Element pa = new Element("Pa", 91);
		pa.addIsotopes(231);
		addElementButton(pa);
		
		Element u = new Element("U", 92);
		u.addIsotopes(234, 235, 238);
		addElementButton(u);
		
		Element np = new Element("Np", 93);
		np.addIsotopes(237);
		addElementButton(np);
		
		Element pu = new Element("Pu", 94);
		pu.addIsotopes(244);
		addElementButton(pu);
		
		Element am = new Element("Am", 95);
		am.addIsotopes(243);
		addElementButton(am);
		
		Element cm = new Element("Cm", 96);
		cm.addIsotopes(247);
		addElementButton(cm);
		
		Element bk = new Element("Bk", 97);
		bk.addIsotopes(247);
		addElementButton(bk);
		
		Element cf = new Element("Cf", 98);
		cf.addIsotopes(251);
		addElementButton(cf);
		
		Element es = new Element("Es", 99);
		es.addIsotopes(252);
		addElementButton(es);
		
		Element fm = new Element("Fm", 100);
		fm.addIsotopes(257);
		addElementButton(fm);
		
		Element md = new Element("Md", 101);
		md.addIsotopes(258);
		addElementButton(md);
		
		Element no = new Element("No", 102);
		no.addIsotopes(259);
		addElementButton(no);
		
		Element lw = new Element("Lw", 103);
		lw.addIsotopes(262);
		addElementButton(lw);
	}

	public List<ElementButton> getButtonList() {
		return buttonList;
	}
}