
public class AnimalOwnerType extends Person {
	protected int OwnerType;
	protected boolean flag;
	protected int HowManyDays;
	protected int HowManyHours;
	protected String AnimalType;

	public AnimalOwnerType(String name, String surname, Address address, String phoneNumber, int age, String gender,
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
		if (key == 2) {
			AnimalOwnerType a;
			while (!temp.isEmpty()) {
				a = (AnimalOwnerType) temp.peek();
				if (a.getName().equalsIgnoreCase(Name) && a.getSurname().equalsIgnoreCase(Surname)
						&& a.getPhoneNumber().equalsIgnoreCase(PhoneNumber)) {
					temp.dequeue();
				} else
					temp2.enqueue(temp.dequeue());
			}
			while (!temp2.isEmpty()) {
				temp.enqueue(temp2.dequeue());
			}
			Menu.list.put(2, temp);
		}
	}
	public void rate(KeeperUser k, int value) {
		int tempScore = k.getValue() * k.getRateCount();
		tempScore += value;
		k.setRateCount(k.getRateCount() + 1);
		tempScore = tempScore / k.getRateCount();
		k.setValue(tempScore);
	}
	public String Search(String animalType, boolean flag, Address address) throws QueueEmpty {// true permanent;false temporary
		String temp = "";
		if (flag = false) {
			Queue queue = Menu.list.get(5);
			Queue tempqueue = new Queue();
			KeeperUser a;
			while (!queue.isEmpty()) {
				a = (KeeperUser) queue.peek();
				if (a.getAnimalType().equalsIgnoreCase(animalType) && a.getAddress().equals(address)) {

					temp = a.Display();
					tempqueue.enqueue(queue.dequeue());

				} else {
					tempqueue.enqueue(queue.dequeue());
				}
			}
			while (!tempqueue.isEmpty()) {
				queue.enqueue(tempqueue.dequeue());
			}
		} else {
			Queue queue = Menu.list.get(3);
			Queue tempqueue = new Queue();
			WantsToOwnUsers a;
			while (!queue.isEmpty()) {
				a = (WantsToOwnUsers) queue.peek();
				if (a.getAnimalType().equalsIgnoreCase(animalType) && a.getAddress().equals(address)) {

					temp = a.Display();
					tempqueue.enqueue(queue.dequeue());

				} else {
					tempqueue.enqueue(queue.dequeue());
				}
			}
			while (!tempqueue.isEmpty()) {
				queue.enqueue(tempqueue.dequeue());
			}
		}
		return temp;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public int getHowManyDays() {
		return HowManyDays;
	}
	public void setHowManyDays(int howManyDays) {
		HowManyDays = howManyDays;
	}
	public int getHowManyHours() {
		return HowManyHours;
	}
	public void setHowManyHours(int howManyHours) {
		HowManyHours = howManyHours;
	}
	public int getOwnerType() {
		return OwnerType;
	}
	public void setOwnerType(int ownerType) {
		OwnerType = ownerType;
	}
	public String getAnimalType() {
		return AnimalType;
	}
	public void setAnimalType(String animalType) {
		AnimalType = animalType;
	}
}
