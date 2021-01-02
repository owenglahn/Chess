package board;

import java.util.*;

import gui.BoardObserver;
import pieces.Color;
import pieces.Piece;

/*
 * Serves as the model in the OBSERVER design pattern.
 * 
 * Implements SINGLETON design pattern
 */
public class Board implements Iterable<Square> {

	// duplicated data
	private Square[][] aGrid = new Square[8][8];
	private final BoardObserver aObserver = new BoardObserver(this);
	private static final Board BOARD = new Board(); // singleton

	private Board() {
	}
	
	public static Board instance()
	{
		return BOARD;
	}
	
	public Square[][] getGrid()
	{
		return aGrid;
	}
	
	/*
	 * Returns true if pColor won.
	 */
	public boolean hasCheckMate(Color pColor)
	{
		return false;
	}
	
	public void endGame()
	{
		if (hasCheckMate(Color.BLACK))
			aObserver.winnerClaimed(Color.BLACK);
		else if (hasCheckMate(Color.WHITE))
			aObserver.winnerClaimed(Color.WHITE);
	}

	@Override
	public Iterator<Square> iterator() {
		// TODO Auto-generated method stub
		return new BoardIterator();
	}
	
	private static class BoardIterator implements Iterator<Square>
	{
		Iterator<Square[]> aRow = Arrays.asList(BOARD.aGrid).iterator();
		Iterator<Square> aColumn = Arrays.asList(BOARD.aGrid[0]).iterator();
		
		@Override
		public boolean hasNext() {
			if (!aColumn.hasNext()) return aRow.hasNext();
			return aColumn.hasNext();
		}

		@Override
		public Square next() {
			if (aColumn.hasNext()) return aColumn.next();
			if (aRow.hasNext()) aColumn = Arrays.asList(aRow.next()).iterator();
			return aColumn.next();
		}
	}
}
