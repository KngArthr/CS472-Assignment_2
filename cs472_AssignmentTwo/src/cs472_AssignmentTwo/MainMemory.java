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
		try {
			writeArrayToFile(mainMemory);
		} catch (IOException e) {
			// TODO Auto-generated catch block'
			System.out.println("Errornesss");
			e.printStackTrace();
		}
		
	}
	
	
	public void writeArrayToFile(short[] array) throws IOException {
		
		File file = new File("C:\\Users\\kazim\\OneDrive\\Documents\\BU MET\\Spring 2020\\CS472\\Project 2\\Test\\testFile.txt");
		
		FileWriter fileWriter = new FileWriter(file); 
		
		
		for(int k = 0; k < array.length; k++) {
			
			fileWriter.write("Slot " + Integer.toHexString(k) + ": "+ array[k]);
			fileWriter.write(System.getProperty("line.separator"));
			
			System.out.println("Slot " + Integer.toHexString(k) + ": "+ Integer.toHexString(array[k]));

			
		}
				
		fileWriter.flush();
		fileWriter.close();
		
	}
	
	public short[] getMainMemory() {
		return mainMemory;
	}


	public void setMainMemory(short[] mainMemory) {
		this.mainMemory = mainMemory;
	}

}
