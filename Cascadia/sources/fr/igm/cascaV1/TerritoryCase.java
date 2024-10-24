package fr.igm.cascaV1;

import java.util.List;
import java.util.Objects;

import fr.igm.cascabeta.enums.TerritoryType;
import fr.igm.cascabeta.enums.WildlifeToken;

public class TerritoryCase {
  private TerritoryType[] sides;
  private WildlifeToken wildlife;
  private List<WildlifeToken> allowedWildlife;
  //Constructor
  public TerritoryCase(TerritoryType territory1,TerritoryType territory2, List<WildlifeToken> allowedWildlife) {
    Objects.requireNonNull(territory1);
    Objects.requireNonNull(territory2);
    Objects.requireNonNull(allowedWildlife);
    this.sides = new TerritoryType[] {territory1,territory1,territory2,territory2};
    this.allowedWildlife = allowedWildlife;
    this.wildlife = null;
  }
  //rotate the case clockwise by 90 degrees
  public void rotateClockwise() {
    var buffer = sides[3];
    sides[3] = sides[2];
    sides[1] = sides[0];
    sides[0] = buffer;
  }
  //same as above but counterclockwise
  public void rotateCounterClockwise() {
    var buffer = sides[0];
    sides[0] = sides[1];
    sides[1] = sides[2];
    sides[2] = sides[3];
    sides[3] = buffer;
  }
  //adds a wildlife to the case
  public boolean addWildlife(WildlifeToken token) {
    Objects.requireNonNull(token);
    if (allowedWildlife.contains(token)) {
      this.wildlife = token;
      return true;
    }
    return false;
  }
  //returns the territory type of the designated side
  public TerritoryType getTerritoryOnSide(int index) {
    Objects.requireNonNull(index);
    return sides[index %4];
  }
  //returns the wildlife assigned to the case
  public WildlifeToken getWildlife() {
    return this.wildlife;
  }
  //returns the list of the allowed wildlife on the case.
  public List<WildlifeToken> getAllowedAnimals(){
    return allowedWildlife;
  }
  //override of the to string function
  public String toString() {
    var result = new StringBuilder();
    result.append("North : ");
    result.append(sides[0]);
    result.append(", East: ");
    result.append(sides[1]);
    result.append(", South :");
    result.append(sides[2]);
    result.append(",West: ");
    result.append(sides[3]);
    result.append(". Wildlife");
    result.append((wildlife != null ? wildlife : "None"));
    result.append("Allowed animals");
    result.append(allowedWildlife);
    return result.toString();
  }
}
