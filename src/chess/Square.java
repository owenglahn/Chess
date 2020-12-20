package chess;

import java.util.Optional;

public class Square {

	private Color aColor;
	private Optional<Piece> aPiece;
	private int[] aCoords = new int[2];
	
	private Square(Color pColor)
	{
		aColor = pColor;
	}
	
	public Color getColor() 
	{
		return aColor;
	}
	
	/*
	 * @pre ! aPiece.isEmpty()
	 */
	public Piece getPiece()
	{
		assert ! aPiece.isEmpty();
		return aPiece.get();
	}
	
	/*
	 * @param pPiece is the piece to be set to this square
	 */
	public void setPiece(Piece pPiece)
	{
		aPiece = Optional.ofNullable(pPiece);
	}
	
	public boolean isOccupied()
	{
		return ! aPiece.isEmpty();
	}
	
	public int[] getCoords()
	{
		return aCoords;
	}
	
	public void setCoords(int pRow, int pColumn)
	{
		assert pRow >= 0;
		assert pColumn >= 0;
		aCoords[0] = pRow;
		aCoords[1] = pColumn;
	}
}
