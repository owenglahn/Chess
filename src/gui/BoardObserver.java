package gui;

import board.Board;
import pieces.Color;

public class BoardObserver {

	private Board aBoard;
	
	public BoardObserver(Board pBoard)
	{
		aBoard = pBoard;
	}
	
	/* Callback methods. */
	
	
	public void pieceMoved()
	{
		/*
		 * Update board display.
		 */
	}
	
	public void winnerClaimed(Color pColor)
	{
		/*
		 * Display some winning message.
		 */
	}
}
