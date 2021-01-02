package pieces;

import board.*;

public class Pawn extends Piece
{
	protected Pawn(Color pColor)
	{
		super(pColor);
	}

	@Override
	protected boolean isValidMove(Square pSquare) {
		if (!super.isValidMove(pSquare)) return false;
		if (pSquare.isOccupied())
		{
			if (pSquare.getCoords()[0] == 1 + super.aCoords[0] && Math.abs(pSquare.getCoords()[1] - super.aCoords[1]) == 1) return true;
			return false;
		}
		return pSquare.getCoords()[0] == super.aCoords[0] + 1 && pSquare.getCoords()[1] == super.aCoords[1];
	}
}
