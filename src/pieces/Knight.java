package pieces;

import board.*;

public class Knight extends Piece
{
	protected Knight(Color pColor)
	{
		super(pColor);
	}

	@Override
	protected boolean isValidMove(Board pBoard, Square pSquare) {
		if (!super.isValidMove(pBoard, pSquare)) return false;
		return (Math.abs(pBoard.getCoordsOfSquare(pSquare)[0] - super.aCoords[0]) == 2 && Math.abs(pBoard.getCoordsOfSquare(pSquare)[1]
				- super.aCoords[1]) == 1) || (Math.abs(pBoard.getCoordsOfSquare(pSquare)[0] - super.aCoords[0]) == 
				1 && Math.abs(pBoard.getCoordsOfSquare(pSquare)[1] - super.aCoords[1]) == 2); 
	}
	
}
