import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption; 
public class Main {

	public static void main(String[] args) throws IOException {
		


		File data = new File("data.txt");
		data.createNewFile();
		
		
		replicateData(data);
		// clean up	
		// Files.delete(Paths.get("StorageNodeA/data.txt"));
		// Files.delete(Paths.get("StorageNodeB/data.txt"));
		// Files.delete(Paths.get("StorageNodeC/data.txt")); 
				
		// Files.delete(Paths.get("StorageNodeA"));
		// Files.delete(Paths.get("StorageNodeB"));
		// Files.delete(Paths.get("StorageNodeC")); 
				
		
		
		
	}
	
	public static void replicateData(File data) throws IOException {
		Files.createDirectories(Paths.get("StorageNodeA"));
		Files.createDirectories(Paths.get("StorageNodeB"));
		Files.createDirectories(Paths.get("StorageNodeC"));
		
		Files.copy(Paths.get(data.getAbsolutePath()), Paths.get("StorageNodeA").resolve(data.getName()));
		Files.copy(Paths.get(data.getAbsolutePath()), Paths.get("StorageNodeB").resolve(data.getName()));
		Files.copy(Paths.get(data.getAbsolutePath()), Paths.get("StorageNodeC").resolve(data.getName()));
	}

}
