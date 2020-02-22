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
	    
	    for(int i = 0; i < instructions.getRequests().size(); i++) {
	    	
	    	System.out.println("(R)ead, (W)rite, or (D)isplay Cache?");
	    	
	    	System.out.println(instructions.getRequests().get(i));
	    	
	    	if(instructions.getRequests().get(i).equals("R")) {
	    		
	    		System.out.println("What address would you like to read?");
	    		
	    		System.out.println(instructions.getInstruction());
	    		
	    		if(cacheObject.isValid(cacheObject.getSlotValidBit(i))&&cacheObject.getSlotTagAddress(i)==instructions.getSlotTag(i)) {
	    			
	    		}
	    		
	    		
	    		System.out.println("At that byte there is the value + data + hit/miss");

	    		
	    		
	    		
	    	}else if(instructions.getRequests().get(i).equals("W")) {

	    		
	    		
	    		
	    	}else if(instructions.getRequests().get(i).equals("D")) {
	    		cacheObject.displayCache();
	    		
	    		
	    		
	    	}
	    	
	    	
	    	
	    	
	    }
	    
	    
	    
	   /* 
    	
    	
    	
    	
    	
    	System.out.println("Value + data + has been written to address + address");

    	System.out.println("What address would you like to write to?");
    	
    	System.out.println("What data would you like to write at that address?");*/


	    
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
