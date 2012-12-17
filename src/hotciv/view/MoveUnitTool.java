package hotciv.view;

import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.framework.Unit;

import java.awt.event.MouseEvent;

import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.standard.NullTool;

public class MoveUnitTool extends NullTool {
	
	private final DrawingEditor editor;
	private final Game game;
	private Position from;
	private Unit selectedUnit;
	private Figure figureToMove;
	private int lastX;
	private int lastY;
	
	public MoveUnitTool(DrawingEditor editor, Game game) {
		this.editor = editor;
		this.game = game;
		
		lastX = 0;
		lastY = 0;
	}
	
	@Override
	public void mouseDown(MouseEvent event, int x, int y) {
		from = GfxConstants.getPositionFromXY(x, y);
		if (!from.inWorld()) {
			return;
		}
		selectedUnit = game.getUnitAt(from);
		if (selectedUnit == null) {
			return;
		}
		figureToMove.moveBy(x - lastX, y - lastY);
		lastX = x;
		lastY = y;
	}
	
	@Override
	public void mouseUp(MouseEvent event, int x, int y) {
		figureToMove = null;
		if (selectedUnit != null) {
			Position to = GfxConstants.getPositionFromXY(x, y);
			if (to.inWorld()) {
				game.moveUnit(from, to);
			}
			else {
				//så bliver ens unit rykket tilbage, hvis ikke man må rykke
				game.moveUnit(from, from);
			}
		}
		selectedUnit = null;
	}
	
	@Override
	public void mouseDrag(MouseEvent event, int x, int y) {
		if (figureToMove == null) {
			return;
		}
		
		figureToMove.moveBy(x - lastX, y - lastY);
		lastX = x;
		lastY = y;
	}
}
