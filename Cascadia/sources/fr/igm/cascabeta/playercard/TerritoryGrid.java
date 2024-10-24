package fr.igm.cascabeta.playercard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fr.igm.cascabeta.TerritoryCase;

public class TerritoryGrid {
  private Integer[][] grid;
  private final int size;
  private int numberOfCard;
  private final List<TerritoryCase> territoryList;
  
  public TerritoryGrid(int size) {
    /*size = number max of territory x 2 */
    Objects.requireNonNull(size);
    this.size = size;
    grid = new Integer[size][size];
    for(int i = 0; i < size; i++) {
      for(int j = 0; j < size; j++) {
	grid[i][j] = -1;
      }
    }
    territoryList = new ArrayList<>();
    numberOfCard = 0;
    
  }
  
  public boolean addCase(TerritoryCase newTerritory, int x, int y) {
    Objects.requireNonNull(newTerritory);
    Objects.requireNonNull(x);
    Objects.requireNonNull(y);
    if (x<0 || x>= size || y<0 || y>= size) {
      System.out.println("Erreur : positions incorrectes");
      return false;
    }
    if(grid[x][y]!= -1) {/*there is already something*/
      System.out.println("Erreur : emplacement déjà pris");
      return false;
    }
    grid[x][y] = numberOfCard;
    territoryList.add(newTerritory);
    numberOfCard++;
    return true;
  }
  
  public boolean isEmpty(int x, int y) {
    Objects.requireNonNull(x);
    Objects.requireNonNull(y);
    if (x<0 || x>=size || y<0 || y>= size) {
      return false;
    }
    return grid[x][y] == -1;
  }
  /*return a list of index wich represent all the case on the line return null if empty*/
  public Integer[] getLine(int lineNumber) {
    var listIndex = grid[lineNumber];
    for(var index : listIndex) {
      if (index != -1) {
	return listIndex;
      }
    }
    return null;
  }
  
  public void displayGrid() {
    /*TODO create a ui that shows the grid such as : 
     * 0 1 2  ...n
     * 1   x  ...
     * 2 x x  ... x
     * . .... ...
     * n
     * for the terminal ui, x will show it's taken
     */
    Integer[] listIndex;
    for(int i = 0; i < size; i++) {
      listIndex = getLine(i);
      
      if (listIndex != null) {
	for(int j = 0; j < size; j++) {
	  if (listIndex[j] != -1) {
	    System.out.print(listIndex[j] + " ");
	  }
	  else {
	    System.out.print("   ");
	  }
	}
	System.out.println();// change line
      }
      
    }
  }
  //idk if it'll be useful but good to have anyway
  public int getsize() {
    return size;
  }
  /*give the value of grid[x][y], return -1 if invalid*/
  public TerritoryCase getCase(int x, int y) {
    Objects.requireNonNull(x);
    Objects.requireNonNull(y);
    if (x<0 || x>= size || y <0 || y>= size) {
      return null;
    }
    
    return (grid[x][y] == -1)? null: territoryList.get(grid[x][y]);
  }
}
