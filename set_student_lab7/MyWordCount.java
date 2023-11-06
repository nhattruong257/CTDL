package set_student_lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		List<WordCount> re = new ArrayList<WordCount>();
		for (String w : words) {
			if (!re.contains(w)) {
				re.add(new WordCount(w, count(w)));
			}
		}
		return re;
	}

	public int count(String w) {
		int count = 0;
		for (String s : words) {
			if (s.equals(w))
				count++;
		}
		return count;
	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> re = new HashSet<String>();
		for (WordCount wc : getWordCounts()) {
			if (wc.getCount() ==1)
				re.add(wc.getWord());
		}
		return re;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		Set<String> re = new HashSet<String>();
		for (WordCount wc : getWordCounts()) {
			if (wc.getCount() >1)
				re.add(wc.getWord());
		}
		return re;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		Set<WordCount> re = new TreeSet<WordCount>(new Comparator<WordCount>() {
			
			@Override
			public int compare(WordCount wc1, WordCount wc2) {
				// TODO Auto-generated method stub
				int re = wc1.getCount() - wc2.getCount();
				if(re==0) {
					return wc2.getWord().compareTo(wc1.getWord());
				}
				return re;
			}
			
		});
		re.addAll(this.getWordCounts());
		return re;
	}
	public Set<String> filterWords(String pattern) {
		// TODO
		Set<String> filter = new HashSet<String>();
		for(String word : words)
		{
			if(!word.startsWith(pattern)) {
				filter.add(word);
			}
		}
		return filter;
		}

	public static void main(String[] args) {
		MyWordCount mywordcount = new MyWordCount();
		System.out.println((mywordcount.getWordCounts()));
		System.out.println((mywordcount.getDistinctWords()));
		System.out.println((mywordcount.getUniqueWords()));
		System.out.println((mywordcount.printWordCounts()));
		System.out.println(mywordcount.filterWords("L"));
	}
}