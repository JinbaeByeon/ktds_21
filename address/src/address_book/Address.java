package address_book;

/**
 * 주소 관리 클래스
 * @author User
 *
 */
public class Address {
	private String name;
	private String phoneNumber;
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
		public String toString() {
			String res = "이름: " + name + "\n전화번호: " + phoneNumber + "\n주소: " +address;
			return res;
		}
}
