package board;

import java.util.*;

import gui.BoardObserver;
import gui.SquareView;
import pieces.Color;

/*
 * Serves as the model in the OBSERVER design pattern.
 * 
 * Implements SINGLETON design pattern
 */
public class Board /*implements Iterable<Square>*/ {

	private final List<List<Square>> aGrid = new ArrayList<>();
	private final BoardObserver aObserver = new BoardObserver(this);
	
	private static final Board BOARD = new Board(); // singleton

	private Board() {
		for ( int i = 0 ; i < 8 ; i ++ )
		{
			aGrid.add(new ArrayList<Square>());
			for ( int j = 0 ; j < 8 ; j++ )
			{
				aGrid.get(i).add(new Square(Color.values()[(i + j) % 2]));
			}
		}
	}
	
	public static Board instance()
	{
		return BOARD;
	}
	
//	public List<List<Square>> getGrid()
//	{
//		return Collections.unmodifiableList(aGrid);
//	}
	
	public List<List<SquareView>> getGridObserver()
	{
		List<List<SquareView>> toReturn = new ArrayList<>();
		for ( int i = 0 ; i < 8 ; i ++ )
		{
			toReturn.add(new ArrayList<SquareView>());
			for ( int j = 0 ; j < 8 ; j++ )
			{
				toReturn.get(i).add(aGrid.get(i).get(j).getView());
			}
		}
		return toReturn;
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

//	@Override
//	public Iterator<Square> iterator() {
//		// TODO Auto-generated method stub
//		return new BoardIterator();
//	}
//	
//	private static class BoardIterator implements Iterator<Square>
//	{
//		private Iterator<Square[]> aRow = Arrays.asList(BOARD.aGrid).iterator();
//		private Iterator<Square> aColumn = Arrays.asList(BOARD.aGrid[0]).iterator();
//		
//		@Override
//		public boolean hasNext() {
//			if (!aColumn.hasNext()) return aRow.hasNext();
//			return aColumn.hasNext();
//		}
//
//		@Override
//		public Square next() {
//			if (aColumn.hasNext()) return aColumn.next();
//			if (aRow.hasNext()) aColumn = Arrays.asList(aRow.next()).iterator();
//			return aColumn.next();
//		}
//	}
}
