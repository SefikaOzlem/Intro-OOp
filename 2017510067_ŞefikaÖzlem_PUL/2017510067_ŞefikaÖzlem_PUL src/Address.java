
public class Address {
	private String City;
	private String Town;
	private String Street;
	private int DoorNumber;
	private int FlatNumber;
	public Address(AddressBuilder addressBuilder) {
		super();
		this.City =addressBuilder.City;
		this.Town = addressBuilder.Town;
		this.Street =addressBuilder.Street;
		this.DoorNumber = addressBuilder.DoorNumber;
		this.FlatNumber =addressBuilder.FlatNumber;
		}
	public String getCity() {
		return City;
	}	
	public String getTown() {
		return Town;
	}	
	public String getStreet() {
		return Street;
	}	
	public int getDoorNumber() {
		return DoorNumber;
	}
	public int getFlatNumber() {
		return FlatNumber;
	}
	public String display() {
		String temp=Street+" Street Door Number:"+DoorNumber+" Flat Number:"+FlatNumber+Town+"/"+City+"\n";
		return temp;
	}
	public String displayNormalType() {
		return Street+"Street "+Town+"/"+City+"\n";
	}
	public static class AddressBuilder{
		private String City;
		private String Town;
		private String Street;
		private int DoorNumber;
		private int FlatNumber;
		
		public AddressBuilder(String city, String town, String street)
		{
			this.City=city;
			this.Town=town;
			this.Street=street;
		}
		public AddressBuilder withOptionalDoorNumber(int doorNumber)
		{
			this.DoorNumber=doorNumber;
			return this;
		}
		public AddressBuilder withOptionalFlatNumber(int flatNumber)
		{
			this.FlatNumber=flatNumber;
			return this;
		}
		public Address buildAddress()
		{
			validateAddressData();
			return new Address (this);
		}
		private boolean validateAddressData()
		{
			return true;
		}
		
	}
}
