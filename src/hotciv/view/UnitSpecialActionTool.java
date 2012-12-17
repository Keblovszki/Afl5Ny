package hotciv.view;

import hotciv.framework.Game;
import hotciv.framework.Position;

import java.awt.event.MouseEvent;

import minidraw.standard.NullTool;

public class UnitSpecialActionTool extends NullTool {
	
	private Position downPos; 
	private final Game game;
	
	public UnitSpecialActionTool (Game game) {
		this.game = game;
	}
	
	@Override
	public void mouseDown(MouseEvent event, int x, int y) {
		downPos = GfxConstants.getPositionFromXY(x, y);
	}
	
	@Override
	public void mouseUp(MouseEvent event, int x, int y) {
		Position upPos = GfxConstants.getPositionFromXY(x, y);
		if(downPos.inWorld() && downPos.equals(upPos)) {
			if(game.getUnitAt(downPos) != null) {
				game.performUnitActionAt(downPos);
			}
		}
		downPos = null;
	}
	
	
}
