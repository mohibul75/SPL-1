package application;

public class Calculation {
	
	private double clonePersentage;
	
	public double calculate(int [] array) {
		
		
		 clonePersentage=((array[1]+array[2])-array[0])/(array[1]+array[2]);
		
		return  clonePersentage*100;
	}

}
