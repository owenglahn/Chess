package pieces;

import board.*;

public class Rook extends Piece
{

	protected Rook(Color pColor) 
	{
		super(pColor);
	}
	
	protected Rook(Piece pPiece)
	{
		super(pPiece.getColor());
	}

	@Override
	protected boolean isValidMove(Board pBoard, Square pSquare) {
		if (!super.isValidMove(pBoard, pSquare))return false;
		return pBoard.getCoordsOfSquare(pSquare)[0] - super.aCoords[0] == 0 || 
				pBoard.getCoordsOfSquare(pSquare)[1] - super.aCoords[1] == 0;
	}
}
