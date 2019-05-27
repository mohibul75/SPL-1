package NecessaryDataStructure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CommentDeletion {
	
	private String code="";
	
	public String DeleteComment(String fileName) {
		File file = new File(fileName);
		String NewFileName="source.txt";
		try {
			FileInputStream fis = new FileInputStream(file);
			char ch;
			while (fis.available() > 0) {
				ch = (char) fis.read();
				code += ch;
			}

			reWriteToFile();
			
			int i;
			FileOutputStream fout=new FileOutputStream(NewFileName);
			for(i=0 ; i<code.length() ; i++) {
				
				char c;
				c=code.charAt(i);
				fout.write(c);
			}
			
			fout.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return NewFileName;

	}
	
	public void reWriteToFile() {
		
		code=code.replaceAll("\\/\\/.*", "");
		code=code.replaceAll("\\/\\*+[^*]*\\*+(?:[^/*][^*]*\\\\*)*\\/", "");
		
	}
	

}
