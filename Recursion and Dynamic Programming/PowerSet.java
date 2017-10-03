import java.util.ArrayList;

/**
 * Write a method that generates all subsets of a set.
 * 
 * @author Shreya Vishwanath Rao
 * @version 1.0
 *
 */

public class PowerSet {

	/**
	 * Generates the Power set
	 * 
	 * @param set : Array containing the set of elements
	 * @return a list of subsets
	 */
	public static ArrayList<ArrayList<Integer>> powerSet(ArrayList<Integer> set){
		ArrayList<ArrayList<Integer>> allsubsets= new ArrayList<ArrayList<Integer>>();
		if(set==null){
			allsubsets.add(new ArrayList<Integer>());
		}
		else{
			allsubsets.add(new ArrayList<Integer>());
			ArrayList<ArrayList<Integer>> copy= new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> newArray;
			for(int a:set){
				
				for(ArrayList<Integer> temp:allsubsets){
					newArray=(ArrayList<Integer>) temp.clone();
					newArray.add(a);
					copy.add(newArray);
				}
//				allsubsets.clear();
				allsubsets.addAll(copy);
				copy.clear();
			}
		}
		return allsubsets;
	}
	
	/**
	 * Main function. For a set of size 'n', it calls the function powerSet
	 * to obtain the subsets of the set.
	 * 
	 * @param args : Command line arguments
	 */
	public static void main(String[] args){
		int n=3;
		ArrayList<Integer> list= new ArrayList<Integer>();
		for(int i=1;i<=n;i++){
			list.add(i);
		}
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result=powerSet(list);
		
		for(ArrayList<Integer> temp:result){
			for(int a:temp){
				System.out.print(a+" ");
			}
			System.out.println("");
		}
	}
}
