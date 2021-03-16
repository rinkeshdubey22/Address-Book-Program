package addressbook;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {

	public ArrayList<Contact> addressBook = new ArrayList<>();
	public void addContact() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Your First Name");
		String first = scan.nextLine();
		System.out.println("Enter Your Last Name");
                String last = scan.nextLine();
		System.out.println("Enter Your Address");
                String address = scan.nextLine();
		System.out.println("Enter Your City Name");
                String city = scan.nextLine();
		System.out.println("Enter Your State");
                String state = scan.nextLine();
		System.out.println("Enter Your Email ID");
                String email = scan.nextLine();
		System.out.println("Enter Your Mobile Number");
		long mobileNo = scan.nextLong();
		System.out.println("Enter Zip Code of Your Area");
                int zip = scan.nextInt();
		Contact contact = new Contact(first, last, address, city, state, email, mobileNo, zip);
		addressBook.add(contact);
		System.out.println("All Contact Details Added Successfully");

	}

	public void displayPerson() {

		System.out.println("\nEntered Person Details is:");
		for(Contact person : addressBook) {
			System.out.println(person.toString());
		}
	}
	public static void main(String[] args) {
		System.out.println(".........Welcome To The Address Book Problem.........");
		AddressBookMain address = new AddressBookMain();
		address.addContact();
		address.displayPerson();
	}

}
