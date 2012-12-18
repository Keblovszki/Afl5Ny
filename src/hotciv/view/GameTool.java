package hotciv.view;

import hotciv.framework.Game;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import minidraw.framework.*;

import minidraw.framework.DrawingEditor;

public class GameTool implements Tool {

	private final EndTurnTool endTurnTool;
	private final MoveUnitTool moveUnitTool;
	private final TileFocusTool tileFocusTool;
	private final UnitSpecialActionTool unitSpecialActionTool;

	public GameTool (DrawingEditor editor, Game game) {
		endTurnTool = new EndTurnTool(editor, game);
		moveUnitTool = new MoveUnitTool(editor, game);
		tileFocusTool = new TileFocusTool(game);
		unitSpecialActionTool = new UnitSpecialActionTool(game);	
	}

	@Override
	public void mouseDrag(MouseEvent event, int x, int y) {
		endTurnTool.mouseDrag(event, x, y);
		moveUnitTool.mouseDrag(event, x, y);
		tileFocusTool.mouseDrag(event, x, y);
		unitSpecialActionTool.mouseDrag(event, x, y);
	}

	@Override
	public void mouseUp(MouseEvent event, int x, int y) {
		endTurnTool.mouseUp(event, x, y);
		moveUnitTool.mouseUp(event, x, y);
		tileFocusTool.mouseUp(event, x, y);
		unitSpecialActionTool.mouseUp(event, x, y);
	}

	@Override
	public void mouseMove(MouseEvent event, int x, int y) {
		endTurnTool.mouseMove(event, x, y);
		moveUnitTool.mouseMove(event, x, y);
		tileFocusTool.mouseMove(event, x, y);
		unitSpecialActionTool.mouseMove(event, x, y);
	}

	@Override
	public void keyDown(KeyEvent event, int key) {
		endTurnTool.keyDown(event, key);
		moveUnitTool.keyDown(event, key);
		tileFocusTool.keyDown(event, key);
		unitSpecialActionTool.keyDown(event, key);
	}

	@Override
	public void mouseDown(MouseEvent event, int x, int y) {
		endTurnTool.mouseDown(event, x, y);
		moveUnitTool.mouseDown(event, x, y);
		tileFocusTool.mouseDown(event, x, y);
		unitSpecialActionTool.mouseDown(event, x, y);		
	}
	
}
