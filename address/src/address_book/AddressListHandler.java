package address_book;

import java.util.ArrayList;
import java.util.List;

public class AddressListHandler {
	private List<Address> addressList = new ArrayList<>();

	public void create(String name, String phoneNumber, String address) {
		Address addr = new Address();
		addr.setName(name);
		addr.setPhoneNumber(phoneNumber);
		addr.setAddress(address);
		addressList.add(addr);
	}

	public void update(int idx, String name, String phoneNumber, String address) {
		Address addr = addressList.get(idx);
		addr.setName(name);
		addr.setPhoneNumber(phoneNumber);
		addr.setAddress(address);
	}

	public void delete(int idx) {
		addressList.remove(idx);
	}

	public void read(int idx) {
		System.out.println(addressList.get(idx));
	}

	public void readAllFor() {
		for (int i = 0; i < addressList.size(); ++i) {
			addressList.forEach(addr -> System.out.println(addr));
		}
	}

	public void readAllForEach() {
		for(Address addr: addressList) {
			System.out.println(addr);			
		}
	}

	public void readAllListForEach() {
		addressList.forEach(addr -> System.out.println(addr));
	}

	public static void main(String[] args) {
		AddressListHandler hdr = new AddressListHandler();
		hdr.create("aaa", "010-1111-1111", "서울");
		hdr.create("bbb", "010-2222-2222", "부산");
		hdr.create("ccc", "010-3333-3333", "강남");

		hdr.read(0);
		hdr.read(1);
		hdr.read(2);

		hdr.update(2, "ccc", "010-3232-2323", "강남");
		hdr.read(2);

		hdr.delete(2);
	}

}
