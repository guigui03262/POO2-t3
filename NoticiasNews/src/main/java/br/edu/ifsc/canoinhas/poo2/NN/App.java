package br.edu.ifsc.canoinhas.poo2.NN;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
public class App extends Application {

    private static Stage stage;
    private static Thread connection;

    @Override
	public void start(Stage stge) {
		stage = stge;
		stage.setScene(FXMLUtil.loadScene("principal"));
		stage.setTitle("NN");
		stage.show();
		connection.start();
	}

    public static void setRoot(String fxml) throws IOException {
    	stage.setScene(FXMLUtil.loadScene(fxml));
    }
    
    public static void setConnection(Thread connection) {
		App.connection = connection;
	}

}