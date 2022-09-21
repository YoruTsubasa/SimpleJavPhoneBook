package PhoneBook;
import java.util.Vector;

public class PhoneBook {
	private Vector<Person> people;
	
	public PhoneBook(){
		
	}
	
	public PhoneBook(Vector<Person> people){
		this.people = people;
		System.out.println("set");
	}
	
	// sort PhoneBook
	public Person SortPhoneBook(Vector<Person> people){
		if(people.size() < 2) { // stop condition
			return people.get(0);
		};
		
		var helperList = people;
		var smallestPerson = people.get(0);
		var personToTestAgainst = people.get(1);
		
		// if person one is alphabetically smaller, then remove person two from the list and repeat. 
		if(IsSmaller(smallestPerson.GetName(), personToTestAgainst.GetName())) {
			helperList.remove(personToTestAgainst);
			return SortPhoneBook(people);
		}
		// if person two is alphabetically smaller, then remove person one from the list and repeat. 
		if(!IsSmaller(smallestPerson.GetName(), personToTestAgainst.GetName())) {
			helperList.remove(smallestPerson);
			return SortPhoneBook(people);
		}
		
		// get next alphabetically ordered person
		people.remove(0);
		return SortPhoneBook(people);
	}
	
	//search a number
	public String FindPhoneNumber(String name) {
		System.out.println("called");
		for(int i = 0; i < people.size(); i++) {			
			if(people.get(i).GetName().equals(name)) {
				System.out.println("Found");
				return people.get(i).GetPhoneNumber();
			}
		}
		
		return "";
	}
	
	public Vector<Person>  GetPeople(){
		return this.people;
	}
	
	public static boolean IsSmaller(String personOne, String personTwo) {
		
		for(int i = 0; i < personOne.length(); i++) {
			if(personOne.charAt(i) < personTwo.charAt(i))
				return true;
			if(personOne.charAt(i) > personTwo.charAt(i)) return false;
		}
		
		// the letters aren't individually smaller but the string is shorter, so it is indeed alphabetically lower.
		if(personOne.length() < personTwo.length()) return true;
		
		// string not smaller alphabetically 
		return false;
	}

}
