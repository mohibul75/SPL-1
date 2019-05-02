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
	private int fristBracketOpen = 0;
	private int fristBracketClose = 0;
	private int secoundBracketOpen = 0;
	private int secoundBracketClose = 0;
	private String globalVariable[];

	public ParseTree(String code) {

		this.code = code;
	}

	public void addToQueue() {
		
		String str="";

		try {

			tree.add("root");

			int i;
			int size = code.length();
			for (i = 0; i < size; i++) {

				char ch = code.charAt(i);

				if (ch == '(') {

					fristBracketOpen++;
				}

				if (ch == ')') {

					fristBracketClose++;
				}

				if (ch == '{') {

					secoundBracketOpen++;

				}

				if (ch == '}') {

					secoundBracketClose++;
				}

				codeChar.add(ch);
			}

			int j;
			int cS = codeChar.size();
			 str = "";// this string is for global variable
			int b1 = 0, b2 = 0, b3 = 0, b4 = 0;
			// b1=fristBracketOpen
			// b2=fristBracketClose
			// b3=secoundBracketOpen
			// b4=secoundBracketClose
			String fun="";

			for (j = 0; j < size; j++) {

				char ch = codeChar.peek();
				codeChar.poll();

				if (ch == '(') {

					b1++;
					fun+=ch;

					while (b1 != b2) {

						ch = codeChar.peek();
						codeChar.poll();
						j++;

						if (ch == '(') {
							b1++;
						}

						if (ch == ')') {
							b2++;
						}
						fun+=ch;

					}
					System.out.println(fun);
					fun="";
					
				}

					if (ch == '{') {

						b3++;
						fun+=ch;
						while (b3 != b4) {

							ch = codeChar.peek();
							codeChar.poll();
							j++;

							if (ch == '{') {
								b3++;
							}

							if (ch == '}') {
								b4++;
							}
							
							fun+=ch;

						}
						
						System.out.println(fun);
						fun="";

					}
					
					str+=ch;
				}
				
				
			
			System.out.println(str);
			

			// parseTreeConstruct();

		} 
		catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		str = str.replaceAll(";\\s*[_a-zA-Z]+[_a-zA-Z0-9]*\\)}", ";");
		System.out.println(str);
		
		 globalVariable = str.split(";");
			
			for(String d : globalVariable) {
				
				System.out.println(d);
			}

	}

	public void parseTreeConstruct() {

		try {

			int size = codeChar.size();
			int i;

			String st = "";

			for (i = 0; i < size - 2; i++) {

				char ch;
				ch = codeChar.peek();
				codeChar.poll();

				if (ch != ';') {
					st += ch;
				}

				else {
					System.out.println(st);
					st = "";
				}

				if (ch == '{') {

					ch = codeChar.peek();
					codeChar.poll();

					while (ch != '}') {

						st += ch;
						ch = codeChar.peek();
						codeChar.poll();

					}
					System.out.println(st);
					st = "";
				}

				if (ch == '(') {

					ch = codeChar.peek();
					codeChar.poll();

					while (ch != ')') {

						st += ch;
						ch = codeChar.peek();
						codeChar.poll();

					}
					System.out.println(st);
					st = "";

				}

			}

		} catch (Exception ex) {

			// TODO Auto-generated catch block
			ex.printStackTrace();

		}

	}

}
