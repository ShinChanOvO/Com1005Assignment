import java.util.Scanner;

public class RunRamblersBB {

	public static void main(String[] args) {
		
		   TerrainMap map1 = new TerrainMap("diablo.pgm");
		   System.out.println("you are using branchAndBound search now");
		   Scanner reader = new Scanner(System.in);  // Reading from System.in
		   //read the input
		   System.out.println("Enter the y value of the start point:");
		   int startY = reader.nextInt();
		   System.out.println("Enter the x value of the start point:");
		   int startX = reader.nextInt();
		   System.out.println("Enter the y value of the goal point:");
		   int goalY = reader.nextInt(); 
		   System.out.println("Enter the x value of the goal point:");
		   int goalX = reader.nextInt();
		   Coords start=new Coords(startY,startX);
		   Coords goal=new Coords(goalY,goalX);
		   reader.close();
		   //run the search
		   RamblersSearch searcher = new RamblersSearch(map1, goal);
		   SearchState initState = (SearchState) new RamblersState(start, 0, 0);
		   String res_bb = searcher.runSearch(initState, "branchAndBound");
		   System.out.println(res_bb); 
		   System.out.println("-----------------end of BNB search---------------- ");
		
		    
	}

}
