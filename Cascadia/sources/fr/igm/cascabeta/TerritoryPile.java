package fr.igm.cascabeta;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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
  public TerritoryPile(String csvFilePath,int n) {
    
  }
  public void melanger() {
    Collections.shuffle(pile, new Random());
  }
}
