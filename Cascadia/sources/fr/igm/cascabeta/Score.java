package fr.igm.cascabeta;

import java.util.ArrayList;
import java.util.List;

public class Score {
  // score of the player[0] is at index 0, ...
  private final List<Integer> salmon;
  private final List<Integer> bear;
  private final List<Integer> hawk;
  private final List<Integer> fox;
  private final List<Integer> elk;
  private final List<Integer> faunaScore;
  // private final List<Integer> naturalToken;
  // the value of the bonus for the max number of tile per habitat
  private final int bonusValue;
  // index of the player who have the bonus (default = -1)
  private final int mountainBonus;
  private final int forestBonus;
  private final int wetlandBonus;
  private final int riverBonus;
  private final int prairieBonus;
  // score per habitat
  private final List<Integer> mountain;
  private final List<Integer> forest;
  private final List<Integer> wetland;
  private final List<Integer> river;
  private final List<Integer> prairie;
  private final List<Integer> habitatScore;
  
  public Score() {
    this.salmon = new ArrayList<Integer>();
    this.bear   = new ArrayList<Integer>();
    this.hawk   = new ArrayList<Integer>();
    this.fox    = new ArrayList<Integer>();
    this.elk    = new ArrayList<Integer>();
    this.faunaScore   = new ArrayList<Integer>();
    this.mountain     = new ArrayList<Integer>();
    this.forest       = new ArrayList<Integer>();
    this.wetland      = new ArrayList<Integer>();
    this.river        = new ArrayList<Integer>();
    this.prairie      = new ArrayList<Integer>();
    this.habitatScore = new ArrayList<Integer>();
    this.bonusValue    = 3;
    this.mountainBonus = -1;
    this.forestBonus   = -1;
    this.wetlandBonus  = -1;
    this.riverBonus    = -1;
    this.prairieBonus  = -1;
  }
  
  public Score updateScore() {
    // TODO update each score
    return new Score();
  }
  private String displayLineBonus(int winnerIndex, int numberPlayer) {
    var line = new StringBuilder("Bonus");
    var separator = " | ";
    line.append(separator);
    for(int index = 0; index < numberPlayer; index++) {
      if (index == winnerIndex) {
	line.append(bonusValue).append(separator);
      }
      else {
	line.append(" ").append(separator);
      }
    }
    return line.toString();
  }
  
  private String displayLineIntegerList(String lineTitle, List<Integer> data) {
    var line = new StringBuilder(lineTitle);
    var separator = " | ";
    line.append(separator);
    for(var value : data) {
      line.append(value).append(separator);
    }
    return line.toString();
  }
  public void displayScore(/*take a List of player in parameter*/) { 
    // TODO display player name
    var numberPlayerTODO = 0;// remove when add parameter
    System.out.println(displayLineIntegerList("Bear",bear));
    System.out.println(displayLineIntegerList("Elk",elk));
    System.out.println(displayLineIntegerList("Salmon",salmon));
    System.out.println(displayLineIntegerList("Hawk",hawk));
    System.out.println(displayLineIntegerList("Fox",fox));
    System.out.println(displayLineIntegerList("Fauna Score",faunaScore));
    
    System.out.println(displayLineIntegerList("Mountain",mountain) + "\n" + displayLineBonus(mountainBonus, numberPlayerTODO));
    System.out.println(displayLineIntegerList("Forest",forest)+ "\n" + displayLineBonus(forestBonus, numberPlayerTODO));
    System.out.println(displayLineIntegerList("Wetland",wetland)+ "\n" + displayLineBonus(wetlandBonus, numberPlayerTODO));
    System.out.println(displayLineIntegerList("River",river)+ "\n" + displayLineBonus(riverBonus, numberPlayerTODO));
    System.out.println(displayLineIntegerList("Prairie",prairie)+ "\n" + displayLineBonus(prairieBonus, numberPlayerTODO));
    System.out.println(displayLineIntegerList("HabitatScore",habitatScore));
    
    // TODO display naturalToken when added
    // TODO display total score
   }
 }