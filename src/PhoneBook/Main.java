package PhoneBook;
import java.util.*;
import java.io.RandomAccessFile;
import java.io.EOFException;


public class Main {

	public static void main(String[] args) {
		// read file based on string name
		String filePath = "PhoneBookData.txt";
		var people = ReadFile(filePath);
		
		var phoneBook = new PhoneBook(people);
		var person1 = phoneBook.GetPeople().get(0).GetName();
		var person2 = phoneBook.GetPeople().get(1).GetName();
	}
	
	public static Vector<Person> ReadFile(String filePath) {
		Vector<Person> people = new Vector<Person>();
		try {
			// read file
			var file = new RandomAccessFile(filePath, "r");
			// parse file into Persons until end of file
			while(true) {
				try {
					var line = file.readLine();
					// split file with , delimiter
					StringTokenizer tokenizer = new StringTokenizer(line, ",");
					String name = tokenizer.nextToken().trim();
					String phoneNumber = tokenizer.nextToken().trim();
					people.add(new Person(name, phoneNumber));
				}catch(Exception e){			
					break;
				}
			}	
		}
		catch(Exception ex){
			System.exit(0);
		}	
		return people;
	}
	
}
