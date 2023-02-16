package gas_station;

public class Fuel {	
	private FuelType type;
	private int remain;
	
	
	public FuelType getType() {
		return type;
	}
	public void setType(FuelType type) {
		this.type = type;
	}
	public int getRemain() {
		return remain;
	}
	public void setRemain(int remain) {
		this.remain = remain;
	}
	public void add(int amount) {
		remain += amount;
	}
	public void subtract(int amount) {
		remain -= amount;
	}
	Fuel(FuelType type,int remain){
		this.type = type;
		this.remain = remain;
	}
	Fuel(FuelType type){
		this.type = type;
	}
	Fuel(){
		
	}

	@Override
	public String toString() {
		return "기름 종류: " + type + ", 잔량: " + remain;
	}
}
