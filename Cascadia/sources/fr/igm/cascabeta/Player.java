package fr.igm.cascabeta;

import java.util.Objects;

import fr.igm.cascabeta.playercard.TerritoryGrid;

public class Player {
  /*name of the player*/
  private final String name;
  /*List of the territory's player*/
  /*Grid with the index of the territory case in the territoryList*/
  private final TerritoryGrid playerTerritory;
  
  public Player(String name, int numberOfTerritory) {
    Objects.requireNonNull(name);
    this.name = name;
    playerTerritory = new TerritoryGrid(numberOfTerritory);
    numberOfTerritory = 0;
  }
  public boolean addTerritory(TerritoryCase newTerritory, int x, int y) {
    /* the add function of playerTerritory field must check the arguments
     * or we check here too ?
     * */
    return playerTerritory.addCase(newTerritory, x, y);
  }
  public TerritoryGrid getTerritoryGrid() {
    return playerTerritory;
  }
  /*give the name of the player*/
  public String getName() {
    return name;
  }
  public void getTerritoryList() {
    
  }
  
  
}
