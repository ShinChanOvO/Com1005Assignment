

public class RunRamblersAstart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TerrainMap map1 = new TerrainMap("tmc.pgm");
		RamblersSearch searcher = new RamblersSearch(map1, new Coords(0,0));
		SearchState initState = (SearchState) new RamblersState(new Coords(12,14), 0, 0);
		String res_astar = searcher.runSearch(initState, "AStar");
		System.out.println(res_astar);
	}

}
