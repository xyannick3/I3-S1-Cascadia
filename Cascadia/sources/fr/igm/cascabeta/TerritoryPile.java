package fr.igm.cascabeta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.nio.file.*;

import fr.igm.cascabeta.enums.TerritoryType;
import fr.igm.cascabeta.enums.WildlifeToken;


public class TerritoryPile {
  private  List<TerritoryCase> pile;
  //n est le nombre de joueurs
  public TerritoryPile() {
    pile = new ArrayList<>();
    var pathToFile = Paths.get("sources/resources/cases_phase1.csv");
    try{
      List<String> lines = Files.readAllLines(pathToFile);
      boolean first = true;
      for(String line : lines) {
        if(first) {
          first = false;
          continue;
        }
        String [] fields = line.split(",");
        TerritoryType territory1= TerritoryType.valueOf(fields[0]);
        WildlifeToken wildlife1;
        WildlifeToken wildlife2;
        wildlife1 = WildlifeToken.valueOf(fields[1]);
        List<WildlifeToken> allowedWildlife = new ArrayList<>();
        allowedWildlife.add(wildlife1);
        if(fields.length >2) {
          wildlife2 = WildlifeToken.valueOf(fields[2]);
          allowedWildlife.add(wildlife2);
        }
        var newCase = new TerritoryCase(territory1, allowedWildlife);
        pile.add(newCase);
      }
    }catch (IOException e) {
      e.printStackTrace();
    }
    melanger();
  }
  public void melanger() {
    Collections.shuffle(pile, new Random());
  }
  public void add(TerritoryCase newcase) {
    Objects.requireNonNull(newcase);
    pile.add(newcase);
  }
  public TerritoryCase draw() {
    if(pile.isEmpty()) {
      return null;
    }
    return pile.remove(0);
  }
}
