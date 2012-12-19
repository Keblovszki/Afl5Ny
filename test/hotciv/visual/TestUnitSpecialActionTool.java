package hotciv.visual;

import hotciv.factories.GammaFactory;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.standard.GameImpl;
import hotciv.view.UnitSpecialActionTool;
import minidraw.framework.DrawingEditor;
import minidraw.standard.MiniDrawApplication;

public class TestUnitSpecialActionTool {

	public static void main(String[] args) {
		Game game = new GameImpl(new GammaFactory());
		game.getCityAt(new Position(1, 1)).setProduction(GameConstants.ARCHER);
		game.getCityAt(new Position(1, 1)).setWorkforceFocus(GameConstants.productionFocus);
		game.getCityAt(new Position(4,1)).setWorkforceFocus(GameConstants.foodFocus);
		game.getCityAt(new Position(4,1)).setProduction(GameConstants.SETTLER);
		
		DrawingEditor editor = new MiniDrawApplication("Test unit action clicking..", new GameFactory(game));
		
		editor.open();
		editor.setTool(new UnitSpecialActionTool(game));
		
		editor.showStatus("?????");
	}
}
