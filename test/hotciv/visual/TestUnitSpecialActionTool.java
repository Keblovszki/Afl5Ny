package hotciv.visual;

import hotciv.factories.GammaFactory;
import hotciv.framework.Game;
import hotciv.standard.GameImpl;
import hotciv.view.UnitSpecialActionTool;
import minidraw.framework.DrawingEditor;
import minidraw.standard.MiniDrawApplication;

public class TestUnitSpecialActionTool {

	public static void main(String[] args) {
		Game game = new GameImpl(new GammaFactory());
		
		DrawingEditor editor = new MiniDrawApplication("Test unit action clicking..", new GameFactory(game));
		
		editor.open();
		editor.setTool(new UnitSpecialActionTool(game));
		
		editor.showStatus("?????");
	}
}
