package hotciv.visual;

import hotciv.factories.AlphaFactory;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.standard.GameImpl;
import hotciv.view.EndTurnTool;
import minidraw.framework.DrawingEditor;
import minidraw.standard.MiniDrawApplication;

public class TestEndOfTurnTool {

	public static void main(String[] args) {
		Game game = new GameImpl(new AlphaFactory());
		game.getCityAt(new Position(1, 1)).setProduction(GameConstants.ARCHER);
		game.getCityAt(new Position(1, 1)).setWorkforceFocus(GameConstants.productionFocus);
		game.getCityAt(new Position(4,1)).setWorkforceFocus(GameConstants.foodFocus);
		game.getCityAt(new Position(4,1)).setProduction(GameConstants.SETTLER);
		
		DrawingEditor editor = new MiniDrawApplication("Test end of Turn by clicking..", new GameFactory(game));
		
		editor.open();
		editor.setTool(new EndTurnTool(editor, game));
		
		editor.showStatus("Hvorn�r tror i den hemmelige drage kommer og overtager verden?");
	}
}
