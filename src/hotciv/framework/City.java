package hotciv.framework;

/** Represents a city in the game.

Responsibilities:
1) Knows its owner.
2) Knows its population size.

   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Computer Science Department
     Aarhus University
   
   This source code is provided WITHOUT ANY WARRANTY either 
   expressed or implied. You may study, use, modify, and 
   distribute it for non-commercial purposes. For any 
   commercial use, see http://www.baerbak.com/
*/
public interface City {
  /** return the owner of this city.
   * @return the player that controls this city.
   */
  public Player getOwner();
  
  /** return the size of the population.
   * @return population size.
   */
  public int getSize();

  /** return the type of unit this city is currently producing.
   * @return a string type defining the unit under production,
   * see GameConstants for valid values.
   */
  public String getProduction();

  /** return the work force's focus in this city.
   * @return a string type defining the focus, see GameConstants
   * for valid return values.
   */
  public String getWorkforceFocus();
  
  /** Do the production sum of each round 
   * accumulate the production sum.
   */
  public void doProductionSum();
  
  /* @return the production in the city */
  public int getProductionSum();
  
  /* set the owner of the city */
  public void setOwner(Player p);
  
  public void setProductionChange(int change);
  
  public void setProduction(String unitType);
  
  public void setWorkforceFocus(String balance);
  
  public void setProductionSum(int change);
  
	public int getFoodProduction();
	
	public void setFoodProduction(int foodProduction);
	
	public void setSize(int reSize);
}
