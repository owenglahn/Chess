package chess;

import java.util.Optional;

public class Square {

	private Color aColor;
	private Optional<Piece> aOccupied;
	
	private Square(Color pColor)
	{
		aColor = pColor;
	}
	
	public Color getColor() 
	{
		return aColor;
	}
	
}
