package Application;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import Echiquier.Echiquier;
import Echiquier.Square;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;


public class application extends Application {
	public static Stage fenetre;

	
	private static Scene fin_de_partie;
	private static Scene victoire;	


	public static void main(String[] args) {
		launch();
	}

	public void start(Stage primaryStage) throws Exception {

		fenetre = primaryStage;

		// Menu----------------------------------------------------------

		Label Nom_du_jeu = new Label("Jeu d'echecs");
		Button Jouer = new Button("Jouer");
		Button Quiter = new Button("Quiter");

		VBox menuVBox = new VBox(40);
		menuVBox.setAlignment(Pos.CENTER);

		menuVBox.getChildren().addAll(Nom_du_jeu, Jouer, Quiter);

		Scene menuScene = new Scene(menuVBox, Square.SIZE * 8 - 10, Square.SIZE * 8 - 10);

		// Jeu----------------------------------------------------------

		Echiquier board = new Echiquier();
		Scene gameScene = new Scene(board, Square.SIZE * 8, Square.SIZE * 8);

		// Victoire----------------------------------------------------------

		Label win = new Label("CONGRATULATIONS, YOU WIN!");


		VBox winVBox = new VBox(40);
		winVBox.setAlignment(Pos.CENTER);

		winVBox.getChildren().add(win);

		victoire = new Scene(winVBox, Square.SIZE * 8, Square.SIZE * 8, Color.BLACK);

		Jouer.setOnAction(e -> primaryStage.setScene(gameScene));
		Quiter.setOnAction(e -> System.exit(0));

		// Fin de partie----------------------------------------------------------

		Label gameOverLabel = new Label("Fin de partie !");



		VBox gameOverVBox = new VBox(40);
		gameOverVBox.setAlignment(Pos.CENTER);

		gameOverVBox.getChildren().add(gameOverLabel);

		fin_de_partie = new Scene(gameOverVBox, Square.SIZE * 8, Square.SIZE * 8, Color.BLACK);

		fenetre.setTitle("Chess Game");
		fenetre.setScene(menuScene);
		fenetre.show();
	}

	public static void gameOver() {
		fenetre.setScene(fin_de_partie);
	}

	public static void win() {
		fenetre.setScene(victoire);
	}

}
