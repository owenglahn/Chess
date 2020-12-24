package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChessUI extends Application 
{
	
	public static void main(String[] pArgs)
	{
		launch(pArgs);
	}

	@Override
	public void start(Stage pStage)
	{
		pStage.setTitle("Chess");
		
		final GridPane chessBoard = new GridPane();
		chessBoard.setStyle("-fx-background-color: blue;");
		chessBoard.setHgap(10);
		chessBoard.setVgap(10);
		chessBoard.setPadding(new Insets(10));
		
	}

}
