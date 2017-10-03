/**
 * Solve the Tower of Hanoi problem.
 * 
 * This program uses another class named Tower.
 * 
 * @author Shreya Vishwanath Rao
 * @version 1.0
 *
 */
public class TowerOfHanoi {

	/**
	 * Main function. Creates n towers and assigns n disks to towerA.
	 * Calls functions from Tower class to solve the problem
	 * 
	 * @param args : Command line argument
	 */
	public static void main(String[] args){
		
		int n=3;
		Tower[] tower=new Tower[3];
		
		for(int i=0;i<3;i++){
			tower[i]=new Tower(i);
		}
		
		for(int i=n-1;i>=0;i--){
			tower[0].add(i);
		}
		
		tower[0].moveDisks(n-1, tower[2], tower[1]);
	}
}
