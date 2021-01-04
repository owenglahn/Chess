package gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

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

import static org.junit.Assert.*;

public class ChessUI extends Application 
{
	public static final double DIMENSION = 800;
	
	public static void main(String[] pArgs)
	{
		launch(pArgs);
	}

	@Override
	public void start(Stage pStage) throws Exception
	{
		try {
			pStage.setTitle("Chess");
			
			final GridPane root = new GridPane();
			root.setStyle("-fx-background-color: red;");
			root.setHgap(10);
			root.setVgap(10);
			root.setPadding(new Insets(10));
			
			Board model = new Board();
			
			for ( Square square : model )
			{
				root.add(square.getView(), model.getCoordsOfSquare(square)[0], model.getCoordsOfSquare(square)[1]);
			}
			
			pStage.setResizable(false);
			pStage.setScene(new Scene(root, DIMENSION, DIMENSION));
			pStage.show();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private static void setPiecesOnAction()
	{
		for ( Piece piece : Piece.ALL_PIECES ) 
		{
//			piece.getPieceView().setOnAction(new MovePieceHandler(piece.getPieceView()));
		}
	}
	
	private static List<HBox> setup(Board pBoard)
	{
		List<HBox> toReturn = new ArrayList<>();
		for ( int i = 0 ; i < 8 ; i++ )
		{
			toReturn.add(new HBox());
			toReturn.get(i).getChildren().addAll(pBoard.getGridObserver().get(i));
		}
		return toReturn;
	}
	
}
