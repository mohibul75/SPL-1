package additonalCode;

import java.util.Scanner;

public class StringInput {
	
	public static void main(String [] agrs) {
		
		String s;
		
		Scanner in = new Scanner(System.in);
		
		s=in.nextLine();
		if(s.contains("for ?\\(.*?;.*?;.*?\\)")) System.out.println(s);
	
		
	}

}
