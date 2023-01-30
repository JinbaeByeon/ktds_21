package gas_station;

public class Fuel {
	public static final int GASOLINE =0;
	public static final int DIESEL =1;
	public static final int LPG =2;
	
	private int type;
	private int remain;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
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
	Fuel(int type,int remain){
		this.type = type;
		this.remain = remain;
	}
	Fuel(int type){
		this.type = type;
	}
	Fuel(){
		
	}

	@Override
	public String toString() {
		String[] oilName = {"휘발유","경유","LPG"};
		return "기름 종류: " + oilName[type] + ", 잔량: " + remain;
	}
}
