import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * LocalDateTime t = LocalDateTime.now();
 * **TODO fully**
 * temporarily, a class to provide a text based ui to database to test the operations of storing and loading data
 * that the database subsystem provides
 * cant be called main, pretty sure the main is just meant to have static method and nothing else
 */
public class ArtataweMain {
	Database database;
	public ArtataweMain() {
		Scanner scan = new Scanner(System.in);
		while(!scan.nextLine().equals("q")) {
			String input = scan.nextLine();
			switch(input) {
				
			}
			
		}
		scan.close();
	}
}
