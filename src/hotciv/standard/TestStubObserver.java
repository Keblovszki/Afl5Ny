package hotciv.standard;

import hotciv.framework.GameObserver;
import hotciv.framework.Player;
import hotciv.framework.Position;

public class TestStubObserver implements GameObserver {

	private int worldChangeAtCount;
	private int turnEndsCount;
	private int tileFocusChangeAtCount;
	
	public TestStubObserver() {
		worldChangeAtCount = 0;
		turnEndsCount = 0;
		tileFocusChangeAtCount = 0;
	}
	@Override
	public void worldChangedAt(Position pos) {
		worldChangeAtCount++;
	}

	@Override
	public void turnEnds(Player nextPlayer, int age) {
		turnEndsCount++;
	}

	@Override
	public void tileFocusChangedAt(Position position) {
		tileFocusChangeAtCount++;
	}
	
	public int getWorldChangeAtCount() {
		return worldChangeAtCount;
	}
	
	public int getTurnEndsCount() {
		return turnEndsCount;
	}
	
	public int getTileFocusChangeAtCount() {
		return tileFocusChangeAtCount;
	}
}
