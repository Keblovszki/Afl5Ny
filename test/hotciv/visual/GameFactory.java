package hotciv.visual;

import hotciv.framework.Game;
import hotciv.view.GameDrawing;
import hotciv.view.MapView;

import javax.swing.JTextField;

import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.framework.DrawingView;
import minidraw.framework.Factory;

public class GameFactory implements Factory {
	
	private Game game;
	
	public GameFactory(Game game) {
		this.game = game;
	}

	@Override
	public DrawingView createDrawingView(DrawingEditor editor) {
		DrawingView view = new MapView(editor, game);
		return view;
	}

	@Override
	public Drawing createDrawing(DrawingEditor editor) {
		return new GameDrawing(editor, game);
	}

	@Override
	public JTextField createStatusField(DrawingEditor editor) {
		JTextField f = new JTextField("????");
		f.setEditable(false);
		return f;
	}

}
