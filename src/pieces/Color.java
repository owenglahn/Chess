package pieces;

public enum Color {
	WHITE, BLACK;
	
	private final static String[] aColorsCSS = {"-fx-background-color: white;", "-fx-background-color: black;"};
	
	public String getColorCSS()
	{
		return aColorsCSS[ordinal()];
	}
}
