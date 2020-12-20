package chess;

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
	protected boolean isValidMove(Square pSquare) {
		if (!super.isValidMove(pSquare))return false;
		return pSquare.getCoords()[0] - super.aCoords[0] == 0 || pSquare.getCoords()[1] - super.aCoords[1] == 0;
	}
}
