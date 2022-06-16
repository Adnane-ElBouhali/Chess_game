package Pieces;

import Echiquier.Echiquier;
import Echiquier.Square;
import javafx.scene.paint.Color;

public class Tour extends Piece {

	@SuppressWarnings("unused")
	private boolean hasMoved = false;

	public Tour(Color c) {
		super(c);
	}

	public void showMove(int x, int y) {

		// Left
		for (int i = 1; i < 8; i++) {
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
		for (int i = 1; i < 8; i++) {
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
		for (int i = 1; i < 8; i++) {
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
		for (int i = 1; i < 8; i++) {
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
	}

	public void move() {
	}

	public void hideMove() {

	}
}
