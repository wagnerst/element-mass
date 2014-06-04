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

import java.util.HashSet;
import java.util.Set;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import em.calc.Calculator;
import em.ui.ElementButton;
import em.ui.PeriodicTable;

/**
 * This class is the main application window. It shows the
 * periodic table, allows selecting elements and shows
 * the calculation result. 
 *
 */
public class Main extends Application {
	
	private Set<Element> selectedElements;
	private PeriodicTable periodicTable = new PeriodicTable();
	private Calculator calc = new Calculator();
	private TextField mByCTextField;
	private VBox resultBox;
	
	/**
	 * Only launches the JavaFX window.
	 * @param args
	 */
	 public static void main(String[] args) {
	        launch(args);
	    }
	 
	 public Calculator getCalc() {
		 return this.calc;
	 }

	 public void setSelectedElements(Set<Element> selectedElements) {
		 this.selectedElements = selectedElements;
	 }

	 public Set<Element> getSelectedElements() {
		 return selectedElements;
	 }
	 
	 @Override
	 public void start(Stage primaryStage) throws Exception {	
		 BorderPane border = new BorderPane();
		 setUpPeriodicTable(border);
		 addInputFieldAndButton(border);
		 setUpResultBox(border);
		 setUpSceneAndShowStage(primaryStage, setUpScrollPane(border));
	}

	private void setUpPeriodicTable(BorderPane border) {
		GridPane elementGrid = setUpGridPane();
		 setSceneTitle(elementGrid);
		 periodicTable.createElementButtons(elementGrid);
		 border.setTop(elementGrid);
	}
	
	private GridPane setUpGridPane() {
		GridPane grid = new GridPane();
		 grid.setAlignment(Pos.CENTER);
		 grid.setHgap(10);
		 grid.setVgap(10);
		 grid.setPadding(new Insets(25, 25, 25, 25));
		return grid;
	}
	
	private void setSceneTitle(GridPane elementGrid) {
		Text scenetitle = new Text("ElementMass");
		 scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		 elementGrid.add(scenetitle, 0, 0, 2, 1);
	}
	
	private void addInputFieldAndButton(BorderPane border) {
		GridPane textGrid = setUpGridPane();
		 Label mByCLabel = new Label("m/c:");
		 textGrid.add(mByCLabel, 0, 1);
		 mByCTextField = new TextField();
		 textGrid.add(this.mByCTextField, 1, 1);
		 mByCTextField.setOnAction(event -> setUpCalculatePrint());
		 mByCTextField.setOnKeyTyped(event -> startCalculationKeyPressed(event));

		 Button btn = new Button("Calculate");
		 textGrid.add(btn, 2, 1);
		 
		 border.setCenter(textGrid);
		 
		 btn.setOnAction(event -> setUpCalculatePrint());
	}
	
	private void setUpResultBox(BorderPane border) {
		resultBox = new VBox();
		 resultBox.setPadding(new Insets(30));
		 resultBox.setSpacing(8);
		 resultBox.setAlignment(Pos.CENTER_LEFT);
	     border.setBottom(resultBox);
	}

	private void setUpSceneAndShowStage(Stage primaryStage, ScrollPane sp) {
		Scene scene = new Scene(sp, 1000, 700);
		 primaryStage.setTitle("ElementMass");
		 primaryStage.setScene(scene);
		 primaryStage.show();
	}

	private ScrollPane setUpScrollPane(BorderPane border) {
		ScrollPane sp = new ScrollPane();
	     sp.setHbarPolicy(ScrollBarPolicy.ALWAYS);
	     sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
	     sp.setContent(border);
		return sp;
	}
	
	private Set<Element> findSelectedElements() {
		Set<Element> elements = new HashSet<Element>();
		for (ElementButton eb : periodicTable.getButtonList()) {
			if (eb.isSelected()) {
				elements.add(eb.getElement());
			}
		}
		return elements;
	}
	
	private void startCalculationKeyPressed(Event event) {
		
	}

	private void setUpCalculatePrint() {
		printResult(calc.calculatePossibleElements(findSelectedElements(),
				Integer.parseInt(mByCTextField.getText())));
	}

	private void printResult(Set<Molecule> possibleElements) {
		resultBox.getChildren().clear();
		for (Molecule molecule : possibleElements) {
			resultBox.getChildren().add(new Text(molecule.toString() +
					", " + molecule.getMostFrequentMass()));
		}
	}

}
