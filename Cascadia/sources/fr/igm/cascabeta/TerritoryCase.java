package fr.igm.cascabeta;
import java.util.List;
import java.util.Objects;

import fr.igm.cascabeta.enums.TerritoryType;
import fr.igm.cascabeta.enums.WildlifeToken;

public class TerritoryCase {
  private TerritoryType territory;
  private WildlifeToken wildlife;
  private List<WildlifeToken> allowedWildlife;
  //Constructor assigns to the case a territory and a list of allowed wildlife on the token.
  public TerritoryCase(TerritoryType territory, List<WildlifeToken> allowedWildlife) {
    Objects.requireNonNull(territory);
    Objects.requireNonNull(allowedWildlife);
    this.territory = territory;
    this.allowedWildlife = allowedWildlife;
    this.wildlife = null;
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
  public TerritoryType getTerritory() {
    return territory;
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
    result.append("Territory : ");
    result.append(territory);
    result.append(". Wildlife");
    result.append((wildlife != null ? wildlife : "None"));
    result.append("Allowed animals");
    result.append(allowedWildlife);
    return result.toString();
  }
}
