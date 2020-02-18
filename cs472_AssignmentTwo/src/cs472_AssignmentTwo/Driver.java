package cs472_AssignmentTwo;

import java.io.IOException;

public class Driver {

	public static void main(String[] args) throws IOException {
		
		
		Driver driver = new Driver();
		
		
		
		
		
		
		
		driver.doIt();
			
	}
	
	public void doIt() throws IOException {
		
		
		//MainMemory mainMemory = new MainMemory();
		
		CacheObject cacheObject = new CacheObject();
		
		cacheObject.displayCache();
		cacheObject.writeToFile();
		
		
		
		
		
		
	}

}
