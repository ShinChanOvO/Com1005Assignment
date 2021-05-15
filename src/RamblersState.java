
import java.util.ArrayList;

public class RamblersState extends SearchState {
	// coordinate of for this state
	private Coords coords;
	  
	// constructor
	public RamblersState(Coords inputCoords, int inputLocalCost,int inputEstCost) {
		coords=inputCoords;
		localCost = inputLocalCost;
		estRemCost =inputEstCost;
	 }  
	
	@Override
	boolean goalPredicate(Search searcher) {
		RamblersSearch rsearcher = (RamblersSearch) searcher;
		Coords tar = rsearcher.getGoal(); // get target coordinate
		return (coords.equals(tar));
	}

	@Override
	ArrayList<SearchState> getSuccessors(Search searcher) {
		
		RamblersSearch rsearcher = (RamblersSearch) searcher;
	    TerrainMap map = rsearcher.getMap();
	    int[][]usingArray=map.getTmap();
	    ArrayList<SearchState> returnArray = new ArrayList<SearchState>();
	 
	    //check if the coordinate starts from 0 
	   if (coords.gety()!=0 && coords.getx()!=0) {
		   // do the y+ move 
		   if(usingArray[coords.gety()][coords.getx()] <= usingArray[coords.gety()+1][coords.getx()] ){
				   int cost=1;
				   returnArray.add((SearchState) new RamblersState(new Coords(coords.gety()+1,coords.getx()), cost,0));
				   }
		   else {
			   int cost=1+Math.abs((coords.gety()-(coords.gety()+1)));
			   returnArray.add((SearchState) new RamblersState(new Coords(coords.gety()+1,coords.getx()), cost,0));
		   		} 
		   //do the y- move
		   if(usingArray[coords.gety()][coords.getx()] <= usingArray[coords.gety()-1][coords.getx()] ){
			   int cost=1;
			   returnArray.add((SearchState) new RamblersState(new Coords(coords.gety()-1,coords.getx()), cost,0));
			   }
		   else {
			   int cost=1+Math.abs((coords.gety()-(coords.gety()+1)));
			   returnArray.add((SearchState) new RamblersState(new Coords(coords.gety()-1,coords.getx()), cost,0));
	   		} 
		   //do the x+ move
		   if(usingArray[coords.gety()][coords.getx()] <= usingArray[coords.gety()+1][coords.getx()] ){
			   int cost=1;
			   returnArray.add((SearchState) new RamblersState(new Coords(coords.gety()+1,coords.getx()), cost,0));
			   }
	   else {
		   int cost=1+Math.abs((coords.gety()-(coords.gety()+1)));
		   returnArray.add((SearchState) new RamblersState(new Coords(coords.gety()+1,coords.getx()), cost,0));
	   		} 
	     
	    }
	    return returnArray;
	  
		
	}

	@Override
	boolean sameState(SearchState n2) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
