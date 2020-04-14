/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestantsâ€™
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *    ï‚· Each contestant walks at a given estimated speed.
 *    ï‚· The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Floyd-Warshall algorithm
 */

import java.io.BufferedReader;
import java.io.FileReader;


public class CompetitionFloydWarshall {

	private static final double INFINITY = Integer.MAX_VALUE;   // to prevent overflow 

	double grid[][];    // [from][to]

	private int sA,sB,sC;
	int numOfIntersections,numOfStreets;    	//N , S
	int slowest,fastest;
	String filename;
	boolean validFile = true;

	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA, sB, sC: speeds for 3 contestants
	 */
	CompetitionFloydWarshall (String filename, int sA, int sB, int sC){
		this.filename = filename;
		this.sA = sA;
		this.sB = sB;
		this.sC = sC;
		this.initial();
	}


	private void initial(){
		slowest = Math.min(sA, sB);
        slowest = Math.min(slowest, sC);
        
        fastest = Math.max(sA, sB);
        fastest = Math.max(fastest, sC);

		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			numOfIntersections = Integer.parseInt(br.readLine());
			numOfStreets = Integer.parseInt(br.readLine());

			if(numOfIntersections == 0 || numOfStreets == 0 ){
				validFile = false;
			}
			else{
				grid = new double[numOfIntersections][numOfStreets];
				for (int i = 0; i < numOfIntersections; i++){
					for (int j = 0; j < numOfIntersections; j++){
						if(i == j)
							grid[i][j] = 0;
						
						grid[i][j] = INFINITY;
					}
				}
				String line = br.readLine();
				while((line != null)){
					String[] lSplit = line.trim().split(" ");
					grid[Integer.parseInt(lSplit[0])][Integer.parseInt(lSplit[1])] = Double.parseDouble(lSplit[2]);
					line = br.readLine();
				}
				br.close();
			}
		}
		
		catch (Exception e){
			validFile = false;
			slowest = -1;
		}
	}

	private double getMax(){
		double maxDist = -1;
		for (int i = 0; i < numOfIntersections; i++){
			for (int j = 0; j < numOfIntersections; j++){
				if(grid[i][j] > maxDist && i != j){
					maxDist = grid[i][j];
				}
			}
		}
		return maxDist;
	}

	/**
	 * @return int: minimum minutes that will pass before the three contestants can meet
	 */
	public int timeRequiredforCompetition(){
		if(slowest<50 || fastest>100){
			return -1;
		}

		if(!validFile){
			return -1;
		}
		//floyd warshall algorithm
		for (int k = 0; k < numOfIntersections; k++){
			for (int i = 0; i < numOfIntersections; i++){
				for (int j = 0; j < numOfIntersections; j++){
					if(grid[i][k] + grid[k][j] < grid[i][j]){
						grid[i][j] = grid[i][k] + grid[k][j];
					}
				}
			}
		}
		
		double maxDist = getMax();
		if (maxDist == INFINITY)
			return -1;

		maxDist = maxDist * 1000;   
		return (int) Math.ceil(maxDist / slowest);
	}

}