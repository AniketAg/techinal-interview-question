import java.util.*;
import java.lang.*;

public class Anagram 
{

	/**
	 * Determines if one string is an anagram of another string
	 * 
	 * @param s1 first string
	 * @param s2 second string
	 * 
	 * @return true if s1 and s2 are anagrams of each other
	 */
	public static boolean isAnagram(String s, String t) 
	{

		if (s.length() != t.length()) 
		return false;
	
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) 
		{
			//getOrDefault()
			int count1 = map.getOrDefault(s.charAt(i), 0) + 1;
			map.put(s.charAt(i), count1);

			int count2 = map.getOrDefault(t.charAt(i), 0) - 1;
			map.put(t.charAt(i), count2);
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) 
			if (entry.getValue() != 0) 
				return false;
		return true;
	}

	/**
	 * Handles both case sensitive and case insensitive anagrams
	 */
	
	public static boolean isWordAnagram(String s1, String s2, boolean isCaseSensitive) 
	{
		if (isCaseSensitive) 
			return isAnagram(s1, s2);
		else 
			return isAnagram(s1.toLowerCase(), s2.toLowerCase());
	}

	/**
	 * Determines if one sentence is an anagram of another sentence
	 * where each word in the resulting sentence is an anagram
	 * of one of the words in the original sentence
	 * 
	 * @param s1 first sentence
	 * @param s2 second sentence
	 * 
	 * @return true if s1 and s2 are anagrams of each other
	 */
	public static boolean isSentenceAnagram(String s1, String s2) 
	{

		String[] sentence1 = s1.split("\\s*");
		String[] sentence2 = s2.split("\\s*");

		if (sentence1.length != sentence2.length) 
			return false;
		else 
		{

			boolean[] isAnagramFoundFirst = new boolean[sentence1.length];
			boolean[] isAnagramFoundSecond = new boolean[sentence2.length];

			for (int i = 0; i < sentence1.length; i++) 
				for (int j = 0; j < sentence2.length; j++) 
					if (isWordAnagram(sentence1[i], sentence2[j], false)) 
					{
						isAnagramFoundFirst[i] = true;
						isAnagramFoundSecond[j] = true;
					}
			
			for (int i = 0; i < isAnagramFoundFirst.length; i++) 
				if (!isAnagramFoundFirst[i] || !isAnagramFoundSecond[i]) 
					return false;
			return true;
		}
	}

	/**
	 * Compares in the list of strings if anagrams exist or not
	 * and prints only the last anagrams when it finds them in 
	 * the list of strings and if it does not exist it just adds 
	 * that value to the list and prints it
	 */
	public static void getUniqueString(List<String> list)
	{
		List<Integer> value = new ArrayList<>();

		for(int i = 0 ; i < list.size(); i++ )
		{
			int flag=0;	
			for(int j = i; j < list.size(); j++)
				if(isSentenceAnagram(list.get(i),list.get(j)))
					flag=j;
			
			if(flag!=0)
			value.add(flag);
		}

		HashSet<Integer> unique = new HashSet<>(value);
		for(int i : unique)
			System.out.println(list.get(i));


	}

	public static void main(String[] args) 
	{
		long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		long startTime = System.nanoTime();
		List<String> list = new ArrayList<String>();
		list.add("Sunny it is");
		list.add("sunny it is");
		list.add("hello world");
		list.add("Sunny here");
		list.add("Hello World");
		list.add("Sunny is it");
		list.add("is it sunny");
		list.add("World hello");
		
		//Testing
		System.out.println("");
		System.out.println(isAnagram("root","Tor"));
		System.out.println(isAnagram("triangle", "integral"));
		System.out.println("");

		System.out.println(isWordAnagram("lemon", "Monel", false));
		System.out.println(isWordAnagram("lemon", "Monel", true));
		System.out.println("");
		
		System.out.println(isSentenceAnagram("I love icecream", "vole i creamice"));
		System.out.println(isSentenceAnagram("I love icecream", "I love cream"));
		System.out.println(isSentenceAnagram("abc abc", "abc def"));
		System.out.println("");

		getUniqueString(list);

		System.out.println("");
		
		long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		long endTime = System.nanoTime();
		System.out.println("Memory used: "+(afterUsedMem-beforeUsedMem)/(1024*1024)+" MB");
		System.out.println("Time Taken: "+(endTime - startTime)/10000000 + " ms"); 
	}
}