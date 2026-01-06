import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption; 
public class Main {

	public static void main(String[] args) throws IOException {
		Files.createDirectories(Paths.get("StorageNodeA"));
		Files.createDirectories(Paths.get("StorageNodeB"));
		Files.createDirectories(Paths.get("StorageNodeC"));


		File data = new File("StorageNodeA/data.txt");
		data.createNewFile();
		Files.copy(Paths.get("StorageNodeA/data.txt"), Paths.get("StorageNodeB").resolve("data.txt"));
		Files.copy(Paths.get("StorageNodeA/data.txt"), Paths.get("StorageNodeC/data.txt"));
		
		// clean up	
		Files.delete(Paths.get("StorageNodeA/data.txt"));
		Files.delete(Paths.get("StorageNodeB/data.txt"));
		Files.delete(Paths.get("StorageNodeC/data.txt")); 
				
		Files.delete(Paths.get("StorageNodeA"));
		Files.delete(Paths.get("StorageNodeB"));
		Files.delete(Paths.get("StorageNodeC")); 
				
		
		
		
	}

}
