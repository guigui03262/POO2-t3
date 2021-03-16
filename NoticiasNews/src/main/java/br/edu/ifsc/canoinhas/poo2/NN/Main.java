package br.edu.ifsc.canoinhas.poo2.NN;

import br.edu.ifsc.canoinhas.poo2.NN.db.UsersInFile;
import br.edu.ifsc.canoinhas.poo2.NN.db.UtilDB;
import javafx.application.Application;

public class Main {

	public static void main(String[] args) {
		Thread connection = new Thread(new TestConnection());
		App.setConnection(connection);
		
		UtilDB.initDB();
		
		System.out.println("Os usuários do arquivo local estão sendo lidos e salvos no banco...");
		new UsersInFile().check();
		
		Application.launch(App.class);
		
		UtilDB.closeConn();
		connection.interrupt();
	}

}
