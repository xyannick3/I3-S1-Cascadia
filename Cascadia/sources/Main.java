import fr.igm.cascabeta.TerritoryPile;
public class Main {
  public static void main(String[] args) {
    System.out.println(System.getProperty("user.dir"));
    var test = new TerritoryPile();
    var case1 = test.draw();
    while(case1!=null) {
      System.out.println(case1);
      case1 = test.draw();
    }
  }
}
