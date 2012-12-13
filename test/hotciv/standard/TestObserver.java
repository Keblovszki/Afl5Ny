package hotciv.standard;

import static org.junit.Assert.*;
import hotciv.factories.*;
import hotciv.framework.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Skeleton class for AlphaCiv test cases
 * 
 * This source code is from the book "Flexible, Reliable Software: Using
 * Patterns and Agile Development" published 2010 by CRC Press. Author: Henrik B
 * Christensen Computer Science Department Aarhus University
 * 
 * This source code is provided WITHOUT ANY WARRANTY either expressed or
 * implied. You may study, use, modify, and distribute it for non-commercial
 * purposes. For any commercial use, see http://www.baerbak.com/
 */
public class TestObserver {
	private Game game;
	private TestStubObserver testStubObserver = new TestStubObserver();

	/** Fixture for alphaciv testing. */
	@Before
	public void setUp() {
		game = new GameImpl(new AlphaFactory());
		game.addObserver(testStubObserver);
	}
	
	@Test
	public void theCountShouldBeZero() {
		//tester om vores startvariabler er 0..
		assertEquals("The count should be 0", 0, testStubObserver.getTileFocusChangeAtCount());
		assertEquals("The count should be 0", 0, testStubObserver.getTurnEndsCount());
		assertEquals("The count should be 0", 0, testStubObserver.getWorldChangeAtCount());
	}
	
	@Test
	public void observerEndOfTurnWorks() {
		game.endOfTurn();
		
		//EndOfTurnCount skal være talt op
		assertEquals("EndOfTurnCount should be 1", 1, testStubObserver.getTurnEndsCount());
		
		game.endOfTurn();
		
		//EndOfTurnCount skal være talt op
		assertEquals("EndOfTurnCount should be 2", 2, testStubObserver.getTurnEndsCount());
	}
	
	@Test
	public void observerTileFocusCountWorks() {
		game.changeWorkForceFocusInCityAt(new Position(1, 1), GameConstants.ARCHER);
		
		//TileFocusCount skal være talt op
		assertEquals("TileFocusCount should be 1", 1, testStubObserver.getTileFocusChangeAtCount());
		
		game.changeProductionInCityAt(new Position(4, 1), GameConstants.LEGION);
		
		//TileFocusCount skal være talt op
		assertEquals("TileFocusCount should be 2", 2, testStubObserver.getTileFocusChangeAtCount());
	}
	
	@Test
	public void observerWorldChangeCountWorks() {
		game.attackUnit(new Position(2, 0), new Position(3, 2));
		
		//WorldChangeCount skal være talt op
		assertEquals("WorldChangeCount should be 2", 2, testStubObserver.getWorldChangeAtCount());
		
		game.moveUnit(new Position(4, 3), new Position(5, 5));
		
		//WorldChangeCount skal være talt op 
		assertEquals("WorldChangeCount should be 4", 4, testStubObserver.getWorldChangeAtCount());
	}
	
	
	
	
	
}