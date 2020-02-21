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
	    
	    
	    //instructions.printInstructions();
	    
	    //mainMemory.printMainMemory();
		
		//cacheObject.displayCache();
		
		cacheObject.writeToFile("cache");
	    
	    mainMemory.writeToFile("mainMem");		
		
		
	}

}
