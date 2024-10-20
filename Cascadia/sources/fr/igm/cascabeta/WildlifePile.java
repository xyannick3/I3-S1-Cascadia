package fr.igm.cascabeta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Objects;

public class WildlifePile {
  private List<WildlifeToken> pile;
  //initialise la pioche.
  public WildlifePile() {
    pile = new ArrayList<>();
    //il y a 20 token de chaque type
    for(var i =0; i<20;i++) {
      pile.add(WildlifeToken.SALMON);
      pile.add(WildlifeToken.BEAR);
      pile.add(WildlifeToken.HAWK);
      pile.add(WildlifeToken.FOX);
      pile.add(WildlifeToken.ELK);
    }
    melanger();
  }
  public void melanger() {
    Collections.shuffle(pile, new Random());
  }
  //cette méthode pioche un token et l'enlèvre de la pioche.
  public WildlifeToken draw() {
    if(!pile.isEmpty()) {
      return pile.remove(0);
    }
    return null;
  }
  //En théorie c'est impossible mais on sait jamais
  public boolean isEmpty() {
    return pile.isEmpty();
  }
  
  //add va nous permettre de gérer les situations des règles de surpopulation
  public void add(WildlifeToken token) {
    Objects.requireNonNull(token);
    pile.add(token);
    Collections.shuffle(pile, new Random());
  }
  
  
}
