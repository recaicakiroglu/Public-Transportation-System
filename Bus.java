public class Bus implements Comparable<Bus> {
	private String Id;
	private String Plate;
	private String Brand;
	private String Model;
	private String Year;

	public Bus(String id, String plate, String brand, String model, String year) {
		Id = id;
		Plate = plate;
		Brand = brand;
		Model = model;
		Year = year;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPlate() {
		return Plate;
	}

	public void setPlate(String plate) {
		Plate = plate;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}
	@Override
	public int compareTo(Bus compareBus){
		int int1 = Integer.parseInt(((Bus) compareBus).getId());
        int compareID = int1;
        int int2 = Integer.parseInt(this.Id);
       return int2 - int1;
}
}
