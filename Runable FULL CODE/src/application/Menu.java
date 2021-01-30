package application;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;

public class Menu {

	@FXML
	private AnchorPane pane1;
	
	@FXML
	private Button btn1;
	
	@FXML
	private ListView listView1;
	
	private double resultArray[][]=new double[1000][1000];
	
	private  java.io.File file;

	private FileToString object1=new FileToString();
	private FolderToString object2=new FolderToString();
	private String [] stringFromFolder;
	private String [] fileNameOfFolder;
	private Map <String ,String> stringFolder = new HashMap<String,String> () ;
	
	public void fileToFile() {
		
		Parent pane2 = null;
		try {
			pane2 = FXMLLoader.load(getClass().getClassLoader().getResource("application/Main.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pane1.getChildren().setAll(pane2);
	}
	
	public void workOfFolder() throws IOException {

		DirectoryChooser directoryChooser = new DirectoryChooser();
		File selectedDirectory = directoryChooser.showDialog(null);

		String folderName = selectedDirectory.getAbsolutePath();

		if (selectedDirectory != null) {

			listView1.getItems().add(selectedDirectory.getAbsolutePath());
		}

		stringFolder = object2.folderConversionToString(folderName);

		stringFromFolder = new String[stringFolder.size()];
		fileNameOfFolder = new String[stringFolder.size()];

		int number = 0;

		Set<Entry<String, String>> st = stringFolder.entrySet();

		for (Entry<String, String> me : st) {
			fileNameOfFolder[number] = me.getKey();
			stringFromFolder[number] = me.getValue();

			number++;
		}

		int i, j;
		for (i = 0; i < stringFromFolder.length; i++) {

			String stringFromFile = stringFromFolder[i];

			for (j = 0; j < stringFromFolder.length; j++) {

				int[] array = new int[3];

				EditDistance object3 = new EditDistance();

				array[0] = object3.stringMatching(stringFromFolder[j], stringFromFile, length(stringFromFolder[j]),
						length(stringFromFile));
				// array[0]=object3.stringMatching(stringFromFileTwo, stringFromFile,
				// length(stringFromFileTwo),length(stringFromFile));
				array[1] = length(stringFromFolder[j]);
				// array[1]= length(stringFromFileTwo);
				array[2] = length(stringFromFile);

				Calculation object4 = new Calculation();
				resultArray[i][j] = object4.calculate(array);
				

			}

		}
		
		File csvFile = new File("result.csv");  
		if (csvFile.isFile()) {  
			listView1.getItems().add("CSV FIlE   IS CREATED");
		}
		
		else  listView1.getItems().add("CSV FIlE IS  NOT CREATED");
		
		FileWriter csvWriter = new FileWriter("result.csv");

		for (i = 0; i < stringFromFolder.length; i++) {

			for (j = 0; j < stringFromFolder.length; j++) {

				csvWriter.append(String.valueOf(resultArray[i][j]));
				
				if(j!= stringFromFolder.length-1)
				{
					csvWriter.append(",");
				}

			}
			
			csvWriter.append("\n");
		}
		
		csvWriter.close();
	}
	
	public void folder() {
		
		Parent pane2 = null;
		try {
			pane2 = FXMLLoader.load(getClass().getClassLoader().getResource("application/folder.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pane1.getChildren().setAll(pane2);
		
	}
	
	public  void astVsua() {
		
		
	}
	


public int length (String str) {
        
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
