package board;

import java.util.*;

import gui.BoardObserver;
import pieces.Color;

/*
 * Serves as the model in the OBSERVER design pattern.
 * 
 * Implements SINGLETON design pattern
 */
public class Board implements Iterable<Square> {

	private final List<List<Square>> aGrid;
	private final BoardObserver aObserver = new BoardObserver(this);
	
	private final static Board BOARD = new Board();
	
	private Board() 
	{
		aGrid = new ArrayList<>();
		for (int i = 0 ; i < 8 ; i ++ )
		{
			aGrid.add(new ArrayList<>());
			for ( int j = 0 ; j < 8 ; j ++ )
			{
				Square current = new Square(Color.values()[(i + j) % 2]);
				aGrid.get(i).add(current);
			}
		}
		aObserver.boardInitialized();
	}
	
	public static Board instance()
	{
		return BOARD;
	}
	
	public BoardObserver getObserver()
	{
		return aObserver;
	}
	
	public List<List<Square>> getGrid()
	{
		return aGrid;
	}
	
	/*
	 * @pre 0 <= pRow < 8, 0 <= pCol < 8
	 */
	public Square getSquare(int pRow, int pCol)
	{
		assert pRow < aGrid.size() && pRow >= 0 && pCol < aGrid.get(0).size() && pCol >= 0;
		return aGrid.get(pRow).get(pCol);
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
	
	public int[] getCoordsOfSquare(Square pSquare)
	{
		int[] toReturn = new int[2];
		for ( List<Square> list : aGrid )
		{
			for ( Square square : list )
			{
				if ( pSquare.equals(square) )
				{
					toReturn[0] = aGrid.indexOf(list);
					toReturn[1] = list.indexOf(square);
				}
			}
		}
		return toReturn;
	}

	@Override
	public Iterator<Square> iterator() {
		return new BoardIterator();
	}
	
	private class BoardIterator implements Iterator<Square>
	{
		private Iterator<List<Square>> aRow = aGrid.iterator();
		private Iterator<Square> aColumn = aGrid.get(0).iterator();
		
		@Override
		public boolean hasNext() {
			if (!aColumn.hasNext()) return aRow.hasNext();
			return aColumn.hasNext();
		}

		@Override
		public Square next() {
			if (aColumn.hasNext()) return aColumn.next();
			if (aRow.hasNext()) aColumn = aRow.next().iterator();
			return aColumn.next();
		}
	}
}
