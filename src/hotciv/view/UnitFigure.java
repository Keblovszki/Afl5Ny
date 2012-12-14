package hotciv.view;

import hotciv.framework.Unit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import minidraw.standard.ImageFigure;

public class UnitFigure extends ImageFigure {
	protected Unit associatedUnit;

	public UnitFigure(String name, Point origin, Unit unit) {
		super(name, origin);
		associatedUnit = unit;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(fImage, fDisplayBox.x, fDisplayBox.y - GfxConstants.UNIT_OFFSET_Y, fDisplayBox.width, fDisplayBox.height, null);
		
		Color color = GfxConstants.getColorForPlayer(associatedUnit.getOwner());
		g.setColor(color);
		g.fillOval(fDisplayBox.x, fDisplayBox.y, 8, 6);
		g.setColor(Color.black);
		g.drawOval(fDisplayBox.x, fDisplayBox.y, 8, 6);
		g.setColor(associatedUnit.getMoveCount() > 0 ? Color.green : Color.red );
		g.fillOval(fDisplayBox.x, fDisplayBox.y + 7, 8, 6);
		g.setColor(Color.black);
		g.drawOval(fDisplayBox.x, fDisplayBox.y + 7, 8, 6);
	}

}
