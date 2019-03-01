package application;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FolderToString {
	
	private  Scanner input;
	
	private String [] cKeyWord=new String[]{"auto","double","int","struct","break","else",
            "long","switch","case","enum","register","typedef","char","extern","return",
            "union","const","float","short","unsigned","continue","for","signed","void",
            "default","goto","sizeof","volatile","do","if","static","while"};
        
    private String [] specialSymbol =new String []{"#","{}","[]","*"};
        
    private String [] pungchuator= new String []{",",":",";"};
    
    private HashMap<String,String> str = new HashMap<String,String> () ;
    
    private String fileName;
	
	public HashMap<String,String> folderConversionToString(String folderName) throws FileNotFoundException {
		
		try {
		
        
				int j=0;
       
				File folder = new File(folderName);
				File[] listOfFiles = folder.listFiles();
       
			//	 str = new String[ listOfFiles.length];
       
				String s,s1 ="_";
       	
				for (File file : listOfFiles) {
					
					if (file.isFile()) {
               
						fileName=file.getAbsolutePath();
						File  file1=new  java.io.File(fileName);
               
						input=new Scanner(file1);
               
						while (input.hasNext()) {
                  
								int i,k=0;
								String mi = input.next();
                  
								for( i=0 ; i<cKeyWord.length ; i++){
                      
									if(mi.equals(cKeyWord[i])){
                          
										s1+="cKeyWord_";
										k++;
										break;
                          
									}
                      
								}
                  
						if(k!=0) continue;
                  
						for( i=0 ; i<specialSymbol.length ; i++){
                      
							if(mi.equals(cKeyWord[i])){
                          
								s1+="specialSymbol_";
								k++;
								break;
                          
							}
							
						}
                  
					if(k!=0) continue;
                  
					for( i=0 ; i<pungchuator.length ; i++){
                      
						if(mi.equals(cKeyWord[i])){
                          
							s1+="pungchuator_";
							k++;
							break;
                          
						}
                      
					}
                  
					if(k!=0) continue;
                  	
					s1+="$$$$$-";
                  
			   }
            }
               
           //    str[ j++ ]=s1;
					
			str.put(fileName, s1);
               
               input = null;
               s1="_";
               s=null;
           }
       
	} catch(Exception e) {
		e.printStackTrace();
	}
	
		return str;

   }

}
