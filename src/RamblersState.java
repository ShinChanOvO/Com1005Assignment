
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
	public ArrayList<SearchState> getSuccessors(Search searcher) {
		
		RamblersSearch rsearcher = (RamblersSearch) searcher;
	    TerrainMap map = rsearcher.getMap();
	    int[][]usingArray=map.getTmap();
	    Coords goal=rsearcher.getGoal();
	    ArrayList<SearchState> returnArray = new ArrayList<SearchState>();
	    int y=coords.gety();
	    int x=coords.getx();
	    int maxY=map.getDepth();
	    int maxX=map.getWidth();
	    //check if the coordinate starts from 0 or start from one of the end
	    if (y!=0 && x!=0 && y!= maxY-1 &&x!=maxX-1) {
		   // do the y move 
		   for (int i=-1;i<3;i=i+2) {
		   if(usingArray[y][x] <= usingArray[y+i][x] ){
			   int cost=1;
				   //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
				   //uncomment the line above and comment out line below to change the est to Euclidean distance
				   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
				   returnArray.add((SearchState) new RamblersState(new Coords(y+i,x), cost,est));
				   }
		   else {
			   int cost=1+Math.abs(usingArray[y][x]-usingArray[y+i][x]);
			 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
			   //uncomment the line above and comment out line below to change the est to Euclidean distance
			   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
			   returnArray.add((SearchState) new RamblersState(new Coords(y+i,x), cost,est));
		   		} 
		   //do the x move
		   if(usingArray[y][x] <= usingArray[y][x+i] ){
			   int cost=1;
			 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
			   //uncomment the line above and comment out line below to change the est to Euclidean distance
			   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
			   returnArray.add((SearchState) new RamblersState(new Coords(y,x+i), cost,est));
			   }
		   else {
			   int cost=1+Math.abs(usingArray[y][x]-usingArray[y][x+i]);
			 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
			   //uncomment the line above and comment out line below to change the est to Euclidean distance
			   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
			   returnArray.add((SearchState) new RamblersState(new Coords(y,x+i), cost,est));
	   		} 
		   }
	     
	    }
	   // if x=0 and Y in a normal case
	   else if (y!=0 && y!= maxY-1 && x==0) {
		// do the y move 
		   for (int i=-1;i<3;i=i+2) {
		   if(usingArray[y][x] <= usingArray[y+i][x] ){
				   int cost=1;
				 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
				   //uncomment the line above and comment out line below to change the est to Euclidean distance
				   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
				   returnArray.add((SearchState) new RamblersState(new Coords(y+i,x), cost,est));
				   }
		   else {
			 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
			   //uncomment the line above and comment out line below to change the est to Euclidean distance
			   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
			   int cost=1+Math.abs(usingArray[y][x]-usingArray[y+i][x]);
			   returnArray.add((SearchState) new RamblersState(new Coords(y+i,x), cost,est));
		   		} 
		   //do the x move for only move to the right
		   if(usingArray[y][x] <= usingArray[y][x+1] ){
			   int cost=1;
			 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
			   //uncomment the line above and comment out line below to change the est to Euclidean distance
			   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
			   returnArray.add((SearchState) new RamblersState(new Coords(y,x+1), cost,est));
			   }
		   else {
			   int cost=1+Math.abs(usingArray[y][x]-usingArray[y][x+1]);
			 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
			   //uncomment the line above and comment out line below to change the est to Euclidean distance
			   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
			   returnArray.add((SearchState) new RamblersState(new Coords(y,x+1), cost,est));
	   		} 
		   }
	   }
	   //if x =max and Y in a normal case
	   else if(x==maxX-1 && y!=0 && y!=maxY-1) {
		   //do the x move only to the left side
		   if(usingArray[y][x] <= usingArray[y][x-1] ){
			 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
			   //uncomment the line above and comment out line below to change the est to Euclidean distance
			   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
			   int cost=1;
			   returnArray.add((SearchState) new RamblersState(new Coords(y,x-1), cost,est));
			   }
		   else {
			 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
			   //uncomment the line above and comment out line below to change the est to Euclidean distance
			   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
			   int cost=1+Math.abs(usingArray[y][x]-usingArray[y][x-1]);
			   returnArray.add((SearchState) new RamblersState(new Coords(y,x-1), cost,est));
	   		} 
		   //do the y move 
		   for (int i=-1;i<3;i=i+2) {
			   if(usingArray[y][x] <= usingArray[y+i][x] ){
					   int cost=1;
					 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
					   //uncomment the line above and comment out line below to change the est to Euclidean distance
					   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
					   returnArray.add((SearchState) new RamblersState(new Coords(y+i,x), cost,est));
					   }
			   else {
				 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
				   //uncomment the line above and comment out line below to change the est to Euclidean distance
				   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
				   int cost=1+Math.abs(usingArray[y][x]-usingArray[y+i][x]);
				   returnArray.add((SearchState) new RamblersState(new Coords(y+i,x), cost,est));
			   		} 
	   }
	   }
	   //if y=0 and x in a normal case
	   else if(x!=0 && x!= maxX-1 && y==0) {
		// do the x move 
		   for (int i=-1;i<3;i=i+2) {
		   if(usingArray[y][x] <= usingArray[y][x+i] ){
			 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
			   //uncomment the line above and comment out line below to change the est to Euclidean distance
			   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
				   int cost=1;
				   returnArray.add((SearchState) new RamblersState(new Coords(y,x+i), cost,est));
				   }
		   else {
			   int cost=1+Math.abs(usingArray[y][x]-usingArray[y][x+i]);
			 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
			   //uncomment the line above and comment out line below to change the est to Euclidean distance
			   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
			   returnArray.add((SearchState) new RamblersState(new Coords(y,x+i), cost,est));
		   		} 
		   }
		//do the y move only to the up side
		   if(usingArray[y][x] <= usingArray[y+1][x] ){
			 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
			   //uncomment the line above and comment out line below to change the est to Euclidean distance
			   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
			   int cost=1;
			   returnArray.add((SearchState) new RamblersState(new Coords(y+1,x), cost,est));
			   }
	   else {
		 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
		   //uncomment the line above and comment out line below to change the est to Euclidean distance
		   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
		   int cost=1+Math.abs(usingArray[y][x]-usingArray[y+1][x]);
		   returnArray.add((SearchState) new RamblersState(new Coords(y+1,x), cost,est));
	   		}    
	   }
	   
	   //if y=max and x in a normal case
	   else if(x!=0 && x!= maxX-1 && y==maxY-1) {
		 //do the y move only to the down side
		   if(usingArray[y][x] <= usingArray[y-1][x] ){
			 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
			   //uncomment the line above and comment out line below to change the est to Euclidean distance
			   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
			   int cost=1;
			   returnArray.add((SearchState) new RamblersState(new Coords(y-1,x), cost,est));
			   }
	   else {
		   int cost=1+Math.abs(usingArray[y][x]-usingArray[y-1][x]);
		 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
		   //uncomment the line above and comment out line below to change the est to Euclidean distance
		   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
		   returnArray.add((SearchState) new RamblersState(new Coords(y-1,x), cost,est));
	   		}    
	   
	// do the x move 
	   for (int i=-1;i<3;i=i+2) {
	   if(usingArray[y][x] <= usingArray[y][x+i] ){
		 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
		   //uncomment the line above and comment out line below to change the est to Euclidean distance
		   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
			   int cost=1;
			   returnArray.add((SearchState) new RamblersState(new Coords(y,x+i), cost,est));
			   }
	   else {
		   int cost=1+Math.abs(usingArray[y][x]-usingArray[y][x+i]);
		 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
		   //uncomment the line above and comment out line below to change the est to Euclidean distance
		   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
		   returnArray.add((SearchState) new RamblersState(new Coords(y,x+i), cost,est));
	   		} 
	   }
	   }
	   
	   //if y=max and x=max
	   //do the y move only to the down side
	   else if(y==maxY-1 && x==maxX-1) {
	   if(usingArray[y][x] <= usingArray[y-1][x] ){
		 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
		   //uncomment the line above and comment out line below to change the est to Euclidean distance
		   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
		   int cost=1;
		   returnArray.add((SearchState) new RamblersState(new Coords(y-1,x), cost,est));
		   }
	   else {
		 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
		   //uncomment the line above and comment out line below to change the est to Euclidean distance
		   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
	   int cost=1+Math.abs(usingArray[y][x]-usingArray[y-1][x]);
	   returnArray.add((SearchState) new RamblersState(new Coords(y-1,x), cost,est));
   		}    
	   //do the x move only to the left side
	   if(usingArray[y][x] <= usingArray[y][x-1] ){
		 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
		   //uncomment the line above and comment out line below to change the est to Euclidean distance
		   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
		   int cost=1;
		   returnArray.add((SearchState) new RamblersState(new Coords(y,x-1), cost,est));
		   }
	   else {
		 //int est=(int)Math.sqrt((y-goal.gety())^2+(x-goal.getx())^2);
		   //uncomment the line above and comment out line below to change the est to Euclidean distance
		   int est=Math.abs(usingArray[y][x]-usingArray[goal.gety()][goal.getx()]);
		   int cost=1+Math.abs(usingArray[y][x]-usingArray[y][x-1]);
		   returnArray.add((SearchState) new RamblersState(new Coords(y,x-1), cost,est));
   		} 
	   }  
	    return returnArray;
	  
	   }
	

	@Override
	boolean sameState(SearchState n2) {
		RamblersState rs2= (RamblersState) n2;
	    return (coords.equals(rs2.coords));
	  }
	
	@Override
	public String toString () {
	    return ("Map State: "+coords);
	  }
	
	}
	

	
	

	
