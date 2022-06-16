package Echiquier;

import java.util.ArrayList;

import Application.application;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import Pieces.Roi;
import Pieces.Piece;

public class Square extends Group {

	public static final double SIZE = 80;
	private Rectangle rec;
	private Color couleur_originale;
	private Piece piece;
	public static Square active;
	private static int compteur_de_tours = 0;
	public static ArrayList<Square> marked = new ArrayList<Square>();

	public Square(Color couleur) {
		couleur_originale = couleur;
		rec = new Rectangle(SIZE, SIZE, couleur);
		this.getChildren().add(rec);

		this.setOnMouseClicked(event -> {

			if (marked.contains(this)) {
				Piece piece = active.piece;
				if (this.piece instanceof Roi) {
					if (this.piece.getColor() == Color.WHITE) {
						application.gameOver();
						System.out.println("Fin de partie ! Vous avez perdu.");
					}
					if (this.piece.getColor() == Color.BLACK) {
						application.win();
						System.out.println("Félicitations ! Vous avez gagnez en "+ Square.compteur_de_tours + " tours.");
					}
					return;
				}
				active.piece = null;
				active.makeInactive();
				compteur_de_tours++;
				System.out.println("Turn #"+ compteur_de_tours);
				this.ajouterPiece(piece);
				piece.move();
				return;
			}

			if (!hasPiece()) {
				return;
			}

			if (hasPiece()) {
				if (compteur_de_tours % 2 == 0 && piece.getColor() == Color.BLACK) { // Blanc
					return;
				}
				if (compteur_de_tours % 2 == 1 && piece.getColor() == Color.WHITE) { // Noir
					return;
				}
				makeActive();
				@SuppressWarnings("unused")
				int ligne = ligne();
				@SuppressWarnings("unused")
				int colonne = colonne();
			} else {
				if (active != null) {
					active.makeInactive();
				}
				marquer(this.piece.getColor());
			}
		});
	}

	private int colonne() {
		int y = ligne();
		for (int i = 0; i < 8; i++) {
			if (Echiquier.toutes_les_cases.get(y).get(i) == this) {
				return i;
			}
		}
		return -1;
	}

	public int ligne() {
		for (int i = 0; i < 8; i++) {
			if (Echiquier.toutes_les_cases.get(i).contains(this)) {
				return i;
			}
		}
		return -1;
	}

	public void mouvements_possibles() {
		Circle cir = new Circle(SIZE / 2, SIZE / 2, SIZE / 10, Color.BLACK);
		this.getChildren().add(cir);
		marked.add(this);
	}

	public void marquer(Color couleur) {
		if (!this.hasPiece()) {
			mouvements_possibles();
		} else {
			if (this.piece.getColor() != couleur) {
				attaquer_Marque();
			}
		}
	}

	public void attaquer_Marque() {
		Circle cir = new Circle(SIZE / 2, SIZE / 2, SIZE / 10, Color.RED);
		this.getChildren().add(cir);
		marked.add(this);
	}

	private void retirer_Marque() {
		for (Square square : marked) {
			square.getChildren().remove(square.getChildren().size() - 1);
		}
		marked.clear();
	}

	private void makeActive() {
		if (active != null) {
			active.makeInactive();
		}
		active = this;
		this.piece.showMove(colonne(), ligne());
		this.getBackground().setFill(Color.GREEN);
	}

	private void makeInactive() {
		retirer_Marque();
		active = null;
		this.getBackground().setFill(couleur_originale);
	}

	public void ajouterPiece(Piece p) {
		if (hasPiece()) {
			this.getChildren().remove(piece);
		}
		this.piece = p;
		this.getChildren().add(p);
	}

	public boolean hasPiece() {
		return (this.piece != null);
	}

	public Rectangle getBackground() {
		return this.rec;
	}

	public Boolean tour(int i) {
		boolean Tour_des_blancs = true;
		if (i % 2 == 0) {
			return Tour_des_blancs = false;
		} else {
			return Tour_des_blancs;
		}
	}
}