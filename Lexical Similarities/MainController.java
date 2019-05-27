package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import AstTreeImplementation.LexicalAnalayzer;
import Metrics.SWMetrics;
import NecessaryDataStructure.CommentDeletion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class MainController {
	
	@FXML
	private Pane pane;
	
	@FXML
	private Button btn1;
	
	@FXML
	private Button btn2;
	
	@FXML
	private ListView listView;
	
	@FXML
	private ListView listView1;
	
	@FXML
	private Label lbl;
	

	@FXML
	private Label lbl1;
	

	@FXML
	private Label lbl2;
	
	private  java.io.File file;
	private String stringFromFile;
	private String stringFromFileTwo;
	private FileToString object1=new FileToString();
	private FolderToString object2=new FolderToString();
	private String [] stringFromFolder;
	private String [] fileNameOfFolder;
	private static double clonePercentage;
	private String newFileName;
	private String newFileName2;
	
	private Map <String ,String> stringFolder = new HashMap<String,String> () ;
	
	public void fileSelection(ActionEvent event) throws Exception {
		
		String fileName = null;
		
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
			CommentDeletion objectForComment=new CommentDeletion();
			
			 newFileName=objectForComment.DeleteComment(fileName);
			stringFromFile=object1.stringConverter(newFileName);
				
		}
		
	    LexicalAnalayzer astForFile1=new LexicalAnalayzer(newFileName);
	    astForFile1.run();
		
		
	}
	
	public void folderSelection(ActionEvent event) throws FileNotFoundException {
		
		String fileName = null;
		
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
				  
				  listView1.getItems().add(str);
				  
			  }
			  
			  
		}
		
		else {
			
			System.out.println("file not found ");
			
		}
		
		if(seletedFile != null) {
			CommentDeletion objectForComment=new CommentDeletion();
			
			//objectForComment.deleteComment(fileName);
			 newFileName2=objectForComment.DeleteComment(fileName);
			stringFromFileTwo=object1.stringConverter(newFileName2);
				
		}
		
	    LexicalAnalayzer astForFile2=new LexicalAnalayzer(newFileName2);
	    astForFile2.run();
		
	/*	DirectoryChooser directoryChooser = new DirectoryChooser();
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
		*/
	}
	
	public void compare() {
		
	//	int i;
	//	for( i=0 ; i<stringFromFolder.length ; i++) {
			
			int [] array = new int[3];
			
			EditDistance object3=new EditDistance();
			
		//	array[0]=object3.stringMatching(stringFromFolder[i], stringFromFile, length(stringFromFolder[i]),length(stringFromFile));
			array[0]=object3.stringMatching(stringFromFileTwo, stringFromFile, length(stringFromFileTwo),length(stringFromFile));
		//	array[1]= length(stringFromFolder[i]);
			array[1]= length(stringFromFileTwo);
			array[2]=length(stringFromFile);
			
			Calculation object4= new Calculation();
		    clonePercentage=object4.calculate(array);
			
		//	listView1.getItems().add(fileNameOfFolder[i]);
		//	listView1.getItems().add(new DecimalFormat("##.##").format(clonePercentage)+"%");
		    
		    SWMetrics metricsForFile1=new SWMetrics();
		    SWMetrics metricsForFile2=new SWMetrics();
		   
			
			Parent pane2 = null;
			try {
				pane2 = FXMLLoader.load(getClass().getClassLoader().getResource("application/Result.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			pane.getChildren().setAll(pane2);
			
	//	}
		
	}
	
	public void showResult() {
		
		lbl1.setText("Lexical Similarities");
		lbl.setText( clonePercentage+"%");
		lbl2.setText("Metrics Similaries");
		
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
