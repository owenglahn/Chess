package board;

import java.util.*;

import gui.BoardObserver;
import pieces.Color;
import pieces.Piece;
import pieces.Square;

/*
 * Serves as the model in the OBSERVER design pattern.
 */
public class Board implements Iterable<Square> {

	// duplicated data
	private Square[][] aGrid = new Square[8][8];
	private Map<Square, Optional<Piece>> aPieces = new HashMap<>();
	private final BoardObserver aObserver = new BoardObserver(this);
	public static final Board BOARD = new Board(); // singleton
	{
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				BOARD.aGrid[i][j] = new Square(Color.values()[(i + j) % 2]);
			}
		}
		setBoard();
	}

	private Board() {
	}

	public Optional<Piece> getPiece(Square pSquare) {
		return aPieces.get(pSquare);
	}

	public void setPiece(Square pSquare, Piece pPiece) {
		aPieces.put(pSquare, Optional.ofNullable(pPiece));
	}
	
	public Square[][] getGrid()
	{
		return aGrid;
	}

	private void setBoard() {
		for (int i = 0; i < 8; i++) {
			aPieces.put(aGrid[1][i], Optional.ofNullable(Piece.WHITE_PAWNS.get(i)));
			aPieces.put(aGrid[6][i], Optional.ofNullable(Piece.BLACK_PAWNS.get(i)));
		}
		aPieces.put(aGrid[0][0], Optional.ofNullable(Piece.WHITE_ROOKS.get(0)));
		aPieces.put(aGrid[0][7], Optional.ofNullable(Piece.WHITE_ROOKS.get(1)));
		aPieces.put(aGrid[0][1], Optional.ofNullable(Piece.WHITE_KNIGHTS.get(0)));
		aPieces.put(aGrid[0][6], Optional.ofNullable(Piece.WHITE_KNIGHTS.get(1)));
		aPieces.put(aGrid[0][2], Optional.ofNullable(Piece.WHITE_BISHOPS.get(0)));
		aPieces.put(aGrid[0][5], Optional.ofNullable(Piece.WHITE_BISHOPS.get(1)));
		aPieces.put(aGrid[0][3], Optional.ofNullable(Piece.WHITE_KING));
		aPieces.put(aGrid[0][4], Optional.ofNullable(Piece.WHITE_QUEEN));
		aPieces.put(aGrid[7][0], Optional.ofNullable(Piece.BLACK_ROOKS.get(0)));
		aPieces.put(aGrid[7][7], Optional.ofNullable(Piece.BLACK_ROOKS.get(1)));
		aPieces.put(aGrid[7][1], Optional.ofNullable(Piece.BLACK_KNIGHTS.get(0)));
		aPieces.put(aGrid[7][6], Optional.ofNullable(Piece.BLACK_KNIGHTS.get(1)));
		aPieces.put(aGrid[7][2], Optional.ofNullable(Piece.BLACK_BISHOPS.get(0)));
		aPieces.put(aGrid[7][5], Optional.ofNullable(Piece.BLACK_BISHOPS.get(1)));
		aPieces.put(aGrid[7][3], Optional.ofNullable(Piece.BLACK_KING));
		aPieces.put(aGrid[7][4], Optional.ofNullable(Piece.BLACK_QUEEN));
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
