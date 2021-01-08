package board;

import java.util.Optional;

import pieces.Color;
import pieces.Piece;
import gui.PieceView;
import gui.SquareView;

public class Square {

	private final Color aColor;
	private Optional<Piece> aPiece = Optional.empty();
	private final SquareView aObserver;
	
	public Square(Color pColor, Piece pPiece)
	{
		aPiece = Optional.ofNullable(pPiece);
		aColor = pColor;
		aObserver = new SquareView(this);
	}
	
	public Square( Color pColor)
	{
		aColor = pColor;
		aObserver = new SquareView(this);
	}
	
	public Color getColor()
	{
		return aColor;
	}
	
	/*
	 * 
	 */
	public Optional<Piece> getPiece()
	{
		return aPiece;
	}
	
	public SquareView getView()
	{
		return aObserver;
	}
	
	public PieceView getPieceView()
	{
		return aPiece.get().getPieceView();
	}
	
	public boolean isOccupied()
	{
		return ! aPiece.isEmpty();
	}
}
