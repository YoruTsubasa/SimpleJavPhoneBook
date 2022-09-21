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
		
		System.out.println(phoneBook.FindPhoneNumber("Jaap Javaan"));
		System.out.println(people); // unsorted list
		System.out.println(phoneBook.SortPhoneBook(people)); // sorted list
	}
	
	public static Vector<Person> ReadFile(String filePath) {
		Vector<Person> people = new Vector<Person>();
		try {
			// read file
			var file = new RandomAccessFile(filePath, "r");
			// parse file into Persons until end of file
			while(true) { // keep reading until end of file 
				try { // reaching EOF will throw an exception if you use RAF, so catch it and exit the loop		
					var line = file.readLine(); // read entire line in file
					// split file with , delimiter
					StringTokenizer tokenizer = new StringTokenizer(line, ",");
					String name = tokenizer.nextToken().trim(); // trim is used to get rid of all the useless whitespace surrounding a name
					String phoneNumber = tokenizer.nextToken().trim();
					people.add(new Person(name, phoneNumber)); // add split people to the list
				}catch(Exception e){ 	
					break;
				}
			}	
		}
		catch(Exception ex){ // exit program if file fails to read
			System.exit(0);
		}	
		return people;
	}
	
}
