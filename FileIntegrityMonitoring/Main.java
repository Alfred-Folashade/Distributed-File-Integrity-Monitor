import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.FileWriter;
public class Main {

	public static void main(String[] args) throws IOException {
		


		File data = new File("data.txt");
		
		data.createNewFile();
		FileWriter writer = new FileWriter("data.txt");
		writer.append("random data");
		
		replicateData(data);
		// clean up	
		// Files.delete(Paths.get("StorageNodeA/data.txt"));
		// Files.delete(Paths.get("StorageNodeB/data.txt"));
		// Files.delete(Paths.get("StorageNodeC/data.txt")); 
				
		// Files.delete(Paths.get("StorageNodeA"));
		// Files.delete(Paths.get("StorageNodeB"));
		// Files.delete(Paths.get("StorageNodeC")); 
				
		
		
		
	}
	
	public static void replicateData(File data) throws IOException{
		Files.createDirectories(Paths.get("StorageNodeA"));
		Files.createDirectories(Paths.get("StorageNodeB"));
		Files.createDirectories(Paths.get("StorageNodeC"));
		
		Files.copy(Paths.get(data.getAbsolutePath()), Paths.get("StorageNodeA").resolve(data.getName()));
		Files.copy(Paths.get(data.getAbsolutePath()), Paths.get("StorageNodeB").resolve(data.getName()));
		Files.copy(Paths.get(data.getAbsolutePath()), Paths.get("StorageNodeC").resolve(data.getName()));
	}
	
	 public static String generateSHA256Hash(File data) throws NoSuchAlgorithmException, IOException {
		 MessageDigest digest = MessageDigest.getInstance("SHA-256");
		 byte[] dataBytes = Files.readAllBytes(Paths.get(data.getAbsolutePath()));
		 byte[] hash = digest.digest(dataBytes);
		 
		 StringBuilder hex = new StringBuilder(2 * hash.length);
		 for (byte b : hash) {
		     hex.append(String.format("%02x", b));
		 }

		 String hashString = hex.toString();
		 return hashString;
	 }

}
