package gui;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import pieces.*;

public class PieceView extends ImageView {
	
	private Piece aPiece;
	
	public PieceView(Piece pPiece)
	{
		super(PieceImages.getPieceImage(pPiece));
		aPiece = pPiece;
	}
	
	public EventHandler<MouseEvent> createDragDetectedHandler()
	{
		return new MovePieceHandler(this);
	}
	
}
