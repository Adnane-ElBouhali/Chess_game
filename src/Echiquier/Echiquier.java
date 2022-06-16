package Echiquier;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import Pieces.Fou;
import Pieces.Roi;
import Pieces.Cheval;
import Pieces.Pion;
import Pieces.Reine;
import Pieces.Tour;

public class Echiquier extends Group {
	public static ArrayList<ArrayList<Square>> toutes_les_cases = new ArrayList<ArrayList<Square>>();

	public Echiquier() {

		for (int ligne = 0; ligne < 8; ligne++) {
			ArrayList<Square> ligne_de_cases = new ArrayList<Square>();
			for (int colonne = 0; colonne < 8; colonne++) {

				Color couleur = Color.DIMGRAY;
				if ((ligne + colonne) % 2 == 0) {
					couleur = Color.WHITE;
				}

				Square square = new Square(couleur);
				square.setTranslateX(colonne * Square.SIZE);
				square.setTranslateY(ligne * Square.SIZE);
				this.getChildren().add(square);
				ligne_de_cases.add(square);

				// Pions
				if (ligne == 1) {
					square.ajouterPiece(new Pion(Color.BLACK));
				}

				if (ligne == 6) {
					square.ajouterPiece(new Pion(Color.WHITE));
				}

				// Tours
				if (ligne == 0) {
					if (colonne == 0 || colonne == 7) {
						square.ajouterPiece(new Tour(Color.BLACK));
					}
				}

				if (ligne == 7) {
					if (colonne == 0 || colonne == 7) {
						square.ajouterPiece(new Tour(Color.WHITE));
					}
				}

				// Chevaux
				if (ligne == 0) {
					if (colonne == 1 || colonne == 6) {
						square.ajouterPiece(new Cheval(Color.BLACK));
					}
				}

				if (ligne == 7) {
					if (colonne == 1 || colonne == 6) {
						square.ajouterPiece(new Cheval(Color.WHITE));
					}
				}

				// Fous
				if (ligne == 0) {
					if (colonne == 2 || colonne == 5) {
						square.ajouterPiece(new Fou(Color.BLACK));
					}
				}

				if (ligne == 7) {
					if (colonne == 2 || colonne == 5) {
						square.ajouterPiece(new Fou(Color.WHITE));
					}
				}

				// Reines
				if (ligne == 0) {
					if (colonne == 3) {
						square.ajouterPiece(new Reine(Color.BLACK));
					}
				}

				if (ligne == 7) {
					if (colonne == 3) {
						square.ajouterPiece(new Reine(Color.WHITE));
					}
				}

				// Rois
				if (ligne == 0) {
					if (colonne == 4) {
						square.ajouterPiece(new Roi(Color.BLACK));
					}
				}

				if (ligne == 7) {
					if (colonne == 4) {
						square.ajouterPiece(new Roi(Color.WHITE));
					}
				}
			}
			toutes_les_cases.add(ligne_de_cases);
		}
	}

	public static Square getSquare(int x, int y) {
		return toutes_les_cases.get(y).get(x);
	}
	
}
