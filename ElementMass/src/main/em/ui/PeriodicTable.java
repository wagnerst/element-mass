package em.ui;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import em.Element;
import static em.Element.*;


/**
 * This class is responsible for generating the
 * periodic table to display in the main window.
 * @author wagnerst
 *
 */
public class PeriodicTable {
	private List<ElementButton> buttonList;
	private JPanel panel;
	
	public void addEmptyLabels(int j) {
		for (int i = 0; i < j; i++) {
			panel.add(new JLabel(""));
		}
	}
	
	public List<ElementButton> getButtonList() {
		return buttonList;
	}
	
	public void createElementButtons(JPanel panel) {
		buttonList = new LinkedList<ElementButton>();
		this.panel = panel;

		createFirstRow();
		createSecondRow();
		createThirdRow();
		createFourthRow();
		createFifthRow();
		createSixthRow();
		createSeventhRow();
		createEigthRow();
		createNinethRow();
	}

	private void createFirstRow() {
		addElementButton(H);
		addEmptyLabels(16);
		addElementButton(HE);
	}
	
	private void addElementButton(Element e) {
		ElementButton eb = new ElementButton(e);
		buttonList.add(eb);
		panel.add(eb);
	}

	private void createSecondRow() {
		addElementButton(LI);
		addElementButton(BE);
		addEmptyLabels(10);
		addElementButton(B);
		addElementButton(C);
		addElementButton(N);
		addElementButton(O);
		addElementButton(F);
		addElementButton(NE);
	}

	private void createThirdRow() {
		addElementButton(NA);
		addElementButton(MG);
		addEmptyLabels(10);
		addElementButton(AL);
		addElementButton(SI);
		addElementButton(P);
		addElementButton(S);
		addElementButton(CL);
		addElementButton(AR);
	}
	
	private void createFourthRow() {
		addElementButton(K);
		addElementButton(CA);
		addElementButton(SC);
		addElementButton(TI);
		addElementButton(V);
		addElementButton(CR);
		addElementButton(MN);
		addElementButton(FE);
		addElementButton(CO);
		addElementButton(NI);
		addElementButton(CU);
		addElementButton(ZN);
		addElementButton(GA);
		addElementButton(GE);
		addElementButton(AS);
		addElementButton(SE);
		addElementButton(BR);
		addElementButton(KR);
	}
	
	private void createFifthRow() {
		addElementButton(RB);
		addElementButton(SR);
		addElementButton(Y);
		addElementButton(ZR);
		addElementButton(NB);
		addElementButton(MO);
		addElementButton(TC);
		addElementButton(RU);
		addElementButton(RH);
		addElementButton(PD);
		addElementButton(AG);
		addElementButton(CD);
		addElementButton(IN);
		addElementButton(SN);
		addElementButton(SB);
		addElementButton(TE);
		addElementButton(I);
		addElementButton(XE);
	}
	
	private void createSixthRow() {
		addElementButton(CS);
		addElementButton(BA);
		addEmptyLabels(1);
		addElementButton(HF);
		addElementButton(TA);
		addElementButton(W);
		addElementButton(RE);
		addElementButton(OS);
		addElementButton(IR);
		addElementButton(PT);
		addElementButton(AU);
		addElementButton(HG);
		addElementButton(TL);
		addElementButton(PB);
		addElementButton(BI);
		addElementButton(PO);
		addElementButton(AT);
		addElementButton(RN);
	}

	private void createSeventhRow() {
		addElementButton(FR);
		addElementButton(RA);
		addEmptyLabels(1);
		addElementButton(RF);
		addElementButton(DB);
		addElementButton(SG);
		addElementButton(BH);
		addElementButton(HS);
		addElementButton(MT);
		addElementButton(DS);
		addElementButton(RG);
		addElementButton(CN);
		addElementButton(UUT);
		addElementButton(FL);
		addElementButton(UUP);
		addElementButton(LV);
		addElementButton(UUS);
		addElementButton(UUO);
	}

	private void createEigthRow() {
		addEmptyLabels(3);
		addElementButton(LA);
		addElementButton(CE);
		addElementButton(PR);
		addElementButton(ND);
		addElementButton(PM);
		addElementButton(SM);
		addElementButton(EU);
		addElementButton(GD);
		addElementButton(TB);
		addElementButton(DY);
		addElementButton(HO);
		addElementButton(ER);
		addElementButton(TM);
		addElementButton(YB);
		addElementButton(LU);
	}
	
	private void createNinethRow() {
		addEmptyLabels(3);
		addElementButton(AC);
		addElementButton(TH);
		addElementButton(PA);
		addElementButton(U);
		addElementButton(NP);
		addElementButton(PU);
		addElementButton(AM);
		addElementButton(CM);
		addElementButton(BK);
		addElementButton(CF);
		addElementButton(ES);
		addElementButton(FM);
		addElementButton(MD);
		addElementButton(NO);
		addElementButton(LW);
	}
	
}