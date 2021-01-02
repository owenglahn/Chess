package gui;

import board.*;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class SquareView extends StackPane {
	
	private Square aSquare;
	
	private static final int DIMENSION = 20;
	
	public SquareView(Square pSquare, double pX, double pY) 
	{
		super();
		aSquare = pSquare;
	}
	
	public void pieceEntered()
	{
		getChildren().add(aSquare.getPieceView());
	}
	
	public void pieceLeft()
	{
		// remove imageview
	}
	
	public void pieceChanged()
	{
		// only used when capture occurs
	}

}
