package parseTreeImplementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CommentDelete {

	private String fileName = "";
	private String NewFileName = "D:\\codeblocks\\C Program\\input.txt";
	private Stack<Character> qu = new Stack<>();
	private Stack<Character> st = new Stack<>();
	PrintWriter output;

	public CommentDelete(String fileName) {

		this.fileName = fileName;
	}

	public String CommentFilter() {

		File file = new File(fileName);
		char ch;
		int singleSlash = 0;

		try {
			Scanner input = new Scanner(file);

			while (input.hasNext()) {

				ch = input.next().charAt(0);
				qu.push(ch);

				if (ch == '/') {

					singleSlash++;

				}

				if (ch == '/' && singleSlash != 0) {

					qu.pop();

					while (input.hasNext()) {

						ch = input.next().charAt(0);

						if (ch == '\n')
							break;
					}

					singleSlash = 0;

				}

				else {

					singleSlash = 0;

				}

			}

		} catch (FileNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		codeRetrieve();
		
		 return NewFileName;
	}

	public void codeRetrieve() {

		char ch;
		try {
			output = new PrintWriter(NewFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Scanner cin = new Scanner(System.in);

		while (qu.isEmpty() != true) {

			ch = qu.peek();
			qu.pop();

			st.push(ch);

		//	ch = (Character) null;

		}

		char newCh;
		output.flush();

		while (st.isEmpty() != true) {

			newCh = st.peek();
			st.pop();

			output.print(newCh);
	//		newCh = (Character) null;

		}

		output.close();

	}

}
