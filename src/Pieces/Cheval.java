package Pieces;

import Echiquier.Echiquier;
import Echiquier.Square;
import javafx.scene.paint.Color;

public class Cheval extends Piece {

	public Cheval(Color c) {
		super(c);
	}

	public void showMove(int x, int y) {

		// Up Right
		if (x + 1 < 8 && y + 2 < 8) {
			Square s1 = Echiquier.getSquare(x + 1, y + 2);
			s1.mouvements_possibles();
		}

		// Right Up
		if (x + 2 < 8 && y + 1 < 8) {
			Square s1 = Echiquier.getSquare(x + 2, y + 1);
			s1.mouvements_possibles();
		}

		// Right Down
		if (x + 2 < 8 && y - 1 >= 0) {
			Square s1 = Echiquier.getSquare(x + 2, y - 1);
			s1.mouvements_possibles();
		}

		// Down Right
		if (x + 1 < 8 && y - 2 >= 0) {
			Square s1 = Echiquier.getSquare(x + 1, y - 2);
			s1.mouvements_possibles();
		}

		// Down Left
		if (x - 1 >= 0 && y - 2 >= 0) {
			Square s1 = Echiquier.getSquare(x - 1, y - 2);
			s1.mouvements_possibles();
		}

		// Left Down
		if (x - 2 >= 0 && y - 1 >= 0) {
			Square s1 = Echiquier.getSquare(x - 2, y - 1);
			s1.mouvements_possibles();
		}

		// Left Up
		if (x - 2 >= 0 && y + 1 < 8) {
			Square s1 = Echiquier.getSquare(x - 2, y + 1);
			s1.mouvements_possibles();
		}

		// Up Left
		if (x - 1 >= 0 && y + 2 < 8) {
			Square s1 = Echiquier.getSquare(x - 1, y + 2);
			s1.mouvements_possibles();
		}
	}

	public void hideMove() {

	}
}