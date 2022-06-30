package tondeuse;

public class Traitement {

	// Traitement des instructions de deplacement et d'orientation
	public Tondeuse traitentInstruction(Tondeuse tondeuse,Surface surface,Operation operation) {
		
		//// Instruction Rotation gauche
		if (operation.getInstruction()=='G') {
			switch (tondeuse.getDirection()) {
				case 'N':
					tondeuse.setDirection('O');
					break;
				case 'O':
					tondeuse.setDirection('S');
					break;
				case 'S':
					tondeuse.setDirection('E');
					break;
				case 'E':
					tondeuse.setDirection('N');
					break;
			}
		}
		//// Instruction Rotation droite
		if (operation.getInstruction()=='D') {
			switch (tondeuse.getDirection()) {
				case 'E':
					tondeuse.setDirection('N');
					break;
				case 'N':
					tondeuse.setDirection('O');
					break;
				case 'O':
					tondeuse.setDirection('S');
					break;
				case 'S':
					tondeuse.setDirection('E');
					break;
			}
		}

		////  instruction deplacement
		if (operation.getInstruction()=='A') {
			switch (tondeuse.getDirection()) {
			case 'N':
				if (tondeuse.getPosY()<=surface.posYMax) {
					tondeuse.setPosY(tondeuse.getPosY()+1);
				}
				break;
			case 'S':
				if (tondeuse.getPosY()>=surface.posYMin) {
					tondeuse.setPosY(tondeuse.getPosY()-1);
				}
				break;
			case 'O':
				if (tondeuse.getPosX()<=surface.posXMax) {
					tondeuse.setPosX(tondeuse.getPosX()+1);
				}	
				break;
			case 'E':
				if (tondeuse.getPosX()>=surface.posXMin) {
					tondeuse.setPosX(tondeuse.getPosX()-1);
				}
				break;
		}
	}
	return tondeuse;
	}
	}
