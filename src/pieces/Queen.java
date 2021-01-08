package pieces;

import board.*;

public class Queen extends Piece
{
	protected Queen(Color pColor)
	{
		super(pColor);
	}

	@Override
	protected boolean isValidMove(Board pBoard, Square pSquare) {
		if (!super.isValidMove(pBoard, pSquare)) return false;
		return (new Rook(this).isValidMove(pBoard, pSquare)) || (new Bishop(this)).isValidMove(pBoard, pSquare); // queen can move like bishop or rook
	}
}
