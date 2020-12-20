package chess;

public abstract class Piece {
	
	private Color aColor;
	
	protected Piece(Color pColor)
	{
		aColor = pColor;
	}

	public abstract void move(Square pSquare);
	public abstract void isValidMove(Square pSquare);
	
}
