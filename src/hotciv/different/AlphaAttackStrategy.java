package hotciv.different;

import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.framework.Print;
import hotciv.strategies.AttackingStrategy;

public class AlphaAttackStrategy implements AttackingStrategy{
	private Game game;
	private Print p;
	
	public AlphaAttackStrategy(Game game, Print print) {
		this.game = game;
		p = print;
	}
	
	@Override
	public boolean resultOfTheAttack(Position attackersPosition, Position defendersPosition) {
		if(game.getMapUnit().get(attackersPosition).isNotArcherFortify() == false) {
			return false;
		}
		else{
			game.getMapUnit().remove(defendersPosition);
			game.getMapUnit().put(defendersPosition, game.getMapUnit().get(attackersPosition) );
			game.getMapUnit().remove(attackersPosition);
			if(game.getMapCity().get(defendersPosition) != null ) {
				if(game.getMapCity().get(defendersPosition).getOwner() == game.getMapUnit().get(defendersPosition).getOwner()) {
					return true;
				}
				else {
					game.getMapCity().get(defendersPosition).setOwner(game.getMapUnit().get(defendersPosition).getOwner());
					return true;
				}
			}
		}
		return true;
	}
	
}
