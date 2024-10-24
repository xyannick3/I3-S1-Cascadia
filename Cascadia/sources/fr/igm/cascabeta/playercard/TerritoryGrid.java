package fr.igm.cascabeta.playercard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import fr.igm.cascabeta.TerritoryCase;
import fr.igm.cascabeta.Coordinates;

public class TerritoryGrid {
  /* size = number max of territory for one player */
  private final int maxNumberOfCard;
  private final HashMap<Coordinates, TerritoryCase> grid;

  private int gridXMin;
  private int gridXMax;
  private int gridYMin;
  private int gridYMax;

  public TerritoryGrid(int size) {
    grid = new HashMap<Coordinates, TerritoryCase>();
    if (size < 0) {
      throw new IllegalArgumentException("Invalid because : weight < 0 or we must have weight >= 0");
    }
    this.maxNumberOfCard = size;
    // TODO initilize gridYMax, gridYMin , gridXMax, gridXMin following the start
    // base
    gridXMin = size;
    gridXMax = size;
    gridYMin = size;
    gridYMax = size;
  }

  private boolean hasNeighbour(Coordinates position) {
    var above = new Coordinates(position.x(), position.y() + 1);
    if (grid.get(above) != null) {
      return true;
    }
    var below = new Coordinates(position.x(), position.y() - 1);
    if (grid.get(below) != null) {
      return true;
    }
    var next = new Coordinates(position.x() + 1, position.y());
    if (grid.get(next) != null) {
      return true;
    }
    var before = new Coordinates(position.x() - 1, position.y());
    if (grid.get(before) != null) {
      return true;
    }
    return false;
  }

  private void updateMinMaxSize(int x, int y) {
    if (y < gridYMin) {
      gridYMin = y;
    }
    if (y > gridYMax) {
      gridYMax = y;
    }

    if (x < gridXMin) {
      gridXMin = x;
      return;
    }
    if (x > gridXMax) {
      gridXMax = x;
    }
  }

  private boolean allowAddCase(TerritoryCase newTerritory, Coordinates position) {
    if (position.x() < 0 || position.y() < 0) {
      /*
       * don't allow negative index and start at the max number of territory per
       * player for both x and y otherwise you will have problem with getLineKey
       */
      throw new IllegalArgumentException("Invalid because : x or y < 0");
    }
    if (grid.size() > maxNumberOfCard) {
      return false;/* the number of card exceeds the number of card allow */
    }
    if (getCase(position) != null) {
      return false;/* there is already something at position */
    }
    if (!hasNeighbour(position)) {
      return false;/* wrong coordinates */
    }
    return true;
  }

  private boolean addBaseStart(TerritoryCase newTerritory, Coordinates position) {
    if (position.x() != maxNumberOfCard || position.y() != maxNumberOfCard) {
      throw new IllegalArgumentException(
	  "Invalid because : x and y must be equals to (maxNumberOfCard for a player) here -> " + maxNumberOfCard
	      + " for the initialization");
    }
    grid.put(position, newTerritory);
    return true;/* add the first card */
  }

  public boolean addCase(TerritoryCase newTerritory, Coordinates position) {
    Objects.requireNonNull(newTerritory);
    Objects.requireNonNull(position);
    if (grid.isEmpty()) {
      return addBaseStart(newTerritory, position);
    }
    if (!allowAddCase(newTerritory, position)) {
      return false;
    }
    updateMinMaxSize(position.x(), position.y());
    grid.put(position, newTerritory);
    return true;
  }

  /*
   * return a list of index witch represent all the case on the line return null
   * if empty
   */
  public List<Coordinates> getLineKey(int lineNumber) {
    var list = Arrays.asList(new Coordinates[gridXMax + 1]);
    Set<Coordinates> listCoordinates = new HashSet<>(grid.keySet());
    listCoordinates.removeIf(position -> position.y() != lineNumber);
    if (listCoordinates.isEmpty()) {
      return null;
    }
    for (var key : listCoordinates) {
      list.set(key.x(), key);
    }
    return list;
  }

  public void displayGrid() {
    /*
     * TODO create a ui that shows the grid such as : 0 1 2 ...n 1 x ... 2 x x ... x
     * . .... ... n for the terminal ui, x will show it's taken
     */
    List<Coordinates> listkey;
    var sizeX = gridXMax + 1;
    var sizeY = gridYMax + 1;
    var name = ""; // don't use directly grid.get(listkey.get(j)).getTerritory().name() in println
		   // in order to display the first character

    for (int i = 0; i < sizeY; i++) {
      listkey = getLineKey(i);
      if (listkey != null) {
	for (int j = gridXMin; j < sizeX; j++) {
	  if (listkey.get(j) != null) {
	    name = grid.get(listkey.get(j)).getTerritory().name();
	    System.out.print(name.charAt(0) + " ");
	  } else {
	    System.out.print("  ");
	  }
	}
	System.out.println();// change line
      }
    }
  }

  // idk if it'll be useful but good to have anyway
  public int getsize() {
    return grid.size();
  }

  /* give the value of grid[x][y], return -1 if invalid */
  public TerritoryCase getCase(Coordinates position) {
    Objects.requireNonNull(position);
    return grid.get(position);
  }
}
