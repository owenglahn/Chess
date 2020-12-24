package pieces;

public class Queen extends Piece
{
	protected Queen(Color pColor)
	{
		super(pColor);
	}

	@Override
	protected boolean isValidMove(Square pSquare) {
		if (!super.isValidMove(pSquare)) return false;
		return (new Rook(this).isValidMove(pSquare)) || (new Bishop(this)).isValidMove(pSquare); // queen can move like bishop or rook
	}
}
