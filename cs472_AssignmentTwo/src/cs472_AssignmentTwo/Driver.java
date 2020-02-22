package cs472_AssignmentTwo;

import java.io.IOException;

public class Driver {

	public static void main(String[] args) throws IOException {
		
		
		Driver driver = new Driver();
		
		
		
		
		
		
		
		driver.doIt();
			
	}
	
	public void doIt() throws IOException {
		
		
	    MainMemory mainMemory = new MainMemory();
	    
	    Instructions instructions = new Instructions("inputInstructions");
	    
	    CacheObject cacheObject = new CacheObject();
	    
	    int instructionCounter = 0;
	    
	    for(int i = 0; i < 12; i++) {
	    //for(int i = 0; i < instructions.getRequests().size(); i++) {
	    	
	    	System.out.println("(R)ead, (W)rite, or (D)isplay Cache?");
	    	
	    	System.out.println(instructions.getRequests().get(i));
	    	
	    	if(instructions.getRequests().get(i).equals("R")) {
	    		
	    		System.out.println("What address would you like to read?");
	    		
	    		System.out.println(Integer.toHexString(instructions.getAddress().get(i)));
	    		
	    		if((cacheObject.getSlotValidBit(instructions.getSlotSlotNumber(i))==1)&&cacheObject.getSlotTagAddress(instructions.getSlotSlotNumber(i))==instructions.getSlotTag(i)) {
		    		
	    			
	    			System.out.println("At that byte there is the value " + Integer.toHexString(cacheObject.getSlotDataBlock(instructions.getSlotSlotNumber(i), instructions.getSlotBlockOffset(i))) + " (Cache Hit)");

	    		}else {
	    			
	    			if(cacheObject.getSlotDirtyBit(instructions.getSlotSlotNumber(i))==1) {
	    				mainMemory.setSlotMainMemory(instructions.getAddress().get(i), instructions.getTheData().get(i));
	    				
	    			}
	    			
	    			for(int j = 0; j < 16; j++) {
	    				
	    				cacheObject.setSlotDataBlock(instructions.getSlotSlotNumber(i), j, mainMemory.getSlotMainMemory(instructions.getSlotBlockBeginAddress(i)+j));
	    				
	    			}
	    			
	    			cacheObject.setSlotTagAddress(instructions.getSlotSlotNumber(i), instructions.getSlotTag(i));
	    			cacheObject.setSlotValidBit(instructions.getSlotSlotNumber(i), 1);
	    			
	    			
		    		System.out.println("At that byte there is the value " + Integer.toHexString(cacheObject.getSlotDataBlock(instructions.getSlotSlotNumber(i), instructions.getSlotBlockOffset(i))) + " (Cache Miss)");

	    		}
	    		
	    		
	    		
	    	}else if(instructions.getRequests().get(i).equals("W")) {
	    		
	        	System.out.println("What address would you like to write to?");
	    		
	    		System.out.println(Integer.toHexString(instructions.getAddress().get(i)));
	    		
	    		System.out.println("What data would you like to write at that address?");
	    		
	    		System.out.println(Integer.toHexString(instructions.getTheData().get(i)));
	    		
	    		
	    		if((cacheObject.getSlotValidBit(instructions.getSlotSlotNumber(i))==1)&&cacheObject.getSlotTagAddress(instructions.getSlotSlotNumber(i))==instructions.getSlotTag(i)) {
		        	
	    			if(cacheObject.getSlotDirtyBit(instructions.getSlotSlotNumber(i))==1) {
	    				mainMemory.setSlotMainMemory(instructions.getAddress().get(i), instructions.getTheData().get(i));
	    				
	    			}
	    			
    				cacheObject.setSlotDataBlock(instructions.getSlotSlotNumber(i), instructions.getSlotBlockOffset(i), instructions.getTheData().get(i));
	    			cacheObject.setSlotDirtyBit(instructions.getSlotSlotNumber(i), 1);
	    			
	    			
	    			System.out.println("Value " + Integer.toHexString(cacheObject.getSlotDataBlock(instructions.getSlotSlotNumber(i), instructions.getSlotBlockOffset(i))) +  " has been written to address + address (Cache Hit)");

		        	
		        	
	    		}else {
	    			
	    			if(cacheObject.getSlotDirtyBit(instructions.getSlotSlotNumber(i))==1) {
	    				mainMemory.setSlotMainMemory(instructions.getAddress().get(i), instructions.getTheData().get(i));
	    				
	    			}
	    			
	    			for(int j = 0; j < 16; j++) {
	    				
	    				cacheObject.setSlotDataBlock(instructions.getSlotSlotNumber(i), j, mainMemory.getSlotMainMemory(instructions.getSlotBlockBeginAddress(i)+j));

	    				
	    			}
    				cacheObject.setSlotDataBlock(instructions.getSlotSlotNumber(i), instructions.getSlotBlockOffset(i), instructions.getTheData().get(i));

	    			cacheObject.setSlotDirtyBit(instructions.getSlotSlotNumber(i), 1);

	    			cacheObject.setSlotTagAddress(instructions.getSlotSlotNumber(i), instructions.getSlotTag(i));
	    			cacheObject.setSlotValidBit(instructions.getSlotSlotNumber(i), 1);
	    			
	    			
		        	System.out.println("Value " + Integer.toHexString(cacheObject.getSlotDataBlock(instructions.getSlotSlotNumber(i), instructions.getSlotBlockOffset(i))) + " has been written to address + address (Cache Miss)");

	    		}
	    		

	    		
	    		
	    		
	    	}else if(instructions.getRequests().get(i).equals("D")) {
	    		cacheObject.displayCache();
	    		
	    		
	    		
	    	}
	    	

	    	
	    	
	    	
	    }
		//cacheObject.displayCache();

	    
	    
	    
	   /* 
    	
    	
    	
    	
    	


;
    	
    	*/


	    
	    //instructions.printInstructions();
	    
	    //mainMemory.printMainMemory();
		
		//cacheObject.displayCache();
		
		//cacheObject.writeToFile("cache");
	    
	    //mainMemory.writeToFile("mainMem");		
		
		
	}
	
	public void readCache() {

		
	}
	
	public void writeCache() {
		
	}
	
	
	
	

}
