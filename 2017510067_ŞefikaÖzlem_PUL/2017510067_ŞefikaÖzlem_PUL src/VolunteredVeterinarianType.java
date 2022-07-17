
public class VolunteredVeterinarianType extends Person {
	private String MailAddress;
	private String workingHours;

	public VolunteredVeterinarianType(String name, String surname, Address address, String phoneNumber, int age,
			String gender, String mailAddress, String workingHours) {
		super(name, surname, address, phoneNumber, age, gender);
		MailAddress = mailAddress;
		this.workingHours = workingHours;
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
		if (key == 1) {
			VolunteredVeterinarianType a;
			while (!temp.isEmpty()) {
				a = (VolunteredVeterinarianType) temp.peek();
				if (a.getName().equalsIgnoreCase(Name) && a.getSurname().equalsIgnoreCase(Surname)
						&& a.getPhoneNumber().equalsIgnoreCase(PhoneNumber)) {
					temp.dequeue();
				} else
					temp2.enqueue(temp.dequeue());
			}
			while (!temp2.isEmpty()) {
				temp.enqueue(temp2.dequeue());
			}
			Menu.list.put(1, temp);
		}
	}

	public String Search(String city, String town) throws QueueEmpty {//volunterveterinarian
		String temp="";
		Queue queue =Menu.list.get(4);
		Queue tempqueue=new Queue();
		NormalTypeUser a;
		while(!queue.isEmpty()) {
			a=(NormalTypeUser)queue.peek();
			if(a.getAddress().getCity().equalsIgnoreCase(city) && a.getAddress().getTown().equalsIgnoreCase(town)){
				
				temp=a.Display();
				tempqueue.enqueue(queue.dequeue());
				
			}
			else {
				tempqueue.enqueue(queue.dequeue());
			}
		}
		while(!tempqueue.isEmpty()) {
			queue.enqueue(tempqueue.dequeue());
		}
		return temp;
	}

	public String getMailAddress() {
		return MailAddress;
	}

	public void setMailAddress(String mailAddress) {
		MailAddress = mailAddress;
	}

	public String getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

}
