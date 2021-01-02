package board;

import java.util.Arrays;
import java.util.Optional;

import pieces.Color;
import pieces.Piece;
import gui.PieceView;
import gui.SquareView;

public class Square {

	private final Color aColor;
	private Optional<Piece> aPiece;
	private final SquareView aObserver = new SquareView(this, getCoords()[0], getCoords()[1]);
	
	public Square(Color pColor, Piece pPiece)
	{
		aPiece = Optional.ofNullable(pPiece);
		aColor = pColor;
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
	
	public int[] getCoords()
	{
		int[] coords = {-1, -1};
		for(Square[] sArr : Board.instance().getGrid())
		{
			if (Arrays.asList(sArr).contains(this))
			{
				coords[0] = Arrays.asList(Board.instance().getGrid()).indexOf(sArr); // long method call design antipattern
				coords[1] = Arrays.asList(sArr).indexOf(this);
			}
		}
		return coords;
	}
}
