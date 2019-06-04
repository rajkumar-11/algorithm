import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class GivenASequenceOfWordsPrintAllAnagramsTogether {
	public static void main(String args[]) {
		String wordArr[] = { "cat", "dog", "tac", "god", "act" };
		int size = wordArr.length;
		printAnagramsTogether(wordArr, size);
	}

	private static void printAnagramsTogether(String[] wordArr, int size) {
		int len = wordArr.length;
		Word[] words = new Word[len];
		for (int i = 0; i < len; i++) {
			char[] chars = wordArr[i].toCharArray();
			Arrays.sort(chars);
			String s = new String(chars);
			// System.out.println(s);
			words[i] = new Word(s, i);
		}
		Arrays.sort(words);
		for (int i = 0; i < len; i++) {
			System.out.println(words[i].word + " " + words[i].index);
		}
		for (int i = 0; i < len; i++){
			System.out.print(wordArr[words[i].index]+" ");
			
		}

	}

}

class Word implements Comparable<Word> {
	String word;
	int index;

	public Word(String word, int index) {
		this.word = word;
		this.index = index;
	}

	@Override
	public int compareTo(Word arg0) {

		return this.word.compareTo(arg0.word);
	}

}