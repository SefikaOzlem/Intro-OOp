import java.util.Hashtable;
import java.util.Scanner;

public class Menu {
	static Hashtable<Integer, Queue> list = new Hashtable<Integer, Queue>();
	Scanner sc = new Scanner(System.in);
	

	public void DeletMembership(int key) throws QueueEmpty {
		System.out.println("What's your name?");
		String name = sc.next();
		System.out.println("What's your surname?");
		String surname = sc.next();
		System.out.println("What is your phone number? \nE.g '05009009090'");
		String phonenumber = sc.next();
		if (list.containsKey(key)) {
			Queue temp = list.get(key);
			Queue temp2 = new Queue();
			if (key == 1)
			{
				VolunteredVeterinarianType a;
				boolean flag = false;
				while (!temp.isEmpty()) {
					a = (VolunteredVeterinarianType) temp.peek();
					if (a.getName().equalsIgnoreCase(name) && a.getSurname().equalsIgnoreCase(surname)
							&& a.getPhoneNumber().equalsIgnoreCase(phonenumber)) {
						System.out.println(a.getName() + " " + a.getSurname() + " " + a.getPhoneNumber());
						temp.dequeue();
						System.out.println("Deleted SUCCESSFULLY");
						flag = true;
					} else
						temp2.enqueue(temp.dequeue());
				}
				if (flag == false)
					System.out.println("Deletion is UNSUCCESSFUL!!!\nUSER NOT FOUND!!!");
				while (!temp2.isEmpty()) {
					temp.enqueue(temp2.dequeue());
				}
				list.put(1, temp);
			} else if (key == 2) {
				AnimalOwnerType a;
				boolean flag = false;
				while (!temp.isEmpty()) {
					a = (AnimalOwnerType) temp.peek();
					if (a.getName().equalsIgnoreCase(name) && a.getSurname().equalsIgnoreCase(surname)
							&& a.getPhoneNumber().equalsIgnoreCase(phonenumber)) {
						System.out.println(a.getName() + " " + a.getSurname() + " " + a.getPhoneNumber());
						temp.dequeue();
						System.out.println("Deleted SUCCESSFULLY");
						flag = true;
					} else
						temp2.enqueue(temp.dequeue());
				}
				if (flag == false)
					System.out.println("Deletion is UNSUCCESSFUL!!!\nUSER NOT FOUND!!!");
				while (!temp2.isEmpty()) {
					temp.enqueue(temp2.dequeue());
				}
				list.put(2, temp);
			} else if (key == 3) {
				WantsToOwnUsers a;
				Boolean flag = false;
				while (!temp.isEmpty()) {
					a = (WantsToOwnUsers) temp.peek();
					if (a.getName().equalsIgnoreCase(name) && a.getSurname().equalsIgnoreCase(surname)
							&& a.getPhoneNumber().equalsIgnoreCase(phonenumber)) {
						System.out.println(a.getName() + " " + a.getSurname() + " " + a.getPhoneNumber());
						temp.dequeue();
						flag = true;
						System.out.println("Deleted SUCCESSFULLY");
					} else
						temp2.enqueue(temp.dequeue());
				}
				if (flag == false)
					System.out.println("Deletion is UNSUCCESSFUL!!!\nUSER NOT FOUND!!!");
				while (!temp2.isEmpty()) {
					temp.enqueue(temp2.dequeue());
				}
				list.put(3, temp);
			} else if (key == 4) {
				NormalTypeUser a;
				Boolean flag = false;
				while (!temp.isEmpty()) {
					a = (NormalTypeUser) temp.peek();
					if (a.getName().equalsIgnoreCase(name) && a.getSurname().equalsIgnoreCase(surname)
							&& a.getPhoneNumber().equalsIgnoreCase(phonenumber)) {
						System.out.println(a.getName() + " " + a.getSurname() + " " + a.getPhoneNumber());
						temp.dequeue();
						flag = true;
						System.out.println("Deleted SUCCESSFULLY");
					} else
						temp2.enqueue(temp.dequeue());
				}
				if (flag == false)
					System.out.println("Deletion is UNSUCCESSFUL!!!\nUSER NOT FOUND!!!");
				while (!temp2.isEmpty()) {
					temp.enqueue(temp2.dequeue());
				}
				list.put(4, temp);
			} else if (key == 5) {
				KeeperUser a;
				Boolean flag = false;
				while (!temp.isEmpty()) {
					a = (KeeperUser) temp.peek();
					if (a.getName().equalsIgnoreCase(name) && a.getSurname().equalsIgnoreCase(surname)
							&& a.getPhoneNumber().equalsIgnoreCase(phonenumber)) {
						System.out.println(a.getName() + " " + a.getSurname() + " " + a.getPhoneNumber());
						temp.dequeue();
						flag = true;
						System.out.println("Deleted SUCCESSFULLY");
					} else
						temp2.enqueue(temp.dequeue());
				}
				if (flag == false)
					System.out.println("Deletion is UNSUCCESSFUL!!!\nUSER NOT FOUND!!!");
				while (!temp2.isEmpty()) {
					temp.enqueue(temp2.dequeue());
				}
				list.put(5, temp);
			}
		}
	}
	public void Add(int key) {
		PersonFactory b=new PersonFactory();
		Queue temp;
		if (!list.containsKey(key)) {
			temp = new Queue();
		} else
			temp = list.get(key);
		
		if (key == 1) {// Veterinarian Type		
			temp.enqueue(b.getPerson(1));
			System.out.println("Added SUCCESSFULLY");
			list.put(1, temp);
		} else if (key == 2) {// Animal Owner	
			temp.enqueue(b.getPerson(2));
			System.out.println("Added SUCCESSFULLY");
			list.put(2, temp);
		} else if (key == 3) {// WantsToOwn	
			temp.enqueue(b.getPerson(3));
			System.out.println("Added SUCCESSFULLY");
			list.put(3, temp);
		} else if (key == 4) {// Normal User
			temp.enqueue(b.getPerson(4));
			System.out.println("Added SUCCESSFULLY");
			list.put(4, temp);
		} else {// Keeper User
			temp.enqueue(b.getPerson(5));
			System.out.println("Added SUCCESSFULLY");
			list.put(5, temp);
		}
	}
	public void Screen() throws QueueEmpty {
		TxtFiles.readtxt();
		int key = 0;
		do {
			// try {
			do {
				System.out.println("Which User Type are you?");
				System.out.println("1 - Veterinarian User");
				System.out.println("2 - Animal Owner Type User");
				System.out.println("3 - Wants To Own User");
				System.out.println("4 - Normal Type User");
				System.out.println("5 - Keeper User");
				System.out.println("'-1' - For Exit");
				key = sc.nextInt();
				if (key == -1)
					break;
				if (key < 6 && key > 0)
					break;
			} while (true);
			if (key == 2 || key == 4) {
				System.out.println(" Choose what you want to do?");
				System.out.println("1- Add a new user");
				System.out.println("2- Delete a user");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					Add(key);
					break;
				case 2:
					DeletMembership(key);
					break;
				default:
					break;
				}
			} else if (key == -1)
				break;
			else if (key == 1 || key == 3 || key == 5) {
				System.out.println(" Choose what you want to do?");
				System.out.println("1- Add a new user");
				System.out.println("2- Delete a user");
				System.out.println("3- Search for a animals in your location");
				System.out.println("0 - For return to the menu");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					Add(key);
					break;
				case 2:
					DeletMembership(key);
					break;
				case 3: {
					System.out.println("What's your name?");
					String name = sc.next();
					System.out.println("What's your surname?");
					String surname = sc.next();
					search(name, surname, key);
					break;
				}
				case 0:
					break;
				default:
					break;
				}
			}
			// } catch (Exception e) {
			// }
		} while (key < 6 && key > 0 && key != -1);
		TxtFiles.writetxt();

	}

	public void search(String name, String surname, int usertype) throws QueueEmpty 
	{
		PersonFactory p=new PersonFactory();
		if (list.containsKey(usertype)) {
			Queue temp = list.get(usertype);
			Queue temp2 = new Queue();
			if (usertype == 1)
			{
				Person a=p.getPerson(usertype);
				boolean flag = false;
				while (!temp.isEmpty()) {
					a = (VolunteredVeterinarianType) temp.peek();
					if (a.getName().equalsIgnoreCase(name) && a.getSurname().equalsIgnoreCase(surname)) {
						NormalTypeUser norm;
						Queue temptemp = list.get(4);
						Queue temptemp2 = new Queue();
						while (!temptemp.isEmpty()) {
							norm = (NormalTypeUser) temptemp.peek();
							if ((a.getAddress().getCity().equalsIgnoreCase(norm.getAddress().getCity()))
									&& (a.getAddress().getTown().equalsIgnoreCase(norm.getAddress().getTown()))) {
								System.out.println(norm.Display());
								flag = true;
							}
							temptemp2.enqueue(temptemp.dequeue());
						}
						list.put(4, temptemp2);
					}
					temp2.enqueue(temp.dequeue());
				}
				if (flag == false)
					System.out.println("COULDN'T FOUND NEAR REPORTED ANIMAL");
				list.put(1, temp2);
			} else if (usertype == 3) {
				Person a=p.getPerson(usertype);
				boolean flag1 = false;
				while (!temp.isEmpty()) {
					a = (WantsToOwnUsers) temp.peek();
					if (a.getName().equalsIgnoreCase(name) && a.getSurname().equalsIgnoreCase(surname)) {
						AnimalOwnerType norm;
						Queue temptemp = list.get(2);
						Queue temptemp2 = new Queue();
						while (!temptemp.isEmpty()) {
							norm = (AnimalOwnerType) temptemp.peek();
							if ((a.getAddress().getCity().equalsIgnoreCase(norm.getAddress().getCity()))
									&& (a.getAddress().getTown().equalsIgnoreCase(norm.getAddress().getTown()))) {
								System.out.println(norm.Display());
								flag1 = true;
							}
							temptemp2.enqueue(temptemp.dequeue());
						}
						list.put(2, temptemp2);
					}
					temp2.enqueue(temp.dequeue());
				}
				if(flag1==false)
					System.out.println("ANIMAL COULD NOT FOUND");
				list.put(3, temp2);
			} else if (usertype == 5) {
				Person a=p.getPerson(usertype);
				boolean flag2=false;
				while (!temp.isEmpty()) {
					a = (KeeperUser) temp.peek();
					if (a.getName().equalsIgnoreCase(name) && a.getSurname().equalsIgnoreCase(surname)) {
						AnimalOwnerType norm;
						Queue temptemp = list.get(2);
						Queue temptemp2 = new Queue();
						while (!temptemp.isEmpty()) {
							norm = (AnimalOwnerType) temptemp.peek();
							if ((a.getAddress().getCity().equalsIgnoreCase(norm.getAddress().getCity()))
									&& (a.getAddress().getTown().equalsIgnoreCase(norm.getAddress().getTown()))) {
								System.out.println(norm.Display());
								flag2=true;}
							temptemp2.enqueue(temptemp.dequeue());
						}
						list.put(2, temptemp2);
					}
					temp2.enqueue(temp.dequeue());
				}
				if(flag2==false)
					System.out.println("ANIMAL COULD NOT FOUND");
				list.put(5, temp2);
			}
		}
	}
}