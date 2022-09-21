package PhoneBook;

public class Person {
	
	private String Name;
	private String PhoneNumber;
	
	public Person() {
		
	}
	
	public Person(String name, String phoneNumber) {
		
		this.Name = name;
		this.PhoneNumber = phoneNumber;
	}
	
	public String GetName() {
		return this.Name;
	}
	
	public String GetPhoneNumber() {
		return this.PhoneNumber;
	}
	
	 // Overriding toString() method of Object class. This method is called by the compiler by default when printing an object.
    @Override
    public String toString() {
        return this.Name;
    }
	
	// override equals method of Java objects. This method gets called by the compiler by default when comparing two objects of the same type.
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Person))
			return false;
		
		Person person = (Person) o;
		
		if(person.GetName() == this.Name && person.GetPhoneNumber() == this.PhoneNumber)
			return true;
		
		return false;
	}
}
