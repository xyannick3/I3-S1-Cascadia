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
    System.out.println(System.getProperty("user.dir"));
    var test = new TerritoryPile();
    var case1 = test.draw();
    var player1 = new Player("moi",20);
    player1.addTerritory(case1, 0, 0);
    player1.addTerritory(case1, 1, 0);
    player1.addTerritory(case1, 2, 2);
    System.out.println(player1.getName());
    var grid = player1.getTerritoryGrid();
    System.out.println(grid.getCase(0, 0));
    player1.getTerritoryGrid().displayGrid(); 
  }
  
  public static void main(String[] args) {
    test2();
    System.out.println("fin");
  }
}
