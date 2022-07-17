
public class NormalTypeUser extends Person {

	public NormalTypeUser(String name, String surname, Address address, String phoneNumber, int age, String gender) {
		super(name, surname, address, phoneNumber, age, gender);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public String Display() {
		String temp="";
		temp+="Name: " + Name+"\n";
		temp+="Surname: " + Surname+"\n";
		temp+=address.displayNormalType();
		temp+="Phone: " + PhoneNumber+"\n";
		temp+="Age: " + Age+"\n";
		temp+="Gender: " + gender+"\n";
		return temp;
	}

	@Override
	public void DeleteMembership(int key) throws QueueEmpty {
		Queue temp = Menu.list.get(key);
		Queue temp2 = new Queue();
		if (key == 4) {
			NormalTypeUser a;
			while (!temp.isEmpty()) {
				a = (NormalTypeUser) temp.peek();
				if (a.getName().equalsIgnoreCase(Name) && a.getSurname().equalsIgnoreCase(Surname)
						&& a.getPhoneNumber().equalsIgnoreCase(PhoneNumber)) {
					temp.dequeue();
				} else
					temp2.enqueue(temp.dequeue());
			}
			while (!temp2.isEmpty()) {
				temp.enqueue(temp2.dequeue());
			}
			Menu.list.put(4, temp);
		}
	}

}

