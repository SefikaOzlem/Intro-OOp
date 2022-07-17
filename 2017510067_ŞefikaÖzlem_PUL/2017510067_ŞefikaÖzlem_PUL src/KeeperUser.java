
public class KeeperUser extends Person {
	int value = 0;
	int rateCount = 0;
	protected String AnimalType;
	public KeeperUser(String name, String surname, Address address, String phoneNumber, int age, String gender,String animalType) {
		super(name, surname, address, phoneNumber, age, gender);
		AnimalType = animalType;}
	@Override
	public String toString() {
		return super.toString();}
	@Override
	public String Display() {
		return super.Display();}
	@Override
	public void DeleteMembership(int key) throws QueueEmpty {
		Queue temp = Menu.list.get(key);
		Queue temp2 = new Queue();
		if (key == 5) {
			KeeperUser a;
			while (!temp.isEmpty()) {
				a = (KeeperUser) temp.peek();
				if (a.getName().equalsIgnoreCase(Name) && a.getSurname().equalsIgnoreCase(Surname)
						&& a.getPhoneNumber().equalsIgnoreCase(PhoneNumber)) {
					temp.dequeue();
				} else
					temp2.enqueue(temp.dequeue());}
			while (!temp2.isEmpty()) {
				temp.enqueue(temp2.dequeue());}
			Menu.list.put(5, temp);
		}
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getRateCount() {
		return rateCount;
	}
	public void setRateCount(int rateCount) {
		this.rateCount = rateCount;
	}
	public String getAnimalType() {
		return AnimalType;
	}
	public void setAnimalType(String animalType) {
		AnimalType = animalType;
	}
}
