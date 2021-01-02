package gui;

import board.Board;
import board.Square;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import pieces.Piece;
import pieces.PieceImages;

public class ChessUI extends Application 
{
	
	public static double DIMENSION = 800;
	
	public static void main(String[] pArgs)
	{
		launch(pArgs);
	}

	@Override
	public void start(Stage pStage)
	{
		pStage.setTitle("Chess");
		
		final GridPane boardView = new GridPane();
		boardView.setStyle("-fx-background-color: blue;");
		boardView.setHgap(10);
		boardView.setVgap(10);
		boardView.setPadding(new Insets(10));
		
		Board model = Board.instance();
		
		for ( Square square : model )
		{
			boardView.add(square.getView(), square.getCoords()[0], square.getCoords()[1]);
		}
		
		pStage.setResizable(false);
		pStage.setScene(new Scene(boardView, DIMENSION, DIMENSION));
		pStage.show();
	}

	private static void setPiecesOnAction()
	{
		for ( Piece piece : Piece.ALL_PIECES ) 
		{
//			piece.getPieceView().setOnAction(new MovePieceHandler(piece.getPieceView()));
		}
	}
	
}
