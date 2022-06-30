package tondeuse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		List<String> listeDonnees = new ArrayList();
		try {
			Path path = Paths.get("c:/tondeuse/instructions.txt");
			listeDonnees = Files.readAllLines(path, StandardCharsets.UTF_8);
			System.out.println(listeDonnees);

		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] donnees = listeDonnees.get(0).split(" ");
		Tondeuse tondeuse;
		Surface surface = new Surface();
		Operation operation;
		Traitement traitement;
		surface.setPosXMax(Integer.parseInt(donnees[0]));
		surface.setPosYMax(Integer.parseInt(donnees[1]));
		String[] instructions = null;
		for (int i = 0; i < 2; i++) {
			tondeuse = new Tondeuse();
			operation = new Operation();
			traitement = new Traitement();
			switch (i) {
			case 0:
				tondeuse.setPosX(Integer.parseInt(donnees[2]));
				tondeuse.setPosY(Integer.parseInt(donnees[3]));
				tondeuse.setDirection(donnees[4].charAt(0));
				instructions = donnees[5].split("");
				break;
			case 1:
				tondeuse.setPosX(Integer.parseInt(donnees[6]));
				tondeuse.setPosY(Integer.parseInt(donnees[7]));
				tondeuse.setDirection(donnees[8].charAt(0));
				instructions = donnees[9].split("");
				break;
			}
			/// Traitement des instructions de deplacement et de changement de direction
			for (String instruction : instructions) {
				operation.setInstruction(instruction.charAt(0));
				traitement.traitentInstruction(tondeuse, surface, operation);
			}
			System.out.println("Tondeuse : " + (i + 1));
			System.out.println(tondeuse.getPosX());
			System.out.println(tondeuse.getPosY());
			System.out.println(tondeuse.getDirection());

		}
	}
}
