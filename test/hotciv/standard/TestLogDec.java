package hotciv.standard;

import static org.junit.Assert.*;
import hotciv.factories.AlphaFactory;
import hotciv.framework.Game;
import hotciv.framework.Position;

import org.junit.Before;
import org.junit.Test;

public class TestLogDec {
	private Game game;
	
	@Before
	public void SetUp() {
		game = new GameImpl( new AlphaFactory() );
	}
	
	@Test
	public void testSYSO() {
		SpyPrint sp = new SpyPrint();
		LogDec ld = new LogDec(game, sp);
		ld.moveUnit(new Position(2, 0), new Position(2, 1));
		ld.moveUnit(new Position(2, 1), new Position(2, 1));
		ld.moveUnit(new Position(2, 1), new Position(2, 1));
		ld.moveUnit(new Position(2, 1), new Position(2, 1));
		ld.moveUnit(new Position(2, 1), new Position(2, 1));
		assertEquals("bla", 5, sp.countPrints());
	}
}