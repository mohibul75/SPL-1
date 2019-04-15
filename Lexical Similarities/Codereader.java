package splCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Codereader {
	
	public ArrayList<String> lineOfCode=new ArrayList<>();	
	
	public void fileReading(String fileName) {
		
		File file =new File(fileName);
		String str;
		try {
			Scanner input=new Scanner(file);
			
			while(input.hasNext()) {
				
				str=input.nextLine();
				int SIZE= str.length();
				
				if((str.contains(  "\\" )== true )) {
					
					System.out.println(2);
					
					int index=str.indexOf("\\");
					String subString=str.substring(0,index-1);
					
					System.out.println(index);
					
					str=subString;
					
				}
				
				if(str!=null)
				lineOfCode.add(str);
				str=null;
			}
			
		} catch (FileNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void printCode() {
		
		int i;
		
		for(i=0 ; i<lineOfCode.size() ; i++) {
			
			System.out.println(lineOfCode.get(i));
			
		}
	}

}
