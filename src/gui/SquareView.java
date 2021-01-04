package gui;

import board.*;
import pieces.Color;
import javafx.scene.layout.StackPane;

public class SquareView extends StackPane {
	
	private Square aSquare;
	
	private static final int DIMENSION = 20;
	
	public SquareView(Square pSquare) 
	{
		aSquare = pSquare;
		this.setPrefSize(DIMENSION/8, DIMENSION/8);
		if ( aSquare.getColor().equals(Color.BLACK) ) {
			this.setStyle("-fx-background-color: black;");
		}
		else {
			this.setStyle("-fx-background-color: white;");
		}
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
