package pieces;

import board.*;

public class Pawn extends Piece
{
	protected Pawn(Color pColor)
	{
		super(pColor);
	}

	@Override
	protected boolean isValidMove(Board pBoard, Square pSquare) {
		if (!super.isValidMove(pBoard, pSquare)) return false;
		if (pSquare.isOccupied())
		{
			if (pBoard.getCoordsOfSquare(pSquare)[0] == 1 + super.aCoords[0] && Math.abs(pBoard.getCoordsOfSquare(pSquare)[1] - super.aCoords[1]) == 1) return true;
			return false;
		}
		return pBoard.getCoordsOfSquare(pSquare)[0] == super.aCoords[0] + 1 && pBoard.getCoordsOfSquare(pSquare)[1] == super.aCoords[1];
	}
}
