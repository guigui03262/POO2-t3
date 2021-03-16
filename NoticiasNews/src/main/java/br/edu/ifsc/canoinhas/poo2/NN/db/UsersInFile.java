package br.edu.ifsc.canoinhas.poo2.NN.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.ifsc.canoinhas.poo2.NN.entities.User;

public class UsersInFile {

	public void check() {
		String fileLocation = "./local-users.json";
		List<String> fileLines = new ArrayList<>();
		try {
			File file = new File(fileLocation);
			if (file.exists()) {
				Scanner scanner = new Scanner(file);
				while (scanner.hasNextLine())
					fileLines.add(scanner.nextLine());
				scanner.close();
			} else {
				System.err.println("File \"" + fileLocation + "\" is missing.");
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error while opening file \"" + fileLocation + "\".");
		}

		List<User> userList = UtilDB.consumeAPI(fileLines);
		for (User u : userList) {
			User us = new UserDAO().get(u.getEmail());
			if (!(us == null)) {
				if (!u.getPassword().contentEquals(us.getPassword())) {
					new UserDAO().persist(u);
				}
			} else {
				new UserDAO().persist(u);
			}
		}
	}
}
