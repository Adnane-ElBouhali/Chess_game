package Pieces;

import Echiquier.Echiquier;
import Echiquier.Square;
import javafx.scene.paint.Color;

public class Roi extends Piece {

	public Roi(Color c) {
		super(c);
	}

	public void showMove(int x, int y) {

		// Left
		for (int i = 1; i < 2; i++) {
			if (x - i < 0) {
				break;
			}
			Square s1 = Echiquier.getSquare(x - i, y);
			if (!s1.hasPiece()) {
				s1.marquer(getColor());
			} else {
				s1.marquer(getColor());
				break;
			}
		}

		// Right
		for (int i = 1; i < 2; i++) {
			if (x + i > 7) {
				break;
			}
			Square s1 = Echiquier.getSquare(x + i, y);
			if (!s1.hasPiece()) {
				s1.marquer(getColor());
			} else {
				s1.marquer(getColor());
				break;
			}
		}

		// Up
		for (int i = 1; i < 2; i++) {
			if (y - i < 0) {
				break;
			}
			Square s1 = Echiquier.getSquare(x, y - i);
			if (!s1.hasPiece()) {
				s1.marquer(getColor());
			} else {
				s1.marquer(getColor());
				break;
			}
		}

		// Down
		for (int i = 1; i < 2; i++) {
			if (y + i > 7) {
				break;
			}
			Square s1 = Echiquier.getSquare(x, y + i);
			if (!s1.hasPiece()) {
				s1.marquer(getColor());
			} else {
				s1.marquer(getColor());
				break;
			}
		}

		// Up Left
		for (int i = 1; i < 2; i++) {
			if (x - i < 0 || y - i < 0) {
				break;
			}
			Square s1 = Echiquier.getSquare(x - i, y - i);
			if (!s1.hasPiece()) {
				s1.marquer(getColor());
			} else {
				s1.marquer(getColor());
				break;
			}
		}

		// Up Right
		for (int i = 1; i < 2; i++) {
			if (x + i > 7 || y - i < 0) {
				break;
			}
			Square s1 = Echiquier.getSquare(x + i, y - i);
			if (!s1.hasPiece()) {
				s1.marquer(getColor());
			} else {
				s1.marquer(getColor());
				break;
			}
		}

		// Down Left
		for (int i = 1; i < 2; i++) {
			if (x + i > 7 || y + i > 7) {
				break;
			}
			Square s1 = Echiquier.getSquare(x + i, y + i);
			if (!s1.hasPiece()) {
				s1.marquer(getColor());
			} else {
				s1.marquer(getColor());
				break;
			}
		}

		// Down Right
		for (int i = 1; i < 2; i++) {
			if (x - i < 0 || y + i > 7) {
				break;
			}
			Square s1 = Echiquier.getSquare(x - i, y + i);
			if (!s1.hasPiece()) {
				s1.marquer(getColor());
			} else {
				s1.marquer(getColor());
				break;
			}
		}
	}

	public void hideMove() {

	}
}