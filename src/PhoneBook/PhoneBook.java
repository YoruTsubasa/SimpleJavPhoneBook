package PhoneBook;
import java.util.Vector;

public class PhoneBook {
	private Vector<Person> people;
	
	public PhoneBook(){
		
	}
	
	public PhoneBook(Vector<Person> people){
		this.people = people;
	}
	
	// sort PhoneBook
	public Vector<Person> SortPhoneBook(Vector<Person> people){
		
		if(people.size() < 2) { // stop condition. List has no one to compare against, so return first person.
			return people;
		};
		
		var result = new Vector<Person>(); // result to store the names
		var helperList = people;
		
		
		// find smallest person in the list
		var alphabeticallyFirst = people.get(0); 
		for(int i = 1 ; i < people.size() ; i++) 
		{
			// compare names and return true if person 1 is alphabetically smaller than person two, else false.
			if(!IsSmaller(alphabeticallyFirst.GetName(), people.get(i).GetName())) 
			{
				alphabeticallyFirst = people.get(i); // second person is alphabetically smaller
			}
		}
		
		
		helperList.remove(alphabeticallyFirst); // remove smallest person from the list, so we can find the second smallest person
		var alphabeticallySecond =  SortPhoneBook(helperList); // find the second smallest person in the list with a recursive call. Will also return the other second smallest person.
		
		result.add(alphabeticallyFirst);
		// alphabeticallySecond is a list storing the first and  second smallest person in the passed list.
		result.addAll(alphabeticallySecond);
		
		
		return result;
	}
	
	//search a number
	public String FindPhoneNumber(String name) {
		for(int i = 0 ; i < people.size() ; i++) {			
			if(people.get(i).GetName().equals(name)) {	// equals method will call the equals method defined in the class. This is the equals method of Object by default.
				return people.get(i).GetPhoneNumber(); // return if person is found
			}
		}
		
		return ""; // nothing found, return empty string
	}
	
	public Vector<Person>  GetPeople(){
		return this.people;
	}
	
	public static boolean IsSmaller(String personOne, String personTwo) {
		
		for(int i = 0 ; i < personOne.length() ; i++) { // check every character against each other
			if(personOne.charAt(i) < personTwo.charAt(i)) // check smaller first. If letter is smaller than the on in words two, it is alphabetically smaller.
				return true;
			if(personOne.charAt(i) > personTwo.charAt(i)) // if you meet a letter which is larger, the word as a whole is larger because we checked smaller first.
				return false;
		}
		
		// the letters aren't individually smaller or larger but the string is shorter, so it is indeed alphabetically lower.
		if(personOne.length() < personTwo.length()) 
			return true;
		
		// string not smaller alphabetically or shorter than name 2
		return false;
	}

}
