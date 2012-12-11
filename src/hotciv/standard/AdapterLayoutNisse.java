package hotciv.standard;

import java.util.HashMap;

import hotciv.framework.City;
import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.framework.Tile;
import hotciv.framework.Unit;
import hotciv.strategies.WorldLayoutStrategy;

public class AdapterLayoutNisse implements WorldLayoutStrategy {
	//Desværre, nissen er et andet sted... Prøv at find mig.
	
	private ThirdPartyFractalGenerator generator;
	private HashMap<Position, Tile> tileMap;
	
	public AdapterLayoutNisse() {
		generator = new ThirdPartyFractalGenerator();
		tileMap = new HashMap<Position, Tile>();
	}
	
	@Override
	public HashMap<Position, Unit> makeUnitList() {
		return null;
	}

	@Override
	public HashMap<Position, City> makeCityList() {
		return null;
	}

	@Override
	public HashMap<Position, Tile> makeTileList() {
		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 17; j++) {
				char tileChar = generator.getLandscapeAt(i, j);
				String type = "error";
				if (tileChar == '.') {
					type = GameConstants.OCEANS;
				}
				if (tileChar == 'o') {
					type = GameConstants.PLAINS;
				}
				if (tileChar == 'M') {
					type = GameConstants.MOUNTAINS;
				}
				if (tileChar == 'f') {
					type = GameConstants.FOREST;
				}
				if (tileChar == 'h') {
					type = GameConstants.HILLS;
				}
				tileMap.put(new Position(i, j), new TileImpl(new Position(i, j), type));
			}
		}
		return tileMap;
	}
}
