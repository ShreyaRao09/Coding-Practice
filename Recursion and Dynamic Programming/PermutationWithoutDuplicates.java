import java.util.ArrayList;

/**
 * Determine the permutation of a string. Assume that the string contains
 * no duplicate characters
 * 
 * @author Shreya Vishwanath Rao
 * @version 1.0
 *
 */

public class PermutationWithoutDuplicates {

	/**
	 * Finds the permutations of a string
	 * 
	 * @param str : given string
	 * @return : list of permutations
	 */
	public static ArrayList<String> permutation(String str){
		ArrayList<String> result=new ArrayList<String>();
		perm("",str,result);
		return result;
	}
	
	/**
	 * Helper function in finding duplicates. It takes each character of
	 * string and adds it to the prefix in different combinations. This
	 * function is performed recursively
	 * 
	 * @param prefix : prefix of a permutation of the string
	 * @param remainder : characters left to make a combination
	 * @param result : list of permutations
	 */
	public static void perm(String prefix, String remainder, ArrayList<String> result){
		if(remainder.length()==0){
			result.add(prefix);
		}
		
		for(int i=0;i<remainder.length();i++){
			char c=remainder.charAt(i);
			String before=remainder.substring(0, i);
			String after=remainder.substring(i+1);
			perm(prefix+c,(before+after),result);
		}
		
	}
	
	
	 /**
	 * Finds the permutations of a string in an iterative manner
	 * 
	 * @param str : given string
	 * @return : list of permutations of the given string 
	 */
	/*
	 *Iterative version
	 * 
	 * public static ArrayList<String> permutation(String str){
		if(str==null) return null;
		
		ArrayList<String> perm=new ArrayList<String>();
		ArrayList<String> newPerm=new ArrayList<String>();
		
		if(str.length()==0){
			perm.add("");
			return perm;
		}
			
		String s=Character.toString(str.charAt(0));
		perm.add(s);
		for(int i=1;i<str.length();i++){
			char letter=str.charAt(i);
			for(String word:perm){
				for(int j=0;j<=word.length();j++){
					String temp=insert(word,letter,j);
					if(!newPerm.contains(temp))
						newPerm.add(temp);
				}
			}
			perm.clear();
			perm.addAll(newPerm);
			newPerm.clear();
		}
		
		return perm;
	}*/
	
	/**
	 * Insert a character into a specific position in a string
	 * 
	 * @param word : string that needs to be modified
	 * @param letter : character to be inserted
	 * @param pos : position at which the character has to be inserted
	 * @return : modified string
	 */
	/*
	 * Helper function for iterative version
	 *
	public static String insert(String word, char letter, int pos){
		String first=word.substring(0,pos);
		String last=word.substring(pos);
		//return first+Character.toString(letter)+last;
		return first+letter+last;
	}
	
	*/
	
	/**
	 * Main function. Calls perm() to calculate the permutations of a string
	 * 
	 * @param args :Command line argument
	 */
	public static void main(String[] args){
		String str="ice";
		
		ArrayList<String> result=permutation(str);
		
		for(String s:result){
			System.out.println(s);
		}
	}
}
