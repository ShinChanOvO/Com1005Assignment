



public class RunRamblersBB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   TerrainMap map1 = new TerrainMap("tmc.pgm");
		    

		   RamblersSearch searcher = new RamblersSearch(map1, new Coords(0,0));
		   SearchState initState = (SearchState) new RamblersState(new Coords(12,14), 0, 0);

		    // change from search1 - specify strategy

		    // System.out.println(res_df);
		    //String res_bf = searcher.runSearch(initState, "depthFirst");
		    //System.out.println(res_bf);
		    // String res_bb = searcher.runSearch(initState, "branchAndBound");
		    // System.out.println(res_bb);

		    String res_bb = searcher.runSearch(initState, "branchAndBound");
		    System.out.println(res_bb);
		    
		    System.out.println("-----------------end of BNB search---------------- ");
		
		    
	}

}
