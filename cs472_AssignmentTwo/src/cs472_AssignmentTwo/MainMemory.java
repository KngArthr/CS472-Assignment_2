package cs472_AssignmentTwo;

import java.util.*;
import java.io.*;

public class MainMemory {
	
	
	private short[] mainMemory;
	

	Scanner scanner = new Scanner(System.in);	
	
	public MainMemory() {
		mainMemory = new short[2048];
		
		int j = -1;
		
		for(int i = 0 ; i < 2048; i++) {
			
			j++;
			if( j > 0xFF) {
				j = 0;
			}
		
			mainMemory[i] = (short) j;
			
			//System.out.println(Integer.toHexString(i) + " gets " + Integer.toHexString(j));
		}

		
	}
	
	
	public void writeToFile(String fileName) throws IOException {
		
		File file = new File(fileName);
		
		FileWriter fileWriter = new FileWriter(file); 
		
		
		for(int k = 0; k < getMainMemory().length; k++) {
			
			fileWriter.write("Slot " + Integer.toHexString(k) + ": "+ Integer.toHexString(getMainMemory()[k]));
			fileWriter.write(System.getProperty("line.separator"));
			

			
		}
				
		fileWriter.flush();
		fileWriter.close();
		
	}
	
	public void printMainMemory() {
		

		for(int k = 0; k < getMainMemory().length; k++) {
			
			
			System.out.println("Slot " + Integer.toHexString(k) + ": "+ Integer.toHexString(getMainMemory()[k]));

			
		}
		
	}
	
	public short[] getMainMemory() {
		return mainMemory;
	}
	
	public short getSlotMainMemory(int slot) {
		return mainMemory[slot];
	}


	public void setMainMemory(short[] mainMemory) {
		this.mainMemory = mainMemory;
	}
	
	public void setSlotMainMemory(int slot, short input) {
		this.mainMemory[slot] = input;
		
	}

}
