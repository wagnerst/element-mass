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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import em.calc.Calculator;
import em.ui.ElementButton;
import em.ui.MoleculeModel;
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
	TableView<MoleculeModel> table = new TableView<MoleculeModel>();
	
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
		 addInputField(border);
		 setUpResultBox(border);
		 setUpSceneAndShowStage(primaryStage, setUpScrollPane(border));
	}

	private void setUpPeriodicTable(BorderPane border) {
		GridPane elementGrid = setUpGridPane();
		 setSceneTitle(elementGrid);
		 periodicTable.createElementButtons(elementGrid);
		 List<ElementButton> buttonList = periodicTable.getButtonList();
		 for (ElementButton eb : buttonList) {
			 eb.setOnAction(event -> calculateAndPrintResults());
		 }
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
	
	private void addInputField(BorderPane border) {
		GridPane textGrid = setUpGridPane();
		 Label mByCLabel = new Label("m/c:");
		 textGrid.add(mByCLabel, 0, 1);
		 mByCTextField = new TextField();
		 mByCTextField.setPromptText("0");
		 textGrid.add(this.mByCTextField, 1, 1);
		 mByCTextField.setOnKeyReleased(event -> calculateAndPrintResults());
		 
		 border.setCenter(textGrid);
	}
	
	private void setUpResultBox(BorderPane border) {
		TableColumn<MoleculeModel,String> nameCol = new TableColumn<MoleculeModel,String>("Molecule");
		nameCol.setCellValueFactory(new PropertyValueFactory<MoleculeModel,String>("name"));
		nameCol.setPrefWidth(100.0);

		TableColumn<MoleculeModel,String> massCol = new TableColumn<MoleculeModel,String>("Mass of most frequent isotopes");
		massCol.setCellValueFactory(new PropertyValueFactory<MoleculeModel,String>("mass"));
		massCol.setPrefWidth(300.0);
		
		table.getColumns().setAll(nameCol, massCol);
		table.setMaxWidth(400);
		
	    border.setBottom(table);
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

	private void calculateAndPrintResults() {
		Set<Molecule> resultMolecules = calc.calculatePossibleElements(findSelectedElements(),
				extractMByC());
		List<Molecule> moleculeList = new ArrayList<Molecule>(resultMolecules);
		moleculeList.sort(new MoleculeMassSorter());
		List<MoleculeModel> beanList = new ArrayList<MoleculeModel>();
		for (Molecule molecule : moleculeList) {
			MoleculeModel mm = new MoleculeModel(molecule.toString(), 
					new Integer(molecule.getMostFrequentMass()).toString());
			beanList.add(mm);	
		}
		ObservableList<MoleculeModel> obsMolecules = FXCollections.observableArrayList(beanList);
		table.setItems(obsMolecules);
	}

	private int extractMByC() {
		String inputText = mByCTextField.getText();
		int inputMByC = 0; 
		if (!inputText.trim().isEmpty()) {
			inputMByC = Integer.parseInt(inputText);
		}
		return inputMByC;
	}

}
