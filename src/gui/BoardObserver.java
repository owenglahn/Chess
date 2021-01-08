package gui;

import board.Board;
import board.Square;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import pieces.Color;
import java.util.*;

public class BoardObserver extends GridPane {

	private Board aBoard;
//	private MovePieceHandler aHandler = new MovePieceHandler(new ImageView());
	private final List<List<SquareView>> aGridView = new ArrayList<>();

	public BoardObserver(Board pBoard) {
		aBoard = pBoard;
		setPadding(new Insets(10));
		setStyle("-fx-background-color: red;");
		setPrefSize(ChessUI.DIMENSION, ChessUI.DIMENSION);
	}
	
	public void boardInitialized()
	{
		int row = 0;
		for ( List<Square> list : aBoard.getGrid() )
		{
			HBox rowView = new HBox();
			addRow(row, rowView);
			for ( Square square : list )
			{
				rowView.getChildren().add(square.getView());
			}
			row ++;
		}
	}
	
	public List<SquareView> getRow(int pRow){
		return aGridView.get(pRow);
	}
	
	/*
	 * Helper
	 */
	private List<SquareView> getRowObservers(int pRow)
	{
		List<SquareView> toReturn = new ArrayList<>();
		for ( Square square : aBoard.getGrid().get(pRow) )
		{
			toReturn.add(square.getView());
		}
		return toReturn;
	}

	/* Callback methods. */

	public void pieceMoved() {
		/*
		 * Update board display.
		 */
		
	}

	public void winnerClaimed(Color pColor) {
		/*
		 * Display some winning message.
		 */
	}
}
