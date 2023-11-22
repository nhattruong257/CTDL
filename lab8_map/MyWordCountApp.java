package lab8_map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class MyWordCountApp<K> {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into the above map (containing <word, its occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));
		while (input.hasNext()) {
			String word = input.next();
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		System.out.println(map);
	}

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() {
		return map.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		TreeMap<String, Integer> res = new TreeMap<>(map);
		for (Entry<String, Integer> entry : res.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		MyWordCountApp wc = new MyWordCountApp();
		wc.loadData();
		System.out.println("-----------------");
		System.out.println(wc.countUnique());
		System.out.println("-----------------");
		wc.printWordCounts();
		System.out.println("-----------------");
		wc.printWordCountsAlphabet();
		System.out.println("-----------------");

        
    }
}



