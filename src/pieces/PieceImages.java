package pieces;

import javafx.scene.image.Image;
import java.util.*;

public class PieceImages {

	private final static String FILE_SUFFIX = ".png";
	
	private static Map<String, Image> aImages = new HashMap<String, Image>();
	
	private PieceImages() {}
	
	public static Image getPieceImage(Piece pPiece)
	{
		return getPieceImage(getFileLocation(pPiece));
	}
	
	public static Image getPieceImage(String pFileLocation)
	{
		Image toReturn = aImages.get(pFileLocation);
		if (toReturn == null)
		{
			toReturn = new Image(PieceImages.class.getClassLoader().getResourceAsStream(pFileLocation));
			aImages.put(pFileLocation, toReturn);
		}
		return toReturn;
	}
	
	public static String getFileLocation(Piece pPiece)
	{
		return pPiece.getColor().toString() + "_" + pPiece.getClass().toString() + FILE_SUFFIX;
	}
}
