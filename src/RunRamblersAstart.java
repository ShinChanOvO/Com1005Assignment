

public class RunRamblersAstart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TerrainMap map1 = new TerrainMap("diablo.pgm");
		RamblersSearch searcher = new RamblersSearch(map1, new Coords(43,21));
		SearchState initState = (SearchState) new RamblersState(new Coords(1,1), 0, 0);
		String res_astar = searcher.runSearch(initState, "AStar");
		System.out.println(res_astar);
	}

}
