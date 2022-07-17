import java.io.*;
import java.util.*;

public class TxtFiles {

	public static void writetxt() throws QueueEmpty {
		FileWriter fw = null;
		File file = null;
		String line = "";
		Queue temp = new Queue();
		Queue temp2 = new Queue();
		try {
			file = new File("Voluntered.txt");
			if (!file.exists())
				file.createNewFile();
			fw = new FileWriter(file);
			if (Menu.list.containsKey(1)) {
				temp = Menu.list.get(1);
				VolunteredVeterinarianType a;
				while (!temp.isEmpty()) {
					a = (VolunteredVeterinarianType) temp.dequeue();
					String adres = a.address.getCity() + "," + a.address.getTown() + "," + a.address.getStreet() + ","
							+ a.address.getDoorNumber() + "," + a.address.getFlatNumber();
					line = a.Name + ";" + a.Surname + ";" + adres + ";" + a.PhoneNumber + ";" + a.Age + ";" + a.gender
							+ ";" + a.getMailAddress() + ";" + a.getWorkingHours()+"\n";
					fw.write(line);
					fw.flush();
					temp2.enqueue(a);
				}
				Menu.list.put(1, temp2);
				while (!temp2.isEmpty()) {
					temp2.dequeue();
				}
			}
			file = new File("AnimalOwner.txt");
			if (!file.exists())
				file.createNewFile();
			fw = new FileWriter(file);
			if (Menu.list.containsKey(2)) {
				temp = Menu.list.get(2);
				AnimalOwnerType b;
				line = "";
				while (!temp.isEmpty()) {
					b = (AnimalOwnerType) temp.dequeue();
					String adres = b.address.getCity() + "," + b.address.getTown() + "," + b.address.getStreet() + ","
							+ b.address.getDoorNumber() + "," + b.address.getFlatNumber();
					line = b.Name + ";" + b.Surname + ";" + adres + ";" + b.PhoneNumber + ";" + b.Age + ";" + b.gender
							+ ";" + b.AnimalType + ";" + b.OwnerType + ";" + b.flag + ";" + b.HowManyDays + ";"
							+ b.HowManyHours+"\n";
					fw.write(line);
					fw.flush();
					temp2.enqueue(b);
				}
				Menu.list.put(2, temp2);
				while (!temp2.isEmpty()) {
					temp2.dequeue();
				}
			}

			file = new File("WantsToOwner.txt");
			if (!file.exists())
				file.createNewFile();
			fw = new FileWriter(file);
			if (Menu.list.containsKey(3)) {
				temp = Menu.list.get(3);
				WantsToOwnUsers c;
				line = "";
				while (!temp.isEmpty()) {
					c = (WantsToOwnUsers) temp.dequeue();
					String adres = c.address.getCity() + "," + c.address.getTown() + "," + c.address.getStreet() + ","
							+ c.address.getDoorNumber() + "," + c.address.getFlatNumber();
					line = c.Name + ";" + c.Surname + ";" + adres + ";" + c.PhoneNumber + ";" + c.Age + ";" + c.gender
							+ ";" + c.AnimalType + ";" + c.time+"\n";
					fw.write(line);
					fw.flush();
					temp2.enqueue(c);
				}
				Menu.list.put(3, temp2);
				while (!temp2.isEmpty()) {
					temp2.dequeue();
				}
			}
			file = new File("NormalTypeUser.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			fw = new FileWriter(file);
			if (Menu.list.containsKey(4)) {
				temp = Menu.list.get(4);
				NormalTypeUser d;
				line = "";
				int count=0;
				while (!temp.isEmpty()) {
					d = (NormalTypeUser) temp.dequeue();
					String adres = d.address.getCity() + "," + d.address.getTown() + "," + d.address.getStreet();
					line = d.Name + ";" + d.Surname + ";" + adres + ";" + d.PhoneNumber + ";" + d.Age + ";" + d.gender+"\n";
					fw.write(line);
					fw.flush();
					temp2.enqueue(d);
					count++;
				}
				Menu.list.put(4, temp2);
				while (!temp2.isEmpty()) {
					temp2.dequeue();
				}
			}
			file = new File("KeeperUser.txt");
			if (!file.exists())
				file.createNewFile();
			fw = new FileWriter(file);
			if (Menu.list.containsKey(5)) {
				temp = Menu.list.get(5);
				KeeperUser e;
				line = "";
				while (!temp.isEmpty()) {
					e = (KeeperUser) temp.dequeue();
					String adres = e.address.getCity() + "," + e.address.getTown() + "," + e.address.getStreet() + ","
							+ e.address.getDoorNumber() + "," + e.address.getFlatNumber();
					line = e.Name + ";" + e.Surname + ";" + adres + ";" + e.PhoneNumber + ";" + e.Age + ";" + e.gender
							+ ";" + e.AnimalType + ";" + e.value + ";" + e.rateCount+"\n";
					fw.write(line);
					fw.flush();
					temp2.enqueue(e);
				}
				Menu.list.put(5, temp2);
				while (!temp2.isEmpty()) {
					temp2.dequeue();
				}
			}

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void readtxt() throws QueueEmpty {
		Queue temp1 = new Queue();
		Queue temp2 = new Queue();
		Queue temp3 = new Queue();
		Queue temp4 = new Queue();
		Queue temp5 = new Queue();
		try {
			FileReader reader = new FileReader("Voluntered.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] bos = line.split(";");
				String[] dene = bos[2].split(",");
				Address den=new Address.AddressBuilder(dene[0], dene[1], dene[2])
						.withOptionalDoorNumber(Integer.parseInt(dene[3]))
						.withOptionalFlatNumber(Integer.parseInt(dene[4]))
						.buildAddress();
			
				VolunteredVeterinarianType a = new VolunteredVeterinarianType(bos[0], bos[1], den, bos[3],
						Integer.parseInt(bos[4]), bos[5], bos[6], bos[7]);
				temp1.enqueue(a);
			}
			Menu.list.put(1, temp1);
			reader = new FileReader("AnimalOwner.txt");
			bufferedReader = new BufferedReader(reader);
			while ((line = bufferedReader.readLine()) != null) {
				String[] bos = line.split(";");
				String[] dene = bos[2].split(",");
				Address den=new Address.AddressBuilder(dene[0], dene[1], dene[2])
						.withOptionalDoorNumber(Integer.parseInt(dene[3]))
						.withOptionalFlatNumber(Integer.parseInt(dene[4]))
						.buildAddress();
				AnimalOwnerType a = new AnimalOwnerType(bos[0], bos[1], den, bos[3], Integer.parseInt(bos[4]), bos[5],
						bos[6]);
				a.setOwnerType(Integer.parseInt(bos[7]));
				a.setFlag(Boolean.parseBoolean(bos[8]));
				a.setHowManyDays(Integer.parseInt(bos[9]));
				a.setHowManyHours(Integer.parseInt(bos[10]));
				temp2.enqueue(a);
			}
			Menu.list.put(2, temp2);
			//while (!temp2.isEmpty()) {
			//	temp2.dequeue();
			//}

			reader = new FileReader("WantsToOwner.txt");
			bufferedReader = new BufferedReader(reader);
			while ((line = bufferedReader.readLine()) != null) {
				String[] bos = line.split(";");
				String[] dene = bos[2].split(",");
				Address den=new Address.AddressBuilder(dene[0], dene[1], dene[2])
						.withOptionalDoorNumber(Integer.parseInt(dene[3]))
						.withOptionalFlatNumber(Integer.parseInt(dene[4]))
						.buildAddress();
				WantsToOwnUsers a = new WantsToOwnUsers(bos[0], bos[1], den, bos[3], Integer.parseInt(bos[4]), bos[5],
						bos[6]);
				a.setTime(Integer.parseInt(bos[7]));
				temp3.enqueue(a);
			}
			Menu.list.put(3, temp3);
			/*while (!temp.isEmpty()) {
				temp.dequeue();
			}*/
			reader = new FileReader("NormalTypeUser.txt");
			bufferedReader = new BufferedReader(reader);
			while ((line = bufferedReader.readLine()) != null) {
				String[] bos = line.split(";");
				String[] dene = bos[2].split(",");
				Address den=new Address.AddressBuilder(dene[0], dene[1], dene[2])
						.buildAddress();
				NormalTypeUser a = new NormalTypeUser(bos[0], bos[1], den, bos[3], Integer.parseInt(bos[4]), bos[5]);
				temp4.enqueue(a);
			}
			Menu.list.put(4, temp4);
			/*while (!temp4.isEmpty()) {
				temp4.dequeue();
			}*/
			reader = new FileReader("KeeperUser.txt");
			bufferedReader = new BufferedReader(reader);
			while ((line = bufferedReader.readLine()) != null) {
				String[] bos = line.split(";");
				String[] dene = bos[2].split(",");
				Address den=new Address.AddressBuilder(dene[0], dene[1], dene[2])
						.withOptionalDoorNumber(Integer.parseInt(dene[3]))
						.withOptionalFlatNumber(Integer.parseInt(dene[4]))
						.buildAddress();
				KeeperUser a = new KeeperUser(bos[0], bos[1], den, bos[3], Integer.parseInt(bos[4]), bos[5], bos[6]);
				a.setValue(Integer.parseInt(bos[7]));
				a.setRateCount(Integer.parseInt(bos[8]));
				temp5.enqueue(a);
			}
			Menu.list.put(5, temp5);
			/*while (!temp5.isEmpty()) {
				temp5.dequeue();
			}*/
		} catch (Exception e) {
		}
	}
}
