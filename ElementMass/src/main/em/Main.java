package em;

import java.util.HashSet;
import java.util.Set;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
 * the result. 
 *
 */
public class Main extends Application {
	
	private Set<Element> selectedElements;
	private PeriodicTable periodicTable = new PeriodicTable();
	private Calculator calc = new Calculator();
	private TextField mByCTextField;
	private VBox resultBox;
	final ScrollPane sp = new ScrollPane();
	
	/**
	 * Only launches the JavaFX window.
	 * @param args
	 */
	 public static void main(String[] args) {
	        launch(args);
	    }
	 
	 @Override
	 public void start(Stage primaryStage) throws Exception {	
		 BorderPane border = new BorderPane();
		 GridPane elementGrid = new GridPane();
		 elementGrid.setAlignment(Pos.CENTER);
		 elementGrid.setHgap(10);
		 elementGrid.setVgap(10);
		 elementGrid.setPadding(new Insets(25, 25, 25, 25));
		 
		 Text scenetitle = new Text("ElementMass");
		 scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		 elementGrid.add(scenetitle, 0, 0, 2, 1);
		 
		 periodicTable.createElementButtons(elementGrid);
		 border.setTop(elementGrid);

		 GridPane textGrid = new GridPane();
		 textGrid.setAlignment(Pos.CENTER);
		 textGrid.setHgap(10);
		 textGrid.setVgap(10);
		 textGrid.setPadding(new Insets(25, 25, 25, 25));
		 Label mByCLabel = new Label("m/c:");
		 textGrid.add(mByCLabel, 0, 1);

		 mByCTextField = new TextField();
		 textGrid.add(this.mByCTextField, 1, 1);

		 Button btn = new Button("Calculate");
		 textGrid.add(btn, 2, 1);
		 border.setCenter(textGrid);
		 
		 resultBox = new VBox();
		 resultBox.setPadding(new Insets(30));
		 resultBox.setSpacing(8);
		 resultBox.setAlignment(Pos.CENTER_LEFT);
	     border.setBottom(resultBox);
		 
		 btn.setOnAction(new EventHandler<ActionEvent>() {
			    @Override
			    public void handle(ActionEvent e) {
			    		setUpCalculatePrint();
			    }
			});
		 
	     ScrollPane sp = new ScrollPane();
	     sp.setHbarPolicy(ScrollBarPolicy.ALWAYS);
	     sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
	     sp.setContent(border);
		 
		 Scene scene = new Scene(sp, 1000, 700);
		 primaryStage.setTitle("ElementMass");
		 primaryStage.setScene(scene);
		 primaryStage.show();
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

	public Calculator getCalc() {
		return this.calc;
	}

	public void setSelectedElements(Set<Element> selectedElements) {
		this.selectedElements = selectedElements;
	}

	public Set<Element> getSelectedElements() {
		return selectedElements;
	}

	private void setUpCalculatePrint() {
		setUpCalculator();
		Set<Molecule> possibleElements = calc.calculatePossibleElements();
		printResult(possibleElements);
	}
	
	private void setUpCalculator() {
		calc.setSelectedElements(findSelectedElements());
		calc.setmByC(Integer.parseInt(mByCTextField.getText()));
	}

	private void printResult(Set<Molecule> possibleElements) {
		resultBox.getChildren().clear();
		for (Molecule molecule : possibleElements) {
			resultBox.getChildren().add(new Text(molecule.toString() +
					", " + molecule.getMostFrequentMass()));
		}
	}

}
