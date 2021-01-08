module chessgame {
	requires transitive javafx.graphics;
	requires javafx.base;
	requires junit;
	requires javafx.controls;
	exports gui;
	exports pieces;
	exports board;
}