package hotciv.visual;

import hotciv.factories.GammaFactory;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.standard.GameImpl;

import java.awt.event.MouseEvent;

import minidraw.framework.DrawingEditor;
import minidraw.standard.MiniDrawApplication;
import minidraw.standard.NullTool;

public class TestGameTool {
	
	public static void main(String[] args) {
		Game game = new GameImpl(new GammaFactory());
		game.getCityAt(new Position(1, 1)).setProduction(GameConstants.ARCHER);
		game.getCityAt(new Position(1, 1)).setWorkforceFocus(GameConstants.productionFocus);
		game.getCityAt(new Position(4,1)).setWorkforceFocus(GameConstants.foodFocus);
		game.getCityAt(new Position(4,1)).setProduction(GameConstants.SETTLER);
		
		DrawingEditor editor = new MiniDrawApplication("Hannibal er sej", new GameFactory(game));
		
		editor.open();
		editor.setTool(new UpdateTool(editor, game));
		
		editor.showStatus("Test");
	}
}

class UpdateTool extends NullTool {
	private Game game;
	private DrawingEditor editor;
	private int count = 0;
	
	public UpdateTool(DrawingEditor editor, Game game) {
		this.editor = editor;
		this.game = game;
	}
	
	public void mouseDown(MouseEvent event, int x, int y) {
		switch(count) {
			case 0: {
				editor.showStatus("State Change, moving Archer to (1, 1)");
				game.moveUnit(new Position(2, 0), new Position(1, 1));
				break;
			}
			case 1: {
				editor.showStatus("Change to blue player");
				game.endOfTurn();
				break;
			}
			case 2: {
				try {
					editor.showStatus("Settler change to City");
					game.performUnitActionAt(new Position(4, 3));
					break;
				}
				catch (Exception nullException){
					System.out.println("Fandt du nissen sidst? Hvis ja, så GOD JUL :) Hvis ikke, så god jul alligevel, men ikke med store bogstaver...");
				}
			}
			default: {
				editor.showStatus("no more changes");
			}
		}
		count ++;
	}
}