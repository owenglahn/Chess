package pieces;

import board.*;

public class Knight extends Piece
{
	protected Knight(Color pColor)
	{
		super(pColor);
	}

	@Override
	protected boolean isValidMove(Square pSquare) {
		if (!super.isValidMove(pSquare)) return false;
		return (Math.abs(pSquare.getCoords()[0] - super.aCoords[0]) == 2 && Math.abs(pSquare.getCoords()[1] - super.aCoords[1]) == 1) || 
				(Math.abs(pSquare.getCoords()[0] - super.aCoords[0]) == 1 && Math.abs(pSquare.getCoords()[1] - super.aCoords[1]) == 2); 
	}
	
}
