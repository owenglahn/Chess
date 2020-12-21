package chess;

import java.util.*;

/*
 * Utilize hybrid FLYWEIGHT/SINGLETON design pattern.
 */
public abstract class Piece {
	
	protected final Color aColor;
	protected int[] aCoords = new int[2];
	/*
	 * Pieces can be removed, but not added or changed.
	 * 
	 * Switch statement antipattern. However, this is a controlled setting (no user input), no issues with 
	 * code fragility.
	 */
	public static final List<Piece> PIECES = new ArrayList<Piece>();
	{
		for (int i = 0; i < 32; i++)
		{
			if (i < 16) PIECES.add(new Pawn(Color.values()[i%2]));
			else if (i < 20) PIECES.add(new Bishop(Color.values()[i%2]));
			else if (i < 24) PIECES.add(new Knight(Color.values()[i%2]));
			else if (i < 28) PIECES.add(new Rook(Color.values()[i%2]));
			else if (i < 30) PIECES.add(new Queen(Color.values()[i%2]));
			else PIECES.add(new King(Color.values()[i%2]));
		}
	}
	
	protected Piece(Color pColor)
	{
		aColor = pColor;
	}

	public Color getColor()
	{
		return aColor;
	}
	
	/*
	 * @pre pRow >= 0, pColumn >= 0
	 * @post set coordinates to pRow and pColumn
	 */
	public void setCoords(int pRow, int pColumn)
	{
		aCoords[0] = pRow;
		aCoords[1] = pColumn;
	}
	
	/*
	 * @pre pSquare != null
	 */
	public void move(Square pSquare) 
	{
		assert pSquare != null;
		if (pSquare.isOccupied()) 
		{
			PIECES.remove(pSquare.getPiece());
		}
		pSquare.setPiece(this);
		aCoords[0] = pSquare.getCoords()[0];
		aCoords[1] = pSquare.getCoords()[1];
	}
	
	protected boolean isValidMove(Square pSquare)
	{
		if (pSquare.isOccupied() && pSquare.getPiece().getColor() == aColor) return false;
		return (pSquare.getCoords()[0] != aCoords[0] && pSquare.getCoords()[1] != aCoords[1]);
	}
}
