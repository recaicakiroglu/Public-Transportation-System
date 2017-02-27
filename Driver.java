
public class Driver implements Comparable<Driver>{
	private String Id;
	private String name;
	private String surname;
	private String birthdate;
	private String phonenumber;
	
	public Driver(String id, String name, String surname, String birthdate,
			String phonenumber) {
		Id = id;
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.phonenumber = phonenumber;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	@Override
	public int compareTo(Driver compareDriver){
		int int1 = Integer.parseInt(((Driver) compareDriver).getId());
        int compareID = int1;
        int int2 = Integer.parseInt(this.Id);
       return int2 - int1;
}
}
