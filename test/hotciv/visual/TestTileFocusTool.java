package hotciv.visual;

import hotciv.factories.GammaFactory;
import hotciv.framework.Game;
import hotciv.standard.GameImpl;
import hotciv.view.TileFocusTool;
import minidraw.framework.DrawingEditor;
import minidraw.standard.MiniDrawApplication;

public class TestTileFocusTool {

	public static void main(String[] args) {
		Game game = new GameImpl(new GammaFactory());
		
		DrawingEditor editor = new MiniDrawApplication("Test unit action clicking..", new GameFactory(game));
		
		editor.open();
		editor.setTool(new TileFocusTool(game));
		
		editor.showStatus("?????");
	}
}
