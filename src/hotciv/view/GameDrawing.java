package hotciv.view;

import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.GameObserver;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Unit;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.standard.ImageFigure;
import minidraw.standard.StandardDrawing;

public class GameDrawing extends StandardDrawing implements Drawing, GameObserver {

	private ImageFigure shieldIconShift;
	private TextFigure textFigureAge;
	private TextFigure moveCountText;
	private UnitFigure cityProductionIcon;
	private ImageFigure workForceFocusIcon;
	protected Game game;
	protected HashMap<City, CityFigure> cityMap = null;
	protected HashMap<Unit, UnitFigure> unitMap = null;


	public GameDrawing(DrawingEditor editor, Game game) {
		super();
		this.game = game;
		game.addObserver(this);

		writeAge(game.getAge());
		defineCityMap();
		defineUnitMap();
		defineIcons();
	}

	private void defineIcons() {
		shieldIconShift = new ImageFigure("redshield",
				new Point(GfxConstants.TURN_SHIELD_X, GfxConstants.TURN_SHIELD_Y));
		super.add(shieldIconShift);
	}

	private void defineUnitMap() {
		clearSelection();

		unitMap = new HashMap<Unit, UnitFigure>();
		Position p;
		for (int row = 0; row < GameConstants.WORLDSIZE; row++) {
			for (int column = 0; column < GameConstants.WORLDSIZE; column++) {
				p = new Position(row, column);
				Unit unit = game.getUnitAt(p);
				if (unit != null) {
					String type = unit.getTypeString();
					Point point = new Point(GfxConstants.getXFromColumn(p.getColumn()), GfxConstants.getYFromRow(p
							.getRow()));
					UnitFigure unitFigure = new UnitFigure(type, point, unit);
					unitFigure.addFigureChangeListener(this);
					unitMap.put(unit, unitFigure);
					super.add(unitFigure);
				}
			}
		}
	}

	private void defineCityMap() {
		clearSelection();

		cityMap = new HashMap<City, CityFigure>();
		Position p;
		for (int row = 0; row < GameConstants.WORLDSIZE; row++) {
			for (int column = 0; column < GameConstants.WORLDSIZE; column++) {
				p = new Position(row, column);
				City city = game.getCityAt(p);
				if (city != null) {
					Point point = new Point(GfxConstants.getXFromColumn(p.getColumn()), GfxConstants.getYFromRow(p
							.getRow()));
					CityFigure cityFigure = new CityFigure(city, point);
					cityFigure.addFigureChangeListener(this);
					cityMap.put(city, cityFigure);
					super.add(cityFigure);
				}
			}
		}

	}

	@Override
	public void worldChangedAt(Position pos) {
		clearSelection();

		for (Figure f : unitMap.values()) {
			super.remove(f);
		}
		defineCityMap();
		defineUnitMap();
	}

	@Override
	public void turnEnds(Player nextPlayer, int age) {
		String playername = "red";
		if (nextPlayer == Player.BLUE) {
			playername = "blue";
		}
		shieldIconShift.set(playername + "shield", new Point(GfxConstants.TURN_SHIELD_X, GfxConstants.TURN_SHIELD_Y));
		writeAge(game.getAge());
	}

	@Override
	public void tileFocusChangedAt(Position position) {
		inspectCity(position);
		inspectUnit(position);
	}

	private void inspectUnit(Position position) {
		if (moveCountText != null) {
			super.remove(moveCountText);
			moveCountText = null;
		}
		
		final Unit u = game.getUnitAt(position);
		if (u == null) {
			return;
		}
		
		String movesLeft = "" + u.getMoveCount();
		moveCountText = new TextFigure(movesLeft, new Point(GfxConstants.UNIT_COUNT_X, GfxConstants.UNIT_COUNT_Y));
		super.add(moveCountText);
	}

	private void inspectCity(Position position) {
		if (cityProductionIcon != null) {
			super.remove(cityProductionIcon);
			cityProductionIcon = null;
		}

		if (workForceFocusIcon != null) {
			super.remove(workForceFocusIcon);
			workForceFocusIcon = null;
		}

		final City c = game.getCityAt(position);
		if (c == null) {
			return;
		}

		String production = c.getProduction();
		cityProductionIcon = new UnitFigure(production, new Point(GfxConstants.CITY_PRODUCTION_X,
				GfxConstants.CITY_PRODUCTION_Y), new Unit() {

			@Override
			public String getTypeString() {
				//ligegyldigt, bare vi har farven på owneren..
				return GameConstants.ARCHER;
			}

			@Override
			public Player getOwner() {
				return c.getOwner();
			}

			@Override
			public int getMoveCount() {
				return 0;
			}

			@Override
			public int getDefensiveStrength() {
				return 0;
			}

			@Override
			public int getAttackingStrength() {
				return 0;
			}

			@Override
			public void increaseBonusDefenseStrength(int bonusStrength) {
				
			}

			@Override
			public void setIsNotFortify(boolean fortify) {
				
			}

			@Override
			public boolean isNotArcherFortify() {
				return false;
			}

			@Override
			public ArrayList<Unit> getUnitsAround(Position p) {
				return null;
			}
		});
		
		super.add(cityProductionIcon);
		String focus = c.getWorkforceFocus();
		workForceFocusIcon = new ImageFigure(focus, new Point(GfxConstants.WORKFORCEFOCUS_X, GfxConstants.WORKFORCEFOCUS_Y));
		super.add(workForceFocusIcon);
	}

	private void writeAge(int age) {
		String ageString;
		if (age < 0) {
			ageString = Math.abs(age) + " BC";
		} else {
			ageString = age + " AC";
		}
		if (textFigureAge == null) {
			textFigureAge = new TextFigure(ageString, new Point(GfxConstants.AGE_TEXT_X, GfxConstants.AGE_TEXT_Y));
			super.add(textFigureAge);
		}
		textFigureAge.setText(ageString);
	}
	

	@Override
	public Figure add(Figure figure) {
		throw new RuntimeException("fuck yeah..");
	}

}
