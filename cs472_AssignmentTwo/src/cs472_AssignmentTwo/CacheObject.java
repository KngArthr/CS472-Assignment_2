package cs472_AssignmentTwo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CacheObject {
	
	
	private int[] validBit;
	private int[] dirtyBit;
	private int[] tagAddress;
	private short[][] dataBlock;
	private int[] cacheSlot;
	
	
	
	
	public CacheObject() {
		
		validBit = new int[16];
		dirtyBit = new int[16];
		tagAddress = new int[16];
		dataBlock = new short [16][16];
		cacheSlot = new int [16];
		
		for(int i = 0; i < cacheSlot.length; i++) {
			validBit[i] = 0;
			dirtyBit[i] = 0;
			tagAddress[i] = 0;
			cacheSlot[i] = i;
			for(int j = 0; j < dataBlock.length; j++) {
				dataBlock[i][j] = 0;

			}
		}
		
		
	}
	

	
	public void displayCache() {
		
		
		System.out.println(String.format("%-5s %-5s %-5s %-5s %-5s \r\n", "Slot", "Valid", "Dirty", "Tag", "\tData"));
			
		
		for(int i = 0; i < getCacheSlot().length; i++) {
			
			System.out.print(String.format("%-5x %-5x %-5x %-5x", getCacheSlot()[i], getValidBit()[i], getDirtyBit()[i], getTagAddress()[i]));
			
			
			for(int j = 0; j < dataBlock.length; j++) {
				
				if(j==0) {
					System.out.print(String.format("\t\t%-5x", getDataBlock()[i][j]));
					
				}else{
					System.out.print(String.format("%-5x", getDataBlock()[i][j]));

				}
				

			}
			System.out.print(String.format("\r\n", ""));
				
		}
	
		
	}
	
	public boolean isValid(int slot) {
		
		if(getValidBit()[slot] > 0) {
			return true;
		}
		
		return false;
	}
	
	public boolean isDirty(int slot) {
		
		if(getDirtyBit()[slot] > 0) {
			return true;
		}
		
		return false;
	}
	
	
	public boolean equalsTag(int inputTag, int cacheTag) {
		
		if(inputTag==cacheTag) {
			
			return true;
			
		}
		
		return false;
	}
	
	
	



	public void writeToFile(String fileName) throws IOException {
		File file = new File(fileName);
		
		FileWriter fileWriter = new FileWriter(file); 
		
		fileWriter.write(String.format("%-5s %-5s %-5s %-5s %-5s \r\n", "Slot", "Valid", "Dirty", "Tag", "\tData"));

		
		for(int i = 0; i < getCacheSlot().length; i++) {
					
					fileWriter.write(String.format("%-5x %-5x %-5x %-5x", getCacheSlot()[i], getValidBit()[i], getDirtyBit()[i], getTagAddress()[i]));			
					
					for(int j = 0; j < dataBlock.length; j++) {
						
						if(j==0) {
							fileWriter.write(String.format("\t\t%-5x", getDataBlock()[i][j]));	
							
						}else{
							fileWriter.write(String.format("%-5x", getDataBlock()[i][j]));	

						}
						
						
		
		
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
	
	public int getSlotValidBit(int slot) {
		return validBit[slot];
	}
	
	public void setSlotValidBit(int slot, short input) {
		this.validBit[slot] = input;
		
	}
	
	public int[] getDirtyBit() {
		return dirtyBit;
	}

	public void setDirtyBit(int[] dirtyBit) {
		this.dirtyBit = dirtyBit;
	}
	
	public int getSlotDirtyBit(int slot) {
		return dirtyBit[slot];
	}
	
	public void setSlotDirtyBit(int slot, short input) {
		this.dirtyBit[slot] = input;
		
	}

	public int[] getTagAddress() {
		return tagAddress;
	}

	public void setTagAddress(int[] tagAddress) {
		this.tagAddress = tagAddress;
	}
	
	public int getSlotTagAddress(int slot) {
		return tagAddress[slot];
	}
	
	public void setSlotTagAddress(int slot, short input) {
		this.tagAddress[slot] = input;
		
	}

	public short[][] getDataBlock() {
		return dataBlock;
	}

	public void setDataBlock(short[][] dataBlock) {
		this.dataBlock = dataBlock;
	}
	
	public int getDataBlock(int row, int column) {
		return dataBlock[row][column];
	}
	
	public void setDataBlock(int row, int column, short input) {
		this.dataBlock[row][column] = input;
		
	}

	public int[] getCacheSlot() {
		return cacheSlot;
	}

	public void setCacheSlot(int[] cacheSlot) {
		this.cacheSlot = cacheSlot;
	}
	
	public int getSlotCacheSlot(int slot) {
		return cacheSlot[slot];
	}
	
	public void setSlotcacheSlot(int slot, short input) {
		this.cacheSlot[slot] = input;
		
	}


}
