package application;

public class Calculation {
	
	private double clonePersentage;
	
	public double calculate(int [] array) {
		
		int maximumLength=array[1];
		if(maximumLength < array[2] ){
			
			maximumLength=array[2];
			
		}
		
		 clonePersentage=( (double)(array[0]) / (double)(maximumLength) );
		 
		// System.out.println(array[0] + "    " + array[1] + "    " +array[2]+ "     " + clonePersentage+ "     " + maximumLength);
		
		return  (1.0-clonePersentage)*100.0;
	}

}
