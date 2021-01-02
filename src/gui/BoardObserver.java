package gui;

import board.Board;
import javafx.scene.image.ImageView;
import pieces.Color;

public class BoardObserver {

	private Board aBoard;
	private MovePieceHandler aHandler = new MovePieceHandler(new ImageView());

	public BoardObserver(Board pBoard) {
		aBoard = pBoard;
	}

	/* Callback methods. */

	public void pieceMoved() {
		/*
		 * Update board display.
		 */
	}

	public void winnerClaimed(Color pColor) {
		/*
		 * Display some winning message.
		 */
	}
}
