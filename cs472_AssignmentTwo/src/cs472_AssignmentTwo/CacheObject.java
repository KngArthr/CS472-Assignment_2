package cs472_AssignmentTwo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CacheObject {
	
	
	private int[] validBit;
	private int[] tagAddress;
	private short[][] dataBlock;
	private int[] cacheSlot;
	
	
	
	public CacheObject() {
		
		validBit = new int[16];
		tagAddress = new int[16];
		dataBlock = new short [16][16];
		cacheSlot = new int [16];
		
		for(int i = 0; i < cacheSlot.length; i++) {
			validBit[i] = 0;
			tagAddress[i] = 0;
			cacheSlot[i] = i;
			for(int j = 0; j < dataBlock.length; j++) {
				dataBlock[i][j] = 0;

			}
		}
		
		
	}
	
	public boolean isValid(int slot) {
		
		if(getValidBit()[slot] > 0) {
			return true;
		}
		
		return false;
	}
	
	
	
	public void displayCache() {
		
		
		System.out.println(String.format("%-5s %-5s %-5s %-5s \r\n", "Slot", "Valid", "Tag", "\tData"));
			
		
		for(int i = 0; i < getCacheSlot().length; i++) {
			
			System.out.print(String.format("%-5x %-5x %-5x", getCacheSlot()[i], getValidBit()[i], getTagAddress()[i]));
			
			
			for(int j = 0; j < dataBlock.length; j++) {
				
				
				System.out.print(String.format("\t%-5x", getDataBlock()[i][j]));

			}
			System.out.print(String.format("\r\n", ""));
				
		}
	
		
	}
	public void writeToFile() throws IOException {
		File file = new File("C:\\Users\\kazim\\OneDrive\\Documents\\BU MET\\Spring 2020\\CS472\\Project 2\\Test\\testFile.txt");
		
		FileWriter fileWriter = new FileWriter(file); 
		
		fileWriter.write(String.format("%-5s %-5s %-5s %-5s \r\n", "Slot", "Valid", "Tag", "\tData"));

		
		for(int i = 0; i < getCacheSlot().length; i++) {
					
					fileWriter.write(String.format("%-5x %-5x %-5x", getCacheSlot()[i], getValidBit()[i], getTagAddress()[i]));			
					
					for(int j = 0; j < dataBlock.length; j++) {
						
						fileWriter.write(String.format("\t%-5x", getDataBlock()[i][j]));			
		
					}
					fileWriter.write(String.format("\r\n", ""));	
						
				}
				
				fileWriter.flush();
				fileWriter.close();
				
		
	}
	
	
	public int[] getValidBit() {
		return validBit;
	}

	public void setValidBit(int[] validBit) {
		this.validBit = validBit;
	}

	public int[] getTagAddress() {
		return tagAddress;
	}

	public void setTagAddress(int[] tagAddress) {
		this.tagAddress = tagAddress;
	}

	public short[][] getDataBlock() {
		return dataBlock;
	}

	public void setDataBlock(short[][] dataBlock) {
		this.dataBlock = dataBlock;
	}

	public int[] getCacheSlot() {
		return cacheSlot;
	}

	public void setCacheSlot(int[] cacheSlot) {
		this.cacheSlot = cacheSlot;
	}


}
