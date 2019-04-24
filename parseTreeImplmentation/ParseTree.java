package parseTreeImplementation;

import java.util.LinkedList;
import java.util.Queue;

public class ParseTree {

	private String code;
	private Queue<Character> codeChar = new LinkedList<Character>();

	public ParseTree(String code) {

		this.code = code;
	}

	public void addToQueue() {

		try {

			int i;
			int size = code.length();
			for (i = 0; i < size; i++) {

				char ch = code.charAt(i);

				codeChar.add(ch);
			}

		} catch (Exception e) {

		}

	}

	public void parseTreeConstruct() {

		try {

			int size = codeChar.size();
			int i;

			for (i = 0; i < size; i++) {
				
				

			}

		} catch (Exception ex) {

		}

	}

}
