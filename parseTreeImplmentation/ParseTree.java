package parseTreeImplementation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ParseTree {

	private String code;
	private Queue<Character> codeChar = new LinkedList<Character>();
	private Queue<Character> queue = new LinkedList<Character>();
	private LinkedList<String> tree = new LinkedList<String>();
	private Stack<Character> stack = new Stack<>();

	public ParseTree(String code) {

		this.code = code;
	}

	public void addToQueue() {

		try {

			tree.add("root");

			int i;
			int size = code.length();
			for (i = 0; i < size; i++) {

				char ch = code.charAt(i);

				codeChar.add(ch);
			}

		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public void parseTreeConstruct() {

		try {

			int size = codeChar.size();
			int i;

			for (i = 0; i < size; i++) {

				char ch;
				ch = code.charAt(i);

				if (ch == '(') {

					queue.add(ch);

				}

				else if (ch == ')') {

					queue.add(ch);
				}

				else if (ch == '{') {

					queue.add(ch);
				}

				else if (ch == '}') {

					queue.add(ch);

				}

			}

		} catch (Exception ex) {

			// TODO Auto-generated catch block
			ex.printStackTrace();

		}

	}

}
