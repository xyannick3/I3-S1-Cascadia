package fr.igm.cascabeta;

import java.util.Objects;

public class TerritoryGrid {
  private TerritoryCase[][] grid;
  private int size;
  public TerritoryGrid(int size) {
    Objects.requireNonNull(size);
    this.size = size;
    this.grid = new TerritoryCase[size][size];
  }
  public boolean addCase(TerritoryCase c, int x, int y) {
    Objects.requireNonNull(c);
    Objects.requireNonNull(x);
    Objects.requireNonNull(y);
    if (x<0 || x>= size || y<0 || y>= size) {
      System.out.println("Erreur : positions incorrectes");
      return false;
    }
    
    if(grid[x][y]!= null) {
      System.out.println("Erreur : emplacement déjà pris");
      return false;
    }
    
    grid[x][y] = c;
    return true;
  }
  
  public boolean isEmpty(int x, int y) {
    Objects.requireNonNull(x);
    Objects.requireNonNull(y);
    if (x<0 || x>=size || y<0 || y>= size) {
      return false;
    }
    return grid[x][y] == null;
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
  }
  //idk if it'll be useful but good to have anyway
  public int getsize() {
    return size;
  }
  public TerritoryCase getCase(int x, int y) {
    Objects.requireNonNull(x);
    Objects.requireNonNull(y);
    if (x<0 || x>= size || y <0 || y>= size) {
      return null;
    }
    return grid[x][y];
  }
}
