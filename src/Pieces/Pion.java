package Pieces;

import Echiquier.Echiquier;
import Echiquier.Square;
import javafx.scene.paint.Color;

public class Pion extends Piece {

	private boolean hasMoved = false;

	public Pion(Color c) {
		super(c);
	}

	public void showMove(int x, int y) {
		if (this.getColor() == Color.WHITE) {
			Square s1 = Echiquier.getSquare(x, y - 1);
			if (!s1.hasPiece()) {
				s1.mouvements_possibles();
			} else {
				return;
			}
			if (!hasMoved) {
				Square s2 = Echiquier.getSquare(x, y - 2);
				if (!s2.hasPiece()) {
					s2.mouvements_possibles();
				} else {
					return;
				}
			}
		} else {
			Square s1 = Echiquier.getSquare(x, y + 1);
			if (!s1.hasPiece()) {
				s1.mouvements_possibles();
			}
			if (!hasMoved) {
				Square s2 = Echiquier.getSquare(x, y + 2);
				if (!s2.hasPiece()) {
					s2.mouvements_possibles();
				}
			}
		}

		if (x - 1 > 0 || y - 1 > 0 || x + 1 < 7 || y + 1 < 7) {
			return;
		} else {
			// White Right Up
			if (this.getColor() == Color.WHITE) {
				Square s3 = Echiquier.getSquare(x + 1, y - 1);
				if (s3.hasPiece() && this.getColor() != Color.BLACK) {
					s3.mouvements_possibles();
				}

				// White Left Up
				Square s5 = Echiquier.getSquare(x - 1, y - 1);
				if (s5.hasPiece() && this.getColor() != Color.BLACK) {
					s5.mouvements_possibles();
				} else {
					return;
				}
			}

			// Black Right Down
			if (this.getColor() == Color.BLACK) {
				Square s4 = Echiquier.getSquare(x + 1, y + 1);
				if (s4.hasPiece() && this.getColor() != Color.WHITE) {
					s4.mouvements_possibles();
				}

				// Black Left Down
				Square s3 = Echiquier.getSquare(x - 1, y + 1);
				if (s3.hasPiece() && this.getColor() != Color.WHITE) {
					s3.mouvements_possibles();
				} else {
					return;
				}
			}
		}
	}
	
	public void changePawnToQueen() {
		
	}

	public void move() {
		hasMoved = true;
	}

	public void hideMove() {

	}
}
