package hotciv.visual;

import hotciv.factories.AlphaFactory;
import hotciv.framework.Game;
import hotciv.standard.GameImpl;
import hotciv.view.EndTurnTool;
import minidraw.framework.DrawingEditor;
import minidraw.standard.MiniDrawApplication;

public class TestEndOfTurnTool {

	public static void main(String[] args) {
		Game game = new GameImpl(new AlphaFactory());
		
		DrawingEditor editor = new MiniDrawApplication("Test end of Turn by clicking..", new GameFactory(game));
		
		editor.open();
		editor.setTool(new EndTurnTool(editor, game));
		
		editor.showStatus("Hvorn�r tror i den hemmelige drage kommer og overtager verden?");
	}
}
