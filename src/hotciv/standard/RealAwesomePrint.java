package hotciv.standard;

import hotciv.framework.Position;
import hotciv.framework.Print;

public class RealAwesomePrint implements Print {

	@Override
	public void printString(Position from, Position to) {
		System.out.println("fra " + from + " til " + to);
	}

	@Override
	public int countPrints() {
		//do ntohginknlekdn.. (Du fandt mig - jeg er nissen)
//		
//        {_}
//        / \
//       /   \
//      /_____\
//    {`_______`}
//     // . . \\
//    (/(__7__)\)
//    |'-' = `-'|
//    |         |
//    /\       /\
//   /  '.   .'  \
//  /_/   `"`   \_\
// {__}###[_]###{__}
// (_/\_________/\_)
//     |___|___|
//      |--|--|
//     (__)`(__)
		return 0;
	}

}
