package gas_station;

import java.util.ArrayList;
import java.util.List;

public class Street {
	public static void main(String[] args) {
		
		GasStation gasStation = new GasStation();
		
		List<Customer> customers = new ArrayList<>();		
		customers.add(new Customer(new Fuel(Fuel.GASOLINE),1_000_000));
		customers.add(new Customer(new Fuel(Fuel.DIESEL,50),1_000_000));
		customers.add(new Customer(new Fuel(Fuel.LPG),1_000_000));
		
		for(Customer customer: customers) {
			int sort = customer.getFuel().getType();
			customer.buy(gasStation,sort,500);
		}
		for(Customer customer: customers) {
			System.out.println(customer);
		}
		System.out.println(gasStation);
	}
}
