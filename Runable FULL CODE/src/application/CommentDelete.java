package application;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CommentDelete {
	
	private  java.io.File file;
	private String stringFromFile;
	//private String fileName;
	
	public void deleteComment(String fileName) throws Exception {
		
		  file=new  java.io.File(fileName);
		
		  Scanner input = new Scanner(file);
		  
		  while (input.hasNext()) {
			  
			  int c;
			  char ch;
			  c=input.nextInt();

			  ch=(char)c;
			  System.out.print(ch);
			  
		//	  listView.getItems().add(str);
			  
		  }
	}

}
