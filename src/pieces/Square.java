package pieces;

import java.util.Arrays;
import javafx.scene.shape.*;
import board.Board;

public class Square {

	private Color aColor;
	private final Rectangle aRectangle = new Rectangle();
	
	public Square(Color pColor)
	{
		aColor = pColor;
	}
	
	public Color getColor() 
	{
		return aColor;
	}
	
	/*
	 * @pre !Board.BOARD.getPiece(this).isEmpty()
	 */
	public Piece getPiece()
	{
		assert ! Board.BOARD.getPiece(this).isEmpty();
		return Board.BOARD.getPiece(this).get();
	}
	
	public boolean isOccupied()
	{
		return ! Board.BOARD.getPiece(this).isEmpty();
	}
	
	public int[] getCoords()
	{
		int[] coords = {-1, -1};
		for(Square[] sArr : Board.BOARD.getGrid())
		{
			if (Arrays.asList(sArr).contains(this))
			{
				coords[0] = Arrays.asList(Board.BOARD.getGrid()).indexOf(sArr); // long method call design antipattern
				coords[1] = Arrays.asList(sArr).indexOf(this);
			}
		}
		return coords;
	}
}
