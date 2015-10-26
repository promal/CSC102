import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Dictionary class that may sort a list of strings using a selection sort algorithm.
 * Furthermore, it can search for a word in the list using a binary search algorithm.
 * Implementing the Iterable interface to allow someone use the Java for-each statement.
 * @author Alejandro Guzman 10/15/15
 *
 */
public class Dictionary implements Iterable<String> {
	
	private java.util.ArrayList<String> dictionary = new java.util.ArrayList<String>();
	
	/**
	 * Constructs a dictionary from the specified text file that contains
	 * one word per line and, if necessary, sorts it.
	 * @param fileName name of file to read words.
	 * @param sort true if words should be sorted false otherwise.
	 * @throws DictionaryException when dictionary could not be created.
	 */
	public Dictionary(String fileName, boolean sort) throws DictionaryException {
		try (FileReader read = new FileReader(new File(fileName))) {
			try (Scanner scanner = new Scanner(read)){
				while (scanner.hasNext()) {
					this.dictionary.add(scanner.next());
				}
				if (sort) { sort(); }
			}
		} catch (IOException e) {
			System.err.println("File not found - " + fileName);
		}
		
	}

	/**
	 * Looks up the specified word in the Dictionary using a Binary Search algorithm.
	 * @param word the word to look for.
	 * @return true if the word is in the dictionary false otherwise.
	 */
	public boolean lookUp(String word) {
		int middle = 0;
		int first = 0;
		int last = this.dictionary.size();
		String search = null;
		boolean found = false;
		
		while (first <= last && !found) {
			middle = (last + first) / 2;
			search = this.dictionary.get(middle);
			if (word.compareTo(search) < 0) {
				last = middle - 1;
			} else if (word.compareTo(search) > 0) {
				first = middle + 1;
			} else {
				found = true;
			}
		}
		
		return found;
	}
	
	/**
	 * Writes the Dictionary to a text file using the java.io.PrintStream class
	 * to the specified name in ascending order and with a new line
	 * character between each word.
	 * @param fileName name of file to write to.
	 * @throws DictionaryException
	 */
	public void write(String fileName) throws DictionaryException {
		try (PrintStream out = new PrintStream(new File(fileName))) {
			for (int index = 0; index < this.dictionary.size(); index++) {
				out.println(this.dictionary.get(index));
			}
		} catch (IOException e) {
			System.err.println("Unable to write to file - " + fileName);
		}
		
	}
	/**
	 * Provides a java.util.Iterator that iterates over the Dictionary in order,
	 * a word at a time, from beginning to end.
	 */
	@Override
	public Iterator<String> iterator() {
		return this.dictionary.iterator();
	}
	
	/**
	 * Sorting algorithm that uses selection sort. Used the algorithm found
	 * in class lab.
	 */
	private void sort() {
		int N = this.dictionary.size(); // number of elements in dictionary
		for (int loop = 0; loop < N - 1; loop++) {
			int minPos = minPosition(loop);
			swap(minPos, loop);
		}		
	}
	
	private int minPosition(int from) {
		int minPos = from;
		for (int i = from + 1; i < this.dictionary.size(); i++) {
			String current = this.dictionary.get(i);
			String minWord = this.dictionary.get(minPos);
			if (current.compareTo(minWord) < 0) {
				minPos = i;
			}
		}
		return minPos;
	}
	
	/**
	 * Swaps items in the list.
	 * @param prev the previous element a[i-1]
	 * @param current the current element a[i]
	 */
	private void swap(int prev, int current) {
		String temp = this.dictionary.get(prev);
		this.dictionary.set(prev, this.dictionary.get(current));
		this.dictionary.set(current, temp);
	}
}
