package application;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileToString {
	
	java.io.File file;

    public FileToString( ) {
        
        
    }
    
    public String stringConverter(String fileName) throws FileNotFoundException {
        
        String [] cKeyWord=new String[]{"auto","double","int","struct","break","else",
            "long","switch","case","enum","register","typedef","char","extern","return",
            "union","const","float","short","unsigned","continue","for","signed","void",
            "default","goto","sizeof","volatile","do","if","static","while"};
        
        String [] specialSymbol =new String []{"#","{}","[]","*"};
        
        String [] pungchuator= new String []{",",":",";"};
        
        
        String s1=new String ();
        s1="_";
        
        file=new  java.io.File(fileName);

        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            
            
            int i,k=0;
            String mi = input.next();
            
            if(mi.contentEquals("#define")==true || mi.contentEquals("#include")==true ) {
            	
            	continue;
            }
            
            if(mi.contentEquals("return")==true ) {
            	
            	continue;
            }
            	
           
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

        input.close();
        
       // System.out.println(s1);
        
        return s1;
    }

}
