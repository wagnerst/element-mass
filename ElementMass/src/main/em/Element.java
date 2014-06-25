/*
 *  Copyright 2014 Stefan Wagner
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package em;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import java.util.List;

/**
 * This class represents a chemical element
 * with its possible isotopes.
 *
 */
public class Element implements Comparable<Element> {
	
	private String name;
	private List<Isotope> isotopes= new LinkedList<Isotope>();
	private Isotope mostFrequentIsotope;

	public static final Element H = new Element("H", 1, 2);
	public static final Element HE = new Element("He", 4, 3);
	public static final Element LI = new Element("Li", 7, 6);
	public static final Element BE = new Element("Be", 9);
	public static final Element B = new Element("B", 11, 10);
	public static final Element C = new Element("C", 12, 13);
	public static final Element N = new Element("N", 14, 15);
	public static final Element O = new Element("O", 16, 17, 18);
	public static final Element F = new Element("F", 19);
	public static final Element NE = new Element("Ne", 20, 21, 22);
	public static final Element NA = new Element("Na", 23);
	public static final Element MG = new Element("Mg", 24, 25, 26);
	public static final Element AL = new Element("Al", 27);
	public static final Element SI = new Element("Si", 28, 29, 30);
	public static final Element P = new Element("P", 31);
	public static final Element S = new Element("S", 32, 33, 34, 36);
	public static final Element CL = new Element("Cl", 35, 37);
	public static final Element AR = new Element("Ar", 40, 36, 38);
	public static final Element K = new Element("K", 39, 40, 41);
	public static final Element CA = new Element("Ca", 40, 42, 43, 44, 46, 48);
	public static final Element SC = new Element("Sc", 45);
	public static final Element TI = new Element("Ti", 48, 46, 47, 49, 50);
	public static final Element V = new Element("V", 51, 50);
	public static final Element CR = new Element("Cr", 52, 50, 53, 54);
	public static final Element MN = new Element("Mn", 55);
	public static final Element FE = new Element("Fe", 56, 54, 57, 58);
	public static final Element CO = new Element("Co", 59);
	public static final Element NI = new Element("Ni", 58, 60, 61, 62, 64);
	public static final Element CU = new Element("Cu", 63, 65);
	public static final Element ZN = new Element("Zn", 64, 66, 67, 68, 70);
	public static final Element GA = new Element("Ga", 69, 71);
	public static final Element GE = new Element("Ge", 74, 72, 73, 70, 76);
	public static final Element AS = new Element("As", 75);
	public static final Element SE = new Element("Se", 80, 74, 76, 77, 78, 82);
	public static final Element BR = new Element("Br", 79, 81);
	public static final Element KR = new Element("Kr", 84, 79, 80, 82, 83, 86);
	public static final Element RB = new Element("Rb", 85, 87);
	public static final Element SR = new Element("Sr", 88, 86, 87, 84);
	public static final Element Y = new Element("Y", 89);
	public static final Element ZR = new Element("Zr", 90, 91, 92, 94, 96);
	public static final Element NB = new Element("Nb", 93);
	public static final Element MO = new Element("Mo", 98, 94, 95, 96, 97, 92, 100);
	public static final Element TC = new Element("Tc", 98, 99);
	public static final Element RU = new Element("Ru", 102, 96, 98, 99, 100, 101, 104);
	public static final Element RH = new Element("Rh", 103);
	public static final Element PD = new Element("Pd", 106, 104, 105, 102, 108, 110);
	public static final Element AG = new Element("Ag", 109, 107);
	public static final Element CD = new Element("Cd", 114, 106, 108, 110, 111, 112, 113, 116);
	public static final Element IN = new Element("In", 115, 113);
	public static final Element SN = new Element("Sn", 120, 112, 114, 115, 116, 117, 118, 119, 122, 124);
	public static final Element SB = new Element("Sb", 121, 123);
	public static final Element TE = new Element("Te", 130, 120, 122, 123, 124, 125, 126, 128);
	public static final Element I = new Element("I", 127);
	public static final Element XE = new Element("Xe", 132, 124, 126, 128, 129, 130, 131, 134, 136);
	public static final Element CS = new Element("Cs", 133);
	public static final Element BA = new Element("Ba", 138, 130, 132, 134, 135, 136, 137);
	public static final Element HF = new Element("Hf", 180, 174, 176, 177, 178, 179);
	public static final Element TA = new Element("Ta", 181, 180);
	public static final Element W = new Element("W", 184, 182, 183, 180, 186);
	public static final Element RE = new Element("Re", 187, 185);
	public static final Element OS = new Element("Os", 192, 184, 186, 187, 188, 189, 190);
	public static final Element IR = new Element("Ir", 193, 191);
	public static final Element PT = new Element("Pt", 195, 192, 194, 190, 196, 198);
	public static final Element AU = new Element("Au", 197);
	public static final Element HG = new Element("Hg", 202, 196, 198, 199, 200, 201, 204);
	public static final Element TL = new Element("Tl", 205, 203);
	public static final Element PB = new Element("Pb", 208, 204, 206, 207);
	public static final Element BI = new Element("Bi", 209);
	public static final Element PO = new Element("Po", 209);
	public static final Element AT = new Element("At", 210);
	public static final Element RN = new Element("Rn", 222);
	public static final Element FR = new Element("Fr", 223);
	public static final Element RA = new Element("Ra", 226);
	public static final Element RF = new Element("Rf", 253, 254, 255, 256, 257, 258, 259, 260, 261, 262); //Most frequent unknown
	public static final Element DB = new Element("Db", 261, 262, 263); //Most frequent unknown
	public static final Element SG = new Element("Sg", 265, 266); //Most frequent unknown
	public static final Element BH = new Element("Bh", 261, 262, 264); //Most frequent unknown
	public static final Element HS = new Element("Hs", 268, 269, 270); //Most frequent unknown
	public static final Element MT = new Element("Mt", 266, 267, 268, 270, 274, 275, 276); //Most frequent unknown
	public static final Element DS = new Element("Ds", 267, 268, 269, 270, 271, 272, 273, 279, 280, 281, 282); //Most frequent unknown
	public static final Element RG = new Element("Rg", 272, 274, 278, 279, 280); //Most frequent unknown
	public static final Element CN = new Element("Cn", 277, 278, 279, 280, 282, 283, 284, 285); //Most frequent unknown
	public static final Element UUT = new Element("Uut", 278, 283, 284, 285, 286, 287); //Most frequent unknown
	public static final Element FL = new Element("Fl", 286, 287, 288, 289); //Most frequent unknown
	public static final Element UUP = new Element("Uup", 287, 288, 289, 290, 291); //Most frequent unknown
	public static final Element LV = new Element("Lv", 289, 290, 291, 292, 293); //Most frequent unknown
	public static final Element UUS = new Element("Uus", 291, 292); //Most frequent unknown
	public static final Element UUO = new Element("Uuo", 294); //Most frequent unknown
	public static final Element LA = new Element("La", 139, 138);
	public static final Element CE = new Element("Ce", 140, 136, 138, 142);
	public static final Element PR = new Element("Pr", 141);
	public static final Element ND = new Element("Nd", 142, 143, 144, 145, 146, 148, 150);
	public static final Element PM = new Element("Pm", 145);
	public static final Element SM = new Element("Sm", 152, 144, 147, 148, 149, 150, 154);
	public static final Element EU = new Element("Eu", 153, 151);
	public static final Element GD = new Element("Gd", 158, 152, 154, 155, 156, 157, 160);
	public static final Element TB = new Element("Tb", 159);
	public static final Element DY = new Element("Dy", 164, 156, 158, 160, 161, 162, 163);
	public static final Element HO = new Element("Ho", 165);
	public static final Element ER = new Element("Er", 166, 162, 164, 167, 168, 170);
	public static final Element TM = new Element("Tm", 169);
	public static final Element YB = new Element("Yb", 174, 168, 170, 171, 172, 173, 176);
	public static final Element LU = new Element("Lu", 175, 176);
	public static final Element AC = new Element("Ac", 227);
	public static final Element TH = new Element("Th", 232);
	public static final Element PA = new Element("Pa", 231);
	public static final Element U = new Element("U", 238, 234, 235);
	public static final Element NP = new Element("Np", 237);
	public static final Element PU = new Element("Pu", 244);
	public static final Element AM = new Element("Am", 243);
	public static final Element CM = new Element("Cm", 247);
	public static final Element BK = new Element("Bk", 247);
	public static final Element CF = new Element("Cf", 251);
	public static final Element ES = new Element("Es", 252);
	public static final Element FM = new Element("Fm", 257);
	public static final Element MD = new Element("Md", 258);
	public static final Element NO = new Element("No", 259);
	public static final Element LW = new Element("Lw", 262);
	
	/**
	 * The constructor is only for building the constant
	 * elements of the periodic table. The first isotope
	 * mass needs to be the most frequent isotope.
	 * @param name
	 * @param mostFrequentIsotope
	 * @param isotopeMasses
	 */
	private Element(String name, int mostFrequentIsotope, int... isotopeMasses) {
		this.name = name;
		addIsotopes(isotopeMasses);
		setMostFrequentIsotope(mostFrequentIsotope);
	}
	
	private Element(String name, int mostFrequentIsotope) {
		this.name = name;
		setMostFrequentIsotope(mostFrequentIsotope);
	}

	private void addIsotopes(int... isotopeMasses) {
		Isotope isotope = null;
		for (int mass : isotopeMasses) {
			isotope = new Isotope(this, mass); 
			this.isotopes.add(isotope);
		}
		if (isotopes.size() == 1) {
			setMostFrequentIsotope(isotope);
		}
	}
	
	public static Set<Element> allElements() {
		Set<Element> elements = new HashSet<Element>();
		Field[] fields = Element.class.getDeclaredFields();
		for (Field f : fields) {
		    if (Modifier.isStatic(f.getModifiers())) {
		        try {
					elements.add((Element)f.get(null));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
		    } 
		}
		return elements;
	}

	/**
	 * @return the isotopes
	 */
	public List<Isotope> getIsotopes() {
		return isotopes;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	public Isotope getMostFrequentIsotope() {
		return this.mostFrequentIsotope;
	}

	/**
	 * Searches in all the element constants for the element
	 * with the given name.
	 * @param string name of the element
	 * @return element object
	 */
	public static Element getElementByName(String name) {
		Set<Element> elements = allElements();
		for (Element element : elements) {
			if (element.getName().equals(name))
				return element;
		}
		return null;
	}

	private void setMostFrequentIsotope(int isotopeMass) {
		setMostFrequentIsotope(new Isotope(this, isotopeMass));
	}
	
	private void setMostFrequentIsotope(Isotope isotope) {
		this.mostFrequentIsotope = isotope;
		if (!isotopes.contains(mostFrequentIsotope)) {
			isotopes.add(isotope);
		}
	}
	
	@Override
	public int compareTo(Element o) {
		return this.toString().compareTo(o.toString());
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}

}
