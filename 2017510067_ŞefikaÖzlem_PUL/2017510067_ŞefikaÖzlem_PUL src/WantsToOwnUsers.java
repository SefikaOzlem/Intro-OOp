
public class WantsToOwnUsers extends Person {
	protected String AnimalType;
	protected int time=0;
	public WantsToOwnUsers(String name, String surname, Address address, String phoneNumber, int age, String gender,
			String animalType) {
		super(name, surname, address, phoneNumber, age, gender);
		AnimalType = animalType;
	}
	@Override
	public String toString() {
		return super.toString();
	}
	@Override
	public String Display() {
		return super.Display();
	}
	@Override
	public void DeleteMembership(int key) throws QueueEmpty {
		Queue temp = Menu.list.get(key);
		Queue temp2 = new Queue();
		if (key == 3) {
			WantsToOwnUsers a;
			while (!temp.isEmpty()) {
				a = (WantsToOwnUsers) temp.peek();
				if (a.getName().equalsIgnoreCase(Name) && a.getSurname().equalsIgnoreCase(Surname)
						&& a.getPhoneNumber().equalsIgnoreCase(PhoneNumber)) {
					temp.dequeue();
				} else
					temp2.enqueue(temp.dequeue());
			}
			while (!temp2.isEmpty()) {
				temp.enqueue(temp2.dequeue());
			}
			Menu.list.put(3, temp);
		}
	}
	public String getAnimalType() {
		return AnimalType;
	}
	public void setAnimalType(String animalType) {
		AnimalType = animalType;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
}
