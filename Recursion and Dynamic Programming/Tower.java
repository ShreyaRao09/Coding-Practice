import java.util.Stack;

/**
 * Solve the Tower of Hanoi problem.
 * 
 * This program uses another class named TowerOfHanoi
 * 
 * @author Shreya Vishwanath Rao
 * @version 1.0
 *
 */

public class Tower {

	private Stack<Integer> disks;
	private int index;
	
	/**
	 * Constructor of the class
	 * @param i : the index number of the tower
	 */
	public Tower(int i){
		disks=new Stack<Integer>();
		index=i;
	}
	
	/**
	 * Adds disks to the tower.
	 * 
	 * @param d : disk number to be added
	 */
	public void add(int d){
		if(!disks.isEmpty() && disks.peek()<=d){
			System.out.println("Error adding disk " + d);
		}
		else
			disks.push(d);
	}
	
	/*Return the index of the tower*/
	public int index(){
		return index;
	}
	
	/**
	 * Moves the disk at the top to the tower provided 
	 * @param t : tower to which the disk has to be moved
	 */
	public void moveTop(Tower t){
		int top=disks.pop();
		t.add(top);
	}
	
	/**
	 * Moves the n-1 disks to the buffer. moves the nth disk to the destination
	 * and then moves the n-1 disks from the buffer to the destination
	 *  
	 * @param n : number of disks to be moved
	 * @param destination : distination tower
	 * @param buffer : buffer tower
	 */
	public void moveDisks(int n, Tower destination, Tower buffer){
		if(n>0){
			moveDisks(n-1,buffer,destination);
			moveTop(destination);
			buffer.moveDisks(n-1, destination, this);
			}
	}
}
