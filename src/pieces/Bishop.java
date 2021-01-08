package pieces;

import board.*;

public class Bishop extends Piece 
{

	protected Bishop(Color pColor)
	{
		super(pColor);
	}
	
	protected Bishop(Piece pPiece)
	{
		super(pPiece.getColor());
	}

	@Override
	protected boolean isValidMove(Board pBoard, Square pSquare) {
		if (!super.isValidMove(pBoard, pSquare)) return false;
		return Math.abs(pBoard.getCoordsOfSquare(pSquare)[0]-super.aCoords[0]) == 
				Math.abs(pBoard.getCoordsOfSquare(pSquare)[1] - super.aCoords[1]);
	}
	
}
