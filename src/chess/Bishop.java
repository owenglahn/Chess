package chess;

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
	protected boolean isValidMove(Square pSquare) {
		if (!super.isValidMove(pSquare)) return false;
		return Math.abs(pSquare.getCoords()[0]-super.aCoords[0]) == Math.abs(pSquare.getCoords()[1] - super.aCoords[1]);
	}
	
}
