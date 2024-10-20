package fr.igm.cascabeta;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
public class TerritoryPile {
  private  List<TerritoryCase> pile;
  //n est le nombre de joueurs
  public TerritoryPile(String csvFilePath,int n) {
    Objects.requireNonNull(n);
    pile = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
      String line;
      boolean isFirstLine = true; // saute entête
      while ((line = br.readLine()) != null) {
          if (isFirstLine) {
              isFirstLine = false;
              continue; 
          }
          String[] values = line.split(",");
          TerritoryType t1 = TerritoryType.valueOf(values[0].trim());
          TerritoryType t2 = TerritoryType.valueOf(values[1].trim());

          // Parse Wildlife (columns 3, 4, 5), ignore empty strings
          List<WildlifeToken> allowedWildlife = new ArrayList<>();
          if (!values[2].isEmpty()) allowedWildlife.add(WildlifeToken.valueOf(values[2].trim()));
          if (values.length >3 && (!values[3].isEmpty())) allowedWildlife.add(WildlifeToken.valueOf(values[3].trim()));
          if (values.length >4 && (!values[4].isEmpty())) allowedWildlife.add(WildlifeToken.valueOf(values[4].trim()));

          // Create a new Case object
          var newCase = new TerritoryCase(t1, t2, allowedWildlife);
          System.out.println(newCase);
          pile.add(newCase);
      }
      melanger();
      //TODO ajuster le nombre de token territoire proportionellement à n le nombre de joueurs
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  public void melanger() {
    Collections.shuffle(pile, new Random());
  }
}
