package gui;

import org.junit.Test;

import board.Board;
import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.Stage;
import pieces.Piece;

import static org.junit.Assert.*;

public class ChessUI extends Application 
{
	public static final int DIMENSION = 600;
	
	public static void main(String[] pArgs)
	{
		launch(pArgs);
	}

	@Override
	public void start(Stage pStage) throws Exception
	{
		try {
			pStage.setTitle("Chess");
			
			Board model = Board.instance();
			BoardObserver root = model.getObserver();
			
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
}
