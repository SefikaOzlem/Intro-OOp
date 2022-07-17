
public abstract class Person implements Iperson {
	protected String Name;
	protected String Surname;
	protected Address address;
	protected String PhoneNumber;
	protected int Age;
	protected String gender;

	public Person(String name, String surname, Address address, String phoneNumber, int age, String gender) {
		super();
		Name = name;
		Surname = surname;
		this.address = address;
		PhoneNumber = phoneNumber;
		Age = age;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [Name=" + Name + ", Surname=" + Surname + ", address=" + address + ", PhoneNumber=" + PhoneNumber
				+ ", Age=" + Age + ", gender=" + gender + "]";
	}

	@Override
	public String Display() {
		String temp="";
		temp+="Name: " + Name+"\n";
		temp+="Surname: " + Surname+"\n";
		temp+=address.display();
		temp+="Phone: " + PhoneNumber+"\n";
		temp+="Age: " + Age+"\n";
		temp+="Gender: " + gender+"\n";
		return temp;
	}

	@Override
	public abstract void DeleteMembership(int key) throws QueueEmpty;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

}

