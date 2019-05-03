package parseTreeImplementation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import TreeStructure.SampleData;
import TreeStructure.TreeNode;

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
	private static String globalVariable[];
	private static TreeNode<String> root;
	//private String node="node";
	private int strCount=0;

	public ParseTree(String code) {

		this.code = code;
	}

	public void addToQueue() {

		String str = "";

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
			String fun = "";

			for (j = 0; j < size; j++) {

				char ch = codeChar.peek();
				codeChar.poll();

				if (ch == '(') {

					b1++;
					fun += ch;

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
						fun += ch;

					}
				//	System.out.println(fun);
					fun = "";

				}

				if (ch == '{') {

					b3++;
					fun += ch;
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

						fun += ch;

					}

			//		System.out.println(fun);
					fun = "";

				}

				str += ch;
			}

		//	System.out.println(str);

			// parseTreeConstruct();

		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		str = str.replaceAll(";\\s*[_a-zA-Z]+[_a-zA-Z0-9]*\\)}", ";");
		str = str.replaceAll(",", ";");
	//	System.out.println(str);

		globalVariable = str.split(";");

		for (String d : globalVariable) {

			// System.out.println(d);
		}
		
		//parseTreeConstruct();
		
		TreeNode<String> treeRoot = ParseTree.parseTreeConstruct();
		for (TreeNode<String> node : treeRoot) {
			String indent = createIndent(node.getLevel());
			System.out.println(indent + node.data);
		}

	}

	public static TreeNode<String> parseTreeConstruct() {

		root = new TreeNode<String>("root");
		{
			for (String d : globalVariable) {
				
				//node=node+Integer.toString(strCount);
				TreeNode<String> node = root.addChild(d);
				{
					
					if(d.contains("=")!=false) {
						
						String [] hasEqual =d.split("=");
						
						TreeNode<String> node1=node.addChild(hasEqual[0]);
						TreeNode<String> node2=node.addChild("=");
						TreeNode<String> node3=node.addChild(hasEqual[1]);
						
					}
					
				}
			}

		}
		
		return root;

	}

	public void rawParseTreeConstruct() {

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
				//	System.out.println(st);
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
				//	System.out.println(st);
					st = "";

				}

			}

		} catch (Exception ex) {

			// TODO Auto-generated catch block
			ex.printStackTrace();

		}

	}
	
	public String createIndent(int depth) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			sb.append(' ');
		}
		return sb.toString();
	}
	
	public int  getGlobalVariableNumber() {
		
		return globalVariable.length;
		
	}

}
