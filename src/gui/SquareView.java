package gui;

import board.*;
import pieces.Color;
import javafx.scene.layout.StackPane;

public class SquareView extends StackPane {
	
	private Square aSquare;
	
	private static final int DIMENSION = ChessUI.DIMENSION/8;
	
	public SquareView(Square pSquare) 
	{
		aSquare = pSquare;
		this.setPrefSize(DIMENSION, DIMENSION);
		this.setStyle(this.getColorCSS());
	}
	
	public void pieceEntered()
	{
		getChildren().add(aSquare.getPieceView());
	}
	
	public String getColorCSS()
	{
		return aSquare.getColor().getColorCSS();
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
