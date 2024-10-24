import fr.igm.cascabeta.*;

public class Main {
  public static void test1() {
    System.out.println(System.getProperty("user.dir"));
    var test = new TerritoryPile();
    var case1 = test.draw();
    while(case1!=null) {
      System.out.println(case1);
      case1 = test.draw();
    }
  }
  
  public static void test2() {
    var test = new TerritoryPile();
    var case1 = test.draw();
    var player1 = new Player("moi",20);
    System.out.println(player1.getName());
    System.out.println(player1.addTerritory(case1, new Coordinates(20, 20)));
    System.out.println(player1.addTerritory(case1, new Coordinates(21, 20)));
    System.out.println(player1.addTerritory(case1, new Coordinates(21, 21)));
    System.out.println(player1.addTerritory(case1, new Coordinates(21, 22)));
    System.out.println(player1.addTerritory(case1, new Coordinates(20, 22)));
    var grid = player1.getTerritoryGrid();
    System.out.println("first card ->" + grid.getCase(new Coordinates(20, 20)));
    player1.getTerritoryGrid().displayGrid(); 
  }
  
  public static void main(String[] args) {
    test2();
    System.out.println("end of program");
  }
}
