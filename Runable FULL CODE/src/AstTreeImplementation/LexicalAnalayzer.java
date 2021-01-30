package AstTreeImplementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import NecessaryDataStructure.CommentDeletion;

public class LexicalAnalayzer {

	private String code;
	private String[] cKeyWord = new String[] { "auto", "double", "int", "struct", "break", "else", "long", "switch",
			"case", "enum", "register", "typedef", "char", "extern", "return", "union", "const", "float", "short",
			"unsigned", "continue", "for", "signed", "void", "default", "goto", "sizeof", "volatile", "do", "if",
			"static", "while" };

	private String fileName;

	public LexicalAnalayzer(String fileName) {

		this.fileName = fileName;
	}

	public String run() {

		fileReading();
		print();
		
		return code;

	}

	public void fileReading() {

		code = "";

		File file = new File(fileName);
		String str;
		try {
			Scanner input = new Scanner(file);

			while (input.hasNextLine()) {

				str = input.nextLine();

				if ((str.contains("#include")) || (str.contains("#define"))) {
					str = null;
				}

				int i;

				if (str != null) {

					for (i = 0; i < cKeyWord.length; i++) {

						String st = cKeyWord[i];

						if (str.equals(st)) {

							str = null;
							break;
						}

					}
				}

				if (str != null) {

					for (i = 0; i < cKeyWord.length; i++) {

						String st = cKeyWord[i];

						if (str.contains(st)) {

							str = str.replaceAll(st, "");

							break;
						}

					}

				}

				if (str != null) {

					code += str;

				}
			}

			// stringCKeyWordFilter();

		} catch (FileNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		functionPrototypeFilter();
	}

	public void print() {

		// System.out.println(code);
		try {
			AbstructSyntaxTree obj4 = new AbstructSyntaxTree(code);
			obj4.addToQueue();
		} catch (Exception e) {

			System.out.println(e);
		}

	}

	public void stringCKeyWordFilter() {

		try {

			int i;

			for (i = 0; i < cKeyWord.length; i++) {

				String str = cKeyWord[i];

				if ((code.contains(str))) {

					// System.out.println(cKeyWord[i]);

					code.replaceAll(str, "");

					int indexFrom = code.indexOf(str);

					if (indexFrom != 0) {
						indexFrom -= 1;
					}

					String s = code.substring(0, indexFrom);

					int indexTo = code.indexOf(str) + str.length() - 1;

					String ss = code.substring(indexTo, str.length() - 1);

					code = "";

					// System.out.println(s);
					// System.out.println(ss);

					if (s != null) {
						code += s;
					}

					if (ss != null) {
						code += ss;
					}

				}
			}
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void functionPrototypeFilter() {

		// System.out.println(code);

		String pattern = "[_a-zA-Z]+[_a-zA-Z0-9]*\\(.*\\);";
		String string = "";

		Pattern r = Pattern.compile(pattern);

		code = code.replaceAll("\\s*[_a-zA-Z]+[_a-zA-Z0-9]*\\((\\s*[_a-zA-Z]+[_a-zA-Z0-9]*,?)*\\);", "");
		code = code.replaceAll("if", "");

		String[] arr = code.split(" ");

		for (String word : arr) {

			Matcher m = r.matcher(word);

			if (m.find()) {

			}

			else {
				string += word;
			}
		}

		code = string;

	}

	public void spiltCode() {

		String[] arr = code.split(" ");

	}

}
//[_a-zA-Z]+[a-zA-Z0-9]\(([_a-zA-Z]+[,a-zA-Z0-9]*)*\)
