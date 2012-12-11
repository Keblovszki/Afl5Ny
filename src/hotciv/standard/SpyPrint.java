package hotciv.standard;

import hotciv.framework.*;

public class SpyPrint implements Print{
	private int i;
	
	public SpyPrint() {
		i = 0;
	}

	@Override
	public void printString(Position from, Position to) {
		i++;
		System.out.println(i);
	}

	@Override
	public int countPrints() {
		return i;
	}

}
