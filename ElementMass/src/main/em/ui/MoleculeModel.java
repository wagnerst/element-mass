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

/**
 * 
 */
package em.ui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The class is the model containing the data of a molecule
 * for display in the result table.
 */
public class MoleculeModel {
	private SimpleStringProperty name;
	
	private SimpleStringProperty mass;
	
	public MoleculeModel(String name, String mass) {
		this.name = new SimpleStringProperty(name);
		this.mass = new SimpleStringProperty(mass);
	}

	public String getName() {
		return name.get();
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public StringProperty nameProperty() { 
        if (name == null) {
        		name = new SimpleStringProperty(this, "name");
        }
        return name; 
    }
	
	public String getMass() {
		return mass.get();
	}
	
	public void setMass(String mass) {
		this.mass.set(mass);
	}
	
	public StringProperty massProperty() { 
        if (mass == null) {
        		mass = new SimpleStringProperty(this, "mass");
        }
        return mass; 
    }

}
