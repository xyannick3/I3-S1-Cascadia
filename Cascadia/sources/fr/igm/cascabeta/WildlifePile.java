package fr.igm.cascabeta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import fr.igm.cascabeta.enums.WildlifeToken;

import java.util.Objects;

public class WildlifePile {
  private List<WildlifeToken> pile;
  //initialize the pile.
  public WildlifePile() {
    pile = new ArrayList<>();
    //there is 20 token per type
    for(var i =0; i<20;i++) {
      pile.add(WildlifeToken.SALMON);
      pile.add(WildlifeToken.BEAR);
      pile.add(WildlifeToken.HAWK);
      pile.add(WildlifeToken.FOX);
      pile.add(WildlifeToken.ELK);
    }
    shuffle();
  }
  public void shuffle() {
    Collections.shuffle(pile, new Random());
  }
  // this methode pick one token and remove it from the pile
  public WildlifeToken draw() {
    if(!pile.isEmpty()) {
      return pile.remove(0);
    }
    return null;
  }
  //chek if the pile is empty (must never append)
  public boolean isEmpty() {
    return pile.isEmpty();
  }
  // used for overpopulation rule
  public void add(WildlifeToken token) {
    Objects.requireNonNull(token);
    pile.add(token);
    shuffle();
  }
  
  
}
