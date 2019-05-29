package Metrics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import AstTreeImplementation.AbstructSyntaxTree;
import AstTreeImplementation.LexicalAnalayzer;

public class SWMetrics {

	private int numOfLocalVariable = 0;
	private int numOfNonLocalVariable = 0;
	private int numOfLoop = 0;
	private int numOfStatement = 0;
	private int numOfFunction = 0;
	private int numOfParameter = 0;
	private String array[] =new String [10000];
	private int index=0;
	private String fileName;
	private String code;
	

	public int getNumOfLocalVariable() {
		setNumOfLocalVariable();
		return numOfLocalVariable;
	}

	public void setNumOfLocalVariable() {
		
		int i;
		for (i = 0; i < index; i++) {

			String p="\\s*(int|double|float|char)\\s*[_a-zA-z][_a-zA-Z0-9]*(=.*)*;";

			Pattern pa = Pattern.compile(p);
			Matcher m = pa.matcher(array[i]);

			if (m.find()) {

				numOfLocalVariable++;

			}
			

		}

	}

	public int getNumOfNonLocalVariable() {
		setNumOfNonLocalVariable();
		return numOfNonLocalVariable;
	}

	public void setNumOfNonLocalVariable() {

		AbstructSyntaxTree obj = new AbstructSyntaxTree(code);

		this.numOfLocalVariable = obj.getNumberOfGlobalVariable();
		System.out.println(numOfLocalVariable);
	}

	public int getNumOfLoop() {
		setNumOfLoop();
	//	System.out.println(numOfLoop+"swmet49");
		return numOfLoop;
	}

	public void setNumOfLoop() {
		int i;
		for (i = 0; i < index; i++) {

			String p = "(while\\(\\s*.*\\s*\\)|for\\(\\s*.*\\s*;\\s*.*\\s*;\\s*.*\\s*\\))";

			Pattern pa = Pattern.compile(p);
			Matcher m = pa.matcher(array[i]);

			if (m.find()) {

				numOfLoop++;

			}
			

		}

	}

	public int getNumOfStatement() {
		setNumOfStatement();
		return numOfStatement;
	}

	public void setNumOfStatement() {
		int i;
		for (i = 0; i < index; i++) {

			String p = ".*;";

			Pattern pa = Pattern.compile(p);
			Matcher m = pa.matcher(array[i]);

			if (m.find()) {

				numOfStatement++ ;

			}

		}
	}

	public int getNumOfFunction() {
		setNumOfFunction();

		return numOfFunction;
	}

	public void setNumOfFunction() {
		
		AbstructSyntaxTree obj = new AbstructSyntaxTree(code);
		
		this.numOfFunction = obj.getNumberOfFunction();
	}

	public SWMetrics(String fileName) throws FileNotFoundException {
	
		this.fileName = fileName;
		LexicalAnalayzer obj=new LexicalAnalayzer(fileName);
		code=(String) obj.run();
		
		File file = new File(fileName);
		
		Scanner input = new Scanner(file);
		
		
		while(input.hasNext()) {
			
			array[index]=input.nextLine();
			index++;
		}
		
	}

	public int getNumOfParameter() {
		return numOfParameter;
	}

	public void setNumOfParameter(int numOfParameter) {
		this.numOfParameter = numOfParameter;
	}
	
	
	

}
