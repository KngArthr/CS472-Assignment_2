package cs472_AssignmentTwo;

import java.io.*;
import java.util.*;

public class Instructions {
	
	
	
	ArrayList<Object> instructions;
	
	



	public Instructions(String fileName) {
		
		
		this.instructions = readFile(fileName);
		
	}
	
	
	
	public ArrayList<Object> readFile(String inputFile){
		
		ArrayList<Object> data = new ArrayList<Object>();
		String textData;
		Scanner scanner;
		int counter = 0;
		
		try {
			File file = new File(inputFile);
			scanner = new Scanner(file);
			
			while (scanner.hasNextLine()) {
				
				textData = scanner.nextLine();

				
				data.add(textData);

				/*if(isCommand(textData)) {
					data.add(textData);
				}else {
					data.add(textData);
				}*/
				
				
				//System.out.println(data.get(counter));
	
				counter++;
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return data;
		
		
	}
	
	public void printInstructions() {
				
		for(int i = 0; i < getInstructions().size(); i++) {
			
			System.out.println(getInstructions().get(i));

			
		}
	}
	
	public boolean isCommand(String inputLine){
		
		if(inputLine.equals("R")||inputLine.equals("D")||inputLine.equals("W")) {
			return true;
		}
		
		
		return false;
	}



	public ArrayList<Object> getInstructions() {
		return instructions;
	}



	public void setInstructions(ArrayList<Object> instructions) {
		this.instructions = instructions;
	}
	





	
	
	
	
	
	

}
