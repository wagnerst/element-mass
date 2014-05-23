package em.ui;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.layout.GridPane;

import em.Element;
import static em.Element.*;


/**
 * This class is responsible for generating the
 * periodic table to display in the main window.
 *
 */
public class PeriodicTable {
	private List<ElementButton> buttonList;
	private GridPane grid;
	
	public List<ElementButton> getButtonList() {
		return buttonList;
	}
	
	/**
	 * @param grid
	 * @return next row
	 */
	public int createElementButtons(GridPane grid) {
		buttonList = new LinkedList<ElementButton>();
		this.grid = grid;

		createFirstRow();
		createSecondRow();
		createThirdRow();
		createFourthRow();
		createFifthRow();
		createSixthRow();
		createSeventhRow();
		createEigthRow();
		createNinethRow();
		
		return 10;
	}

	private void createFirstRow() {
		int row = 1;
		addElementButton(H, 0, row);
		addElementButton(HE, 17, row);
	}
	
	private void addElementButton(Element e, int column, int row) {
		ElementButton eb = new ElementButton(e);
		buttonList.add(eb);
		grid.add(eb, column, row);
	}

	private void createSecondRow() {
		int row = 2;
		addElementButton(LI, 0, row);
		addElementButton(BE, 1, row);
		addElementButton(B, 12, row);
		addElementButton(C, 13, row);
		addElementButton(N, 14, row);
		addElementButton(O, 15, row);
		addElementButton(F, 16, row);
		addElementButton(NE, 17, row);
	}

	private void createThirdRow() {
		int row = 3;
		addElementButton(NA, 0, row);
		addElementButton(MG, 1, row);
		addElementButton(AL, 12, row);
		addElementButton(SI, 13, row);
		addElementButton(P, 14, row);
		addElementButton(S, 15, row);
		addElementButton(CL, 16, row);
		addElementButton(AR, 17, row);
	}
	
	private void createFourthRow() {
		int row = 4;
		addElementButton(K, 0, row);
		addElementButton(CA, 1, row);
		addElementButton(SC, 2, row);
		addElementButton(TI, 3, row);
		addElementButton(V, 4, row);
		addElementButton(CR, 5, row);
		addElementButton(MN, 6, row);
		addElementButton(FE, 7, row);
		addElementButton(CO, 8, row);
		addElementButton(NI, 9, row);
		addElementButton(CU, 10, row);
		addElementButton(ZN, 11, row);
		addElementButton(GA, 12, row);
		addElementButton(GE, 13, row);
		addElementButton(AS, 14, row);
		addElementButton(SE, 15, row);
		addElementButton(BR, 16, row);
		addElementButton(KR, 17, row);
	}
	
	private void createFifthRow() {
		int row = 5;
		addElementButton(RB, 0, row);
		addElementButton(SR, 1, row);
		addElementButton(Y, 2, row);
		addElementButton(ZR, 3, row);
		addElementButton(NB, 4, row);
		addElementButton(MO, 5, row);
		addElementButton(TC, 6, row);
		addElementButton(RU, 7, row);
		addElementButton(RH, 8, row);
		addElementButton(PD, 9, row);
		addElementButton(AG, 10, row);
		addElementButton(CD, 11, row);
		addElementButton(IN, 12, row);
		addElementButton(SN, 13, row);
		addElementButton(SB, 14, row);
		addElementButton(TE, 15, row);
		addElementButton(I, 16, row);
		addElementButton(XE, 17, row);
	}
	
	private void createSixthRow() {
		int row = 6;
		addElementButton(CS, 0, row);
		addElementButton(BA, 1, row);
		addElementButton(HF, 3, row);
		addElementButton(TA, 4, row);
		addElementButton(W, 5, row);
		addElementButton(RE, 6, row);
		addElementButton(OS, 7, row);
		addElementButton(IR, 8, row);
		addElementButton(PT, 9, row);
		addElementButton(AU, 10, row);
		addElementButton(HG, 11, row);
		addElementButton(TL, 12, row);
		addElementButton(PB, 13, row);
		addElementButton(BI, 14, row);
		addElementButton(PO, 15, row);
		addElementButton(AT, 16, row);
		addElementButton(RN, 17, row);
	}

	private void createSeventhRow() {
		int row = 7;
		addElementButton(FR, 0, row);
		addElementButton(RA, 1, row);
		addElementButton(RF, 3, row);
		addElementButton(DB, 4, row);
		addElementButton(SG, 5, row);
		addElementButton(BH, 6, row);
		addElementButton(HS, 7, row);
		addElementButton(MT, 8, row);
		addElementButton(DS, 9, row);
		addElementButton(RG, 10, row);
		addElementButton(CN, 11, row);
		addElementButton(UUT, 12, row);
		addElementButton(FL, 13, row);
		addElementButton(UUP, 14, row);
		addElementButton(LV, 15, row);
		addElementButton(UUS, 16, row);
		addElementButton(UUO, 17, row);
	}

	private void createEigthRow() {
		int row = 8;
		addElementButton(LA, 3, row);
		addElementButton(CE, 4, row);
		addElementButton(PR, 5, row);
		addElementButton(ND, 6, row);
		addElementButton(PM, 7, row);
		addElementButton(SM, 8, row);
		addElementButton(EU, 9, row);
		addElementButton(GD, 10, row);
		addElementButton(TB, 11, row);
		addElementButton(DY, 12, row);
		addElementButton(HO, 13, row);
		addElementButton(ER, 14, row);
		addElementButton(TM, 15, row);
		addElementButton(YB, 16, row);
		addElementButton(LU, 17, row);
	}
	
	private void createNinethRow() {
		int row = 9;
		addElementButton(AC, 3, row);
		addElementButton(TH, 4, row);
		addElementButton(PA, 5, row);
		addElementButton(U, 6, row);
		addElementButton(NP, 7, row);
		addElementButton(PU, 8, row);
		addElementButton(AM, 9, row);
		addElementButton(CM, 10, row);
		addElementButton(BK, 11, row);
		addElementButton(CF, 12, row);
		addElementButton(ES, 13, row);
		addElementButton(FM, 14, row);
		addElementButton(MD, 15, row);
		addElementButton(NO, 16, row);
		addElementButton(LW, 17, row);
	}
	
}