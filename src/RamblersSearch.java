

public class RamblersSearch extends Search {
	private TerrainMap map; // map we're searching
	private Coords goal; // goal city

	  public TerrainMap getMap() {
	    return map;
	  }

	  public Coords getGoal() {
	    return goal;
	  }
	  //constructor
	  public RamblersSearch(TerrainMap m, Coords g) {
	    map = m;
	    goal = g;
	  }
	}
