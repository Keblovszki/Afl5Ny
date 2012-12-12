package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.GameObserver;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Print;
import hotciv.framework.Tile;
import hotciv.framework.Unit;

import java.util.Collection;
import java.util.HashMap;

public class LogDec implements Game {
	private Game game;
	private Print print;
	
	public LogDec(Game game, Print p) {
		this.game = game;
		print = p;
	}
	
	@Override
	public Tile getTileAt(Position p) {
		return this.game.getTileAt(p);
	}

	@Override
	public Unit getUnitAt(Position p) {
		return this.game.getUnitAt(p);
	}

	@Override
	public City getCityAt(Position p) {
		return this.game.getCityAt(p);
	}

	@Override
	public Player getPlayerInTurn() {
		return this.game.getPlayerInTurn();
	}

	@Override
	public Player getWinner() {
		return this.game.getWinner();
	}

	@Override
	public int getAge() {
		return this.game.getAge();
	}

	@Override
	public boolean moveUnit(Position from, Position to) {
		print.printString(from, to);
		return this.game.moveUnit(from, to);
	}

	@Override
	public void endOfTurn() {
		this.game.endOfTurn();
	}

	@Override
	public void changeWorkForceFocusInCityAt(Position p, String balance) {
		this.game.changeWorkForceFocusInCityAt(p, balance);
	}

	@Override
	public void changeProductionInCityAt(Position p, String unitType) {
		this.game.changeProductionInCityAt(p, unitType);
	}

	@Override
	public void performUnitActionAt(Position p) {
		this.game.performUnitActionAt(p);
	}

	@Override
	public void createProductionInCityAt(Position p) {
		this.game.createProductionInCityAt(p);
	}

	@Override
	public boolean attackUnit(Position from, Position to) {
		return this.game.attackUnit(from, to);
	}

	@Override
	public void resetAttacks() {
		this.game.resetAttacks();
	}

	@Override
	public HashMap<Position, City> getMapCity() {
		return this.game.getMapCity();
	}

	@Override
	public void setMapCity(HashMap<Position, City> mapCity) {
		this.game.setMapCity(mapCity);
	}

	@Override
	public HashMap<Position, Unit> getMapUnit() {
		return this.game.getMapUnit();
	}

	@Override
	public void setMapUnit(HashMap<Position, Unit> mapUnit) {
		this.game.setMapUnit(mapUnit);
	}

	@Override
	public HashMap<Position, Tile> getMapTile() {
		return this.game.getMapTile();
	}

	@Override
	public void setMapTile(HashMap<Position, Tile> mapTile) {
		this.game.setMapTile(mapTile);
	}

	@Override
	public void addCity(Position p, Player owner) {
		this.game.addCity(p, owner);
	}

	@Override
	public Collection<City> getAllCities() {
		return this.game.getAllCities();
	}

	@Override
	public int countWins(Player p) {
		return this.game.countWins(p);
	}

	@Override
	public void removeUnit(Position p) {
		this.game.removeUnit(p);
	}

	@Override
	public int getRounds() {
		return this.game.getRounds();
	}

	@Override
	public void addObserver(GameObserver observer) {
		// Do nothing
		
	}
}
