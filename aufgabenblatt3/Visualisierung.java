package aufgabenblatt3;
import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Visualisierung extends Application implements Observer{
	
	private Simulation simulation; 
	private VBox gleisenBox;
	private HBox[] zuegeBox;
	private Scene scene;
	Thread taskWorker;
	
	public void init(){

		taskWorker.start();
		try {
			taskWorker.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public Visualisierung(){
		simulation = new Simulation();
		simulation.addObserver(this);
		taskWorker = new Thread(new SimulationTask(simulation));
		
		gleisenBox = new VBox(20);
		gleisenBox.setStyle("-fx-background-color: #FFFFFF");
		zuegeBox = new HBox[simulation.getGleisenAnzahl()];
		for(int i = 0; i < zuegeBox.length; i++){
			zuegeBox[i] = new  HBox(10);
			zuegeBox[i].getChildren().add(new Label("Train " + i ));
			zuegeBox[i].setStyle("-fx-background-color: #615C8D");
			gleisenBox.getChildren().add(zuegeBox[i]);
		}
		gleisenBox.setPadding(new Insets(20));
		
		scene = new Scene(gleisenBox, 400, 500);
		
	}
	public static void main(String []args){
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setScene(scene);
		stage.setTitle("Rangiebahnhof");
		
		stage.show();
	}

	@Override
	public void update(Observable o, Object arg) {
		Gleis gleis = (Gleis)arg;
		if(gleis != null){
			if(gleis.getZug() == null){
				zuegeBox[gleis.getGleisNummer()].setStyle("-fx-baground-color: #FFFFFF");
			}
			else{
				zuegeBox[gleis.getGleisNummer()].setStyle("-fx-baground-color: #DD4814");
			}
		}
		
	}

}
