package br.edu.ifsc.canoinhas.poo2.NN;


import br.edu.ifsc.canoinhas.poo2.NN.db.UsersInFile;

public class TestConnection implements Runnable {

	
	@Override
	public void run() {	
		UsersInFile usersInFile = new UsersInFile();
		try {
			while (true) {
				System.out.println("Testando conexão......");
				usersInFile.check();
				Thread.sleep(4200);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
