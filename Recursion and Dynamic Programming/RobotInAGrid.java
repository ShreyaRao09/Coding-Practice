import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Imagine a robot sitting on the upper left hand corner of an NxN grid. 
 * The robot can only move in two directions : right and down.Imagine that 
 * certain squares are "off limits", such that the robot can not step on
 * them. Is there a possible path for the robot? Design an algorithm 
 * to get a possible path for the robot
 * 
 * @author Shreya Vishwanath Rao
 * @version 1.0
 *
 */
public class RobotInAGrid {

	/**
	 * Finds a path for the robot.
	 * 
	 * @param maze :integer array that represents the maze 
	 * @return : ArrayList of Points in the path
	 */
	public static ArrayList<Point> findPath(int[][] maze){
		if(maze==null||maze.length==0)
			return null;
		int row=maze.length-1;
		int col=maze[0].length-1;
		ArrayList<Point> path=new ArrayList<Point>();
		HashMap<Point,Boolean> list= new HashMap<Point,Boolean>();
		
		if(getPath(maze,row,col,path,list)){
			return path;
		}
		return null;
	}
	
	/**
	 * Determines if a path exists
	 * 
	 * @param maze : integer array representing the maze
	 * @param row : the current row
	 * @param col : the current column
	 * @param path : list of points along the path until the current point
	 * @param list : list of all point with a boolean value indicating if
	 * 				 a path is possible through that point
	 * @return true if a path exists; false otherwise
	 */
	public static boolean getPath(int[][] maze, int row, int col, ArrayList<Point> path, HashMap<Point,Boolean> list){

		if(row<0||col<0 || maze[row][col]==-1)
			return false;
		
		Point p=new Point(row, col);
		
		if(list.containsKey(p))
			return list.get(p);
		
		boolean isOrigin= (row==0)&&(col==0);
		boolean success=false;
		
		if(isOrigin|| getPath(maze, row-1,col,path,list)|| getPath(maze,row,col-1,path,list)){
			path.add(p);
			success=true;
		}
		
		list.put(p,success);
		return success;
	}
}
