import javax.swing.JTextField;

import hotciv.factories.AlphaFactory;
import hotciv.framework.Game;
import hotciv.standard.GameImpl;
import hotciv.view.MapView;
import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.framework.DrawingView;
import minidraw.framework.Factory;
import minidraw.standard.MiniDrawApplication;
import minidraw.standard.NullTool;
import minidraw.standard.StandardDrawing;


public class Spil {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameImpl game = new GameImpl(new AlphaFactory());

		DrawingEditor editor = new MiniDrawApplication("Paint the HotCiv world map...", new HotCivFactory(game));
		editor.open();

		editor.setTool(new NullTool());	
	}

	
	class HotCivFactory implements Factory {
		private Game game;

		public HotCivFactory(Game g) {
			game = g;
		}

		public DrawingView createDrawingView(DrawingEditor editor) {
			DrawingView view = new MapView(editor, game);
			return view;
		}

		public Drawing createDrawing(DrawingEditor editor) {
			return new StandardDrawing();
		}

		public JTextField createStatusField(DrawingEditor editor) {
			return null;
		}
	}
}
