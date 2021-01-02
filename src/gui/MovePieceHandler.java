package gui;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import pieces.Piece;

public class MovePieceHandler implements EventHandler<MouseEvent> {

	private static final ClipboardContent CLIPBOARD_CONTENT = new ClipboardContent();
	
	private Piece aPiece;
	private ImageView aImageView;
	
	MovePieceHandler(ImageView pView)
	{
		aImageView = pView;
	}
	
	void setPiece(Piece pPiece)
	{
		aPiece = pPiece;
	}
	
	@Override
	public void handle(MouseEvent pMouseEvent) {
		Dragboard db = aImageView.startDragAndDrop(TransferMode.ANY);
		CLIPBOARD_CONTENT.putString(aPiece.getIDString());
		db.setContent(CLIPBOARD_CONTENT);
		pMouseEvent.consume();
	}

}
