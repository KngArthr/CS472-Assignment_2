package cs472_AssignmentTwo;

import java.io.*;
import java.util.*;

public class Instructions {
	
	
	
	private ArrayList<Object> initialInstructions;
	
	private ArrayList<String> requests;
	private ArrayList<Short> address;
	private ArrayList<Short> theData;

	
	private int[] blockOffset;
	private int[] tag;
	private int[] slotNumber;
	
	private int[] blockBeginAddress;

	



	public Instructions(String fileName) {
		
		this.initialInstructions = readFile(fileName);

		this.requests = new ArrayList<String>();
		this.address = new ArrayList<Short>();
		this.theData =  new ArrayList<Short>();
		
		
	    seperateInitialInstructions(getInitialInstructions());
	    
	    
		this.blockOffset = new int[getAddress().size()];
		this.tag = new int[getAddress().size()];
		this.slotNumber = new int[getAddress().size()];
		this.blockBeginAddress = new int[getAddress().size()];

		seperateChunks();
		try {
			writeToFile("seperatedInstructions");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void seperateChunks() {
		
		for(int i = 0; i < getAddress().size(); i++) {
			
			blockOffset[i] = (getAddress().get(i) & 0x00F);
			slotNumber[i] = (getAddress().get(i) & 0x0F0) >>> 4;
			tag[i] = (getAddress().get(i)) >>> 8;
			blockBeginAddress[i] = (getAddress().get(i) & 0xFF0);
			
		}
		
		/*ystem.out.println(String.format("%-15s %-15s %-15s %-15s %-15s \r\n", "Instruction", "Tag", "Slot", "Block Offset", "Block Begin"));
			
		
		for(int i = 0; i < getAddress().size(); i++) {
			
			System.out.print(String.format("%-15s %-15s %-15s %-15s %-15s \r\n", Integer.toHexString(getAddress().get(i)), Integer.toHexString(tag[i]), Integer.toHexString(slotNumber[i]), Integer.toHexString(blockOffset[i]), Integer.toHexString(blockBeginAddress[i])));
			
			
				
		}
		*/
		
		
		
	}
	
	public void seperateInitialInstructions(ArrayList<Object> initialInstructions) {
		
		ArrayList<String> requests = new ArrayList<String>();
		ArrayList<Short> address = new ArrayList<Short>();
		ArrayList<Short> theData = new ArrayList<Short>();


		for(int i = 0; i < initialInstructions.size(); i++) {
			
			if(initialInstructions.get(i).equals("R")) {
				requests.add((String.valueOf(initialInstructions.get(i))));
				address.add(Short.parseShort((String) initialInstructions.get(i+1), 16));
				theData.add(Short.parseShort((String) "0", 16));
				i++;
				
			}else if(initialInstructions.get(i).equals("W")){
				requests.add((String.valueOf(initialInstructions.get(i))));
				address.add(Short.parseShort((String) initialInstructions.get(i+1), 16));
				theData.add(Short.parseShort((String) initialInstructions.get(i+2), 16));
				i+=2;
				
			}else if(initialInstructions.get(i).equals("D")){
				requests.add((String.valueOf(initialInstructions.get(i))));
				address.add(Short.parseShort((String) "0", 16));
				theData.add(Short.parseShort((String) "0", 16));
				
			}
			
	

			
		}
		setRequests(requests);
		
		setAddress(address);
		setTheData(theData);
	   /* System.out.println("Requests");
		for(int i = 0; i < getRequests().size(); i++) {
			
			System.out.println(getRequests().get(i));

			
		}
		
		System.out.println("Instructions");
		for(int i = 0; i < getAddress().size(); i++) {
			
			System.out.println(getAddress().get(i));

			
		}*/
	    
		

		
	}
	
	public void writeToFile(String fileName) throws IOException {
		
		File file = new File(fileName);
		
		FileWriter fileWriter = new FileWriter(file); 
		
		fileWriter.write(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s \r\n", "Request", "Address", "What Data?", "Tag", "Slot", "Block Offset", "Block Begin"));
			
		fileWriter.write(System.getProperty("line.separator"));
		
		int j = 0;
		for(int i = 0; i < getAddress().size(); i++) {
			//System.out.println(i);
			if(getRequests().get(i).equals("R")) {
				fileWriter.write(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s \r\n", getRequests().get(i), Integer.toHexString(getAddress().get(i)), Integer.toHexString(getTheData().get(i)), Integer.toHexString(tag[i]), Integer.toHexString(slotNumber[i]), Integer.toHexString(blockOffset[i]), Integer.toHexString(blockBeginAddress[i])));
				//fileWriter.write(System.getProperty("line.separator"));
				/*System.out.println(getRequests().get(i));
				System.out.println(Integer.toHexString(getAddress().get(i)));

				System.out.println(Integer.toHexString(getTheData().get(i)));

				System.out.println(Integer.toHexString(tag[i]));
				System.out.println(Integer.toHexString(slotNumber[i]));

				System.out.println(Integer.toHexString(blockOffset[i]));

				System.out.println(Integer.toHexString(blockBeginAddress[i]));*/

				
				
			}else if(getRequests().get(i).equals("W")) {
				
				fileWriter.write(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s \r\n", getRequests().get(i), Integer.toHexString(getAddress().get(i)), Integer.toHexString(getTheData().get(i)), Integer.toHexString(tag[i]), Integer.toHexString(slotNumber[i]), Integer.toHexString(blockOffset[i]), Integer.toHexString(blockBeginAddress[i])));
				//fileWriter.write(System.getProperty("line.separator"));
				
				
			}else if(getRequests().get(i).equals("D")) {
				fileWriter.write(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s \r\n", getRequests().get(i), Integer.toHexString(getAddress().get(i)), Integer.toHexString(getTheData().get(i)), Integer.toHexString(tag[i]), Integer.toHexString(slotNumber[i]), Integer.toHexString(blockOffset[i]), Integer.toHexString(blockBeginAddress[i])));
				//fileWriter.write(System.getProperty("line.separator"));
				
				
			}
			


			
				
		}
		

				
		fileWriter.flush();
		fileWriter.close();
		
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



	public ArrayList<Short> getAddress() {
		return address;
	}



	public void setAddress(ArrayList<Short> address) {
		this.address = address;
	}



	public ArrayList<Short> getTheData() {
		return theData;
	}

	public void setTheData(ArrayList<Short> theData) {
		this.theData = theData;
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
