package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class MainController {
	
	@FXML
	private Button btn1;
	
	@FXML
	private Button btn2;
	
	@FXML
	private ListView listView;
	
	@FXML
	private ListView listView1;
	
	private String fileName;
	
	private  java.io.File file;
	private String stringFromFile;
	private FileToString object1=new FileToString();
	private FolderToString object2=new FolderToString();
	private String [] stringFromFolder;
	private String [] fileNameOfFolder;
	
	private Map <String ,String> stringFolder = new HashMap<String,String> () ;
	
	public void fileSelection(ActionEvent event) throws FileNotFoundException {
		
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("C source file", "*.c")
				,new FileChooser.ExtensionFilter("C source file", "*.C")
				,new FileChooser.ExtensionFilter("Header file", "*.h"));
		
		File seletedFile = fc.showOpenDialog(null);
		
		if(seletedFile != null) {
			
			fileName= seletedFile.getAbsolutePath();
			
			file=new  java.io.File(fileName);
			
			  Scanner input = new Scanner(file);
			  
			  while (input.hasNext()) {
				  
				  String str;
				  
				  str=input.nextLine();
				  
				  listView.getItems().add(str);
				  
			  }
			  
			  
		}
		
		else {
			
			System.out.println("file not found ");
			
		}
		
		if(seletedFile != null) {
			
			stringFromFile=object1.stringConverter(fileName);
				
		}
		
		
	}
	
	public void folderSelection(ActionEvent event) throws FileNotFoundException {
		
		
		DirectoryChooser directoryChooser = new DirectoryChooser();
		File selectedDirectory = directoryChooser.showDialog(null);
		
		String folderName=selectedDirectory.getAbsolutePath();
		
		if(selectedDirectory != null) {
			
			listView1.getItems().add(selectedDirectory.getAbsolutePath());
		}
		
		stringFolder=object2.folderConversionToString(folderName);
		
		stringFromFolder=new String [stringFolder.size()];
		fileNameOfFolder=new String [stringFolder.size()];
		
		int number=0;
		
		Set<Entry<String, String>> st = stringFolder.entrySet(); 

		for (Entry<String, String> me:st) 
		{ 
			fileNameOfFolder[number]=me.getKey(); 
			stringFromFolder[number]=me.getValue(); 
			
			number++;
		} 
		
	}
	
	public void compare() {
		
		int i;
		for( i=0 ; i<stringFromFolder.length ; i++) {
			
			int [] array = new int[3];
			
			EditDistance object3=new EditDistance();
			
			array[0]=object3.stringMatching(stringFromFolder[i], stringFromFile, length(stringFromFolder[i]),length(stringFromFile));
			array[1]= length(stringFromFolder[i]);
			array[2]=length(stringFromFile);
			
			Calculation object4= new Calculation();
			double clonePercentage=object4.calculate(array);
			
			listView1.getItems().add(fileNameOfFolder[i]);
			listView1.getItems().add(clonePercentage);
			
		}
		
	}
	
public int length(String str){
        
        str+='\0';
        int i;
        int len = 0;
        
        for( i=0 ;  ; i++)
        {
            //char ss= str.charAt(i);
            
            if( str.charAt(i) != '\0' ){
               
                len++;
            } 
            
            else {
                
                break;
            }
            
        }
  
        return len;
    }

}
