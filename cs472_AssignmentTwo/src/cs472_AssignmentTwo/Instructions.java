package cs472_AssignmentTwo;

import java.io.*;
import java.util.*;

public class Instructions {
	
	
	
	private ArrayList<Object> initialInstructions;
	
	private ArrayList<String> requests;
	private ArrayList<Short> instruction;
	
	private int[] blockOffset;
	private int[] tag;
	private int[] slotNumber;
	
	private int[] blockBeginAddress;

	



	public Instructions(String fileName) {
		
		this.initialInstructions = readFile(fileName);

		this.requests = new ArrayList<String>();
		this.instruction = new ArrayList<Short>();
		
		
	    seperateInitialInstructions(getInitialInstructions());
	    
	    
		this.blockOffset = new int[getInstruction().size()];
		this.tag = new int[getInstruction().size()];
		this.slotNumber = new int[getInstruction().size()];
		this.blockBeginAddress = new int[getInstruction().size()];

		seperateChunks();
		
		
		
	}
	
	public void seperateChunks() {
		
		for(int i = 0; i < getInstruction().size(); i++) {
			
			blockOffset[i] = (getInstruction().get(i) & 0x00F);
			slotNumber[i] = (getInstruction().get(i) & 0x0F0) >>> 4;
			tag[i] = (getInstruction().get(i)) >>> 8;
			blockBeginAddress[i] = (getInstruction().get(i) & 0xFF0);
			
		}
		
		/*ystem.out.println(String.format("%-15s %-15s %-15s %-15s %-15s \r\n", "Instruction", "Tag", "Slot", "Block Offset", "Block Begin"));
			
		
		for(int i = 0; i < getInstruction().size(); i++) {
			
			System.out.print(String.format("%-15s %-15s %-15s %-15s %-15s \r\n", Integer.toHexString(getInstruction().get(i)), Integer.toHexString(tag[i]), Integer.toHexString(slotNumber[i]), Integer.toHexString(blockOffset[i]), Integer.toHexString(blockBeginAddress[i])));
			
			
				
		}
		*/
		
		
		
	}
	
	public void seperateInitialInstructions(ArrayList<Object> initialInstructions) {
		
		ArrayList<String> requests = new ArrayList<String>();
		ArrayList<Short> instruction = new ArrayList<Short>();

		
		
		for(int i = 0; i < initialInstructions.size(); i++) {
			
			if(isRequest(initialInstructions.get(i))) {
				requests.add((String.valueOf(initialInstructions.get(i))));
				
			}else {
				instruction.add(Short.parseShort((String) initialInstructions.get(i), 16));
				
				
			}
			
		}
		
		setRequests(requests);
		setInstruction(instruction);
		
	   /* System.out.println("Requests");
		for(int i = 0; i < getRequests().size(); i++) {
			
			System.out.println(getRequests().get(i));

			
		}
		
		System.out.println("Instructions");
		for(int i = 0; i < getInstruction().size(); i++) {
			
			System.out.println(getInstruction().get(i));

			
		}*/
	    
		

		
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
				
		for(int i = 0; i < getInitialInstructions().size(); i++) {
			
			System.out.println(getInitialInstructions().get(i));

			
		}
	}
	
	public boolean isRequest(Object inputLine){
		
		if(inputLine.equals("R")||inputLine.equals("D")||inputLine.equals("W")) {
			return true;
		}
		
		
		return false;
	}



	public ArrayList<Object> getInitialInstructions() {
		return initialInstructions;
	}



	public void setInitialInstructions(ArrayList<Object> instructions) {
		this.initialInstructions = instructions;
	}



	public ArrayList<String> getRequests() {
		return requests;
	}



	public void setRequests(ArrayList<String> requests) {
		this.requests = requests;
	}



	public ArrayList<Short> getInstruction() {
		return instruction;
	}



	public void setInstruction(ArrayList<Short> instruction) {
		this.instruction = instruction;
	}



	public int[] getBlockOffset() {
		return blockOffset;
	}



	public void setBlockOffset(int[] blockOffset) {
		this.blockOffset = blockOffset;
	}

	public int getSlotBlockOffset(int slot) {
		return blockOffset[slot];
	}
	
	public void setSlotBlockOffset(int slot, short input) {
		this.blockOffset[slot] = input;
		
	}


	public int[] getTag() {
		return tag;
	}



	public void setTag(int[] tag) {
		this.tag = tag;
	}
	
	public int getSlotTag(int slot) {
		return tag[slot];
	}
	
	public void setSlotTag(int slot, short input) {
		this.tag[slot] = input;
		
	}




	public int[] getSlotNumber() {
		return slotNumber;
	}



	public void setSlotNumber(int[] slotNumber) {
		this.slotNumber = slotNumber;
	}

	public int getSlotSlotNumber(int slot) {
		return slotNumber[slot];
	}
	
	public void setSlotSlotNumber(int slot, short input) {
		this.slotNumber[slot] = input;
		
	}



	public int[] getBlockBeginAddress() {
		return blockBeginAddress;
	}



	public void setBlockBeginAddress(int[] blockBeginAddress) {
		this.blockBeginAddress = blockBeginAddress;
	}
	
	
	public int getSlotBlockBeginAddress(int slot) {
		return blockBeginAddress[slot];
	}
	
	public void setSlotBlockBeginAddress(int slot, short input) {
		this.blockBeginAddress[slot] = input;
		
	}
	





	
	
	
	
	
	

}
