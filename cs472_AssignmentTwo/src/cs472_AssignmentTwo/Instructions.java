package cs472_AssignmentTwo;

import java.io.*;
import java.util.*;

public class Instructions {
	
	
	
	short[] instructions;



	public Instructions(String inputFile) {
		
		this.instructions = new short[100];
		

				
		
		
	}
	
	
	
	public ArrayList<Short> readFile(String inputFile){
		
		ArrayList<Short> data = new ArrayList<Short>();
		String textData;
		Scanner scanner;
		int counter = 0;
		
		try {
			File file = new File(inputFile);
			scanner = new Scanner(file);
			
			while (scanner.hasNextLine()) {
				textData = scanner.nextLine();
				data.add(Short.parseShort(textData));
				
				System.out.println(data);
	
				counter++;
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return data;
		
		
	}
	
	
	


	public short[] getInstructions() {
		return instructions;
	}



	public void setInstructions(short[] instructions) {
		this.instructions = instructions;
	}


	
	
	
	
	
	

}
