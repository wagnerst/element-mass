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

import static org.junit.Assert.*;

import java.util.Set;

import em.Isotope;
import static em.Element.*;

import org.junit.Test;

public class ElementTest {
		
	
	@Test
	public void testMostFrequentIsotope() {
		assertTrue(B.getMostFrequentIsotope().equals(new Isotope(B, 11)));
	}
	
	@Test
	public void testReflection() {
		Set<Element> elements = Element.allElements();
		assertTrue(elements.contains(CO));
		assertTrue(elements.contains(UUO));
	}
	
	@Test
	public void testGetElementByName() {
		Element fe = Element.getElementByName("Fe");
		assertTrue(fe.equals(FE));
	}

}
