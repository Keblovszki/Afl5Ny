package hotciv.view;

import hotciv.framework.Game;

import java.awt.event.MouseEvent;

import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.standard.NullTool;

public class EndTurnTool extends NullTool {
	
	private final DrawingEditor editor;
	private final Game game;
	
	private boolean mouseOnShield = false;
	
	public EndTurnTool (DrawingEditor editor, Game game) {
		this.game = game;
		this.editor = editor;
	}
	
	@Override
	public void mouseDown(MouseEvent event, int x, int y) {
		mouseOnShield = isShieldFigureAt(x, y);
	}
	
	public void mouseUp(MouseEvent event, int x, int y) {
		if (mouseOnShield && isShieldFigureAt(x, y)) {
			game.endOfTurn();
		}
	}

	private boolean isShieldFigureAt(int x, int y) {
		Drawing d = editor.drawing();
		Figure testingFigure = d.findFigure(x, y);
		Figure shieldFigure = d.findFigure(GfxConstants.TURN_SHIELD_X, GfxConstants.TURN_SHIELD_Y);
		return (testingFigure != null && testingFigure == shieldFigure);
	}
}
