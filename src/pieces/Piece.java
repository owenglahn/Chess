package pieces;

import java.util.*;

import board.*;
import gui.*;

/*
 * Utilize hybrid FLYWEIGHT/SINGLETON design pattern.
 * 
 * Pieces cannot be added or changed.
 */
public abstract class Piece {
	
	protected final Color aColor;
	protected int[] aCoords = new int[2];
	private final PieceView aPieceView = new PieceView(this);

	public static final List<Piece> ALL_PIECES = new ArrayList<>();
	{
		ALL_PIECES.addAll(WHITE_PAWNS);
		ALL_PIECES.addAll(BLACK_PAWNS);
		ALL_PIECES.addAll(WHITE_ROOKS);
		ALL_PIECES.addAll(BLACK_ROOKS);
		ALL_PIECES.addAll(WHITE_KNIGHTS);
		ALL_PIECES.addAll(BLACK_KNIGHTS);
		ALL_PIECES.addAll(WHITE_BISHOPS);
		ALL_PIECES.addAll(BLACK_BISHOPS);
		ALL_PIECES.add(WHITE_KING);
		ALL_PIECES.add(BLACK_KING);
		ALL_PIECES.add(WHITE_QUEEN);
		ALL_PIECES.add(BLACK_QUEEN);
	}
	public static final List<Piece> WHITE_PAWNS = new ArrayList<>();
	{
		for (int i = 0; i < 8; i++)
		{
			WHITE_PAWNS.add(new Pawn(Color.WHITE));
		}
	}
	public static final List<Piece> BLACK_PAWNS = new ArrayList<>();
	{
		for (int i = 0; i < 8; i++)
		{
			BLACK_PAWNS.add(new Pawn(Color.BLACK));
		}
	}
	public static final List<Piece> WHITE_ROOKS = new ArrayList<>();
	{
		for (int i = 0; i< 2; i++)
		{
			WHITE_ROOKS.add(new Rook(Color.WHITE));
		}
	}
	public static final List<Piece> BLACK_ROOKS = new ArrayList<>();
	{
		for (int i = 0; i< 2; i++)
		{
			BLACK_ROOKS.add(new Rook(Color.BLACK));
		}
	}
	public static final List<Piece> WHITE_KNIGHTS = new ArrayList<>();
	{
		for (int i = 0; i < 2; i++)
		{
			WHITE_KNIGHTS.add(new Knight(Color.WHITE));
		}
	}
	public static final List<Piece> BLACK_KNIGHTS = new ArrayList<>();
	{
		for (int i = 0; i < 2; i++)
		{
			BLACK_KNIGHTS.add(new Knight(Color.BLACK));
		}
	}
	public static final List<Piece> WHITE_BISHOPS = new ArrayList<>();
	{
		for (int i = 0; i < 2; i++)
		{
			WHITE_BISHOPS.add(new Bishop(Color.WHITE));
		}
	}
	public static final List<Piece> BLACK_BISHOPS = new ArrayList<>();
	{
		for (int i = 0; i < 2; i++)
		{
			BLACK_BISHOPS.add(new Bishop(Color.BLACK));
		}
	}
	public static final Piece WHITE_KING = new King(Color.WHITE);
	public static final Piece WHITE_QUEEN = new Queen(Color.WHITE);
	public static final Piece BLACK_KING = new King(Color.BLACK);
	public static final Piece BLACK_QUEEN = new Queen(Color.BLACK);
	
	protected Piece(Color pColor)
	{
		aColor = pColor;
	}

	public Color getColor()
	{
		return aColor;
	}
	
	public PieceView getPieceView()
	{
		return aPieceView;
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
		
	}
	
	protected boolean isValidMove(Square pSquare)
	{
//		if (pSquare.isOccupied() && pSquare.getPiece().getColor() == aColor) return false; 
		return (pSquare.getCoords()[0] != aCoords[0] && pSquare.getCoords()[1] != aCoords[1]);
	}
	
	public String getIDString()
	{
		return Integer.toString(hashCode());
	}
	
	public boolean colorEquals(Piece pPiece)
	{
		return getColor().equals(pPiece.getColor());
	}
}
