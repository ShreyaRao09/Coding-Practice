import java.util.ArrayList;
import java.util.HashMap;

/**
 * Find all the permutations of a string. The string can contain
 * duplicate characters
 * 
 * @author Shreya Vishwanath Rao
 * @version 1.0
 *
 */
public class PermutaionWithDuplicates {

	/**
	 * Finds all the unique permutations of a string.
	 * 
	 * @param str : string whose permutations need to be determined
	 * @return : list of unique permuations
	 */
	public static ArrayList<String> permutation(String str){
		ArrayList<String> result=new ArrayList<String>();
		HashMap<Character,Integer> list= buildHashMap(str);
		getPermutation(list,result,"",str.length());
		return result;
	}
	
	/**
	 * Builds a frequency table for all characters in the string
	 * 
	 * @param str : given string
	 * @return : frequency of all characters in the string
	 */
	public static HashMap<Character,Integer> buildHashMap(String str){
		HashMap<Character,Integer> map= new HashMap<Character,Integer>();
		for(char c:str.toCharArray()){
			if(!map.containsKey(c))
				map.put(c,0);
			map.put(c,map.get(c)+1);
		}
		return map;
	}
	
	/**
	 * Calculates the different permuatations
	 * 
	 * @param list : current frequency of all characters in the remaining string 
	 * @param result : permutations of the string determined till now
	 * @param prefix : prefix string for a permutation
	 * @param remain : character remaining for a new permutation
	 */
	public static void getPermutation(HashMap<Character,Integer> list, ArrayList<String> result, String prefix, int remain){
		if(remain==0){
			result.add(prefix);
			return;
		}
		
		for(char c:list.keySet()){
			int count=list.get(c);
			if(count>0){
				list.put(c, count-1);
				getPermutation(list,result,prefix+c,remain-1);
				list.put(c, count+1);
			}
		}
	}
	
	/**
	 * Main function. Calls permuation() to obtain the unique permuations
	 * of the string
	 * 
	 * @param args :Command line argument
	 */
	public static void main(String[] args){
		String str="ana";
		
		ArrayList<String> result=permutation(str);
		
		for(String s:result){
			System.out.println(s);
		}
	}
}
