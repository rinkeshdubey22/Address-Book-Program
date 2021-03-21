package addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {

	public ArrayList<Contact> addressBook = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	public void addContact() {

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

	public void editPersonDetails() {
		System.out.println("Enter First Name To Edit Details:");
		String name = scan.nextLine();

		for (Contact person : addressBook) {
			System.out.println(person.toString());

			if (name.equals(person.firstName)) {
				System.out.println("Select the option to edit: \n"
						+"(1) Mobile Number\n"
						+"(2) Email Id\n"
						+"(3) Address\n"
						+"(4) Quit");
				int option = scan.nextInt();

				switch  (option) {
					case 1 : {
						System.out.println("Enter New Mobile No:");
						long mobileNo = scan.nextLong();

						person.setMobileNo(mobileNo);
						System.out.println("Mobile Number Is Updated Successfully");
						break;

					}
					case 2 : {
						System.out.println("Enter New Email Id:");
						String emailId = scan.nextLine();

						person.setEmail(emailId);
						System.out.println("Email Id Is Updated Successfully");
						break;
					}
					case 3 : {
						System.out.println("Enter Your State:");
                                                String state = scan.nextLine();

						System.out.println("Enter Your city:");
                                                String city = scan.nextLine();

						System.out.println("Enter Your Zip Code:");
                                                int zip = scan.nextInt();


						person.setState(state);
						person.setCity(city);
						person.setZip(zip);
						System.out.println("Address Is Updated Successfully");
						break;

					}
					default : System.out.println("Please Enter Right Choice");

				}


			}
			else {
				System.out.println("Person Is Not Registered");

			}

		}

	}
	public static void main(String[] args) {
		System.out.println("................Welcome To The Address Book Problem.................");
		AddressBookMain address = new AddressBookMain();
		Scanner sc = new Scanner(System.in);
        	System.out.println("1.Add Contact");
        	System.out.println("2.Edit Contact");
        	System.out.println("3.Display Contact");
        	System.out.println("4.Exit");
        	int k=0;
        	while(k==0) {
            		System.out.println("Enter the choice:");
            		int choice = sc.nextInt();

            		switch (choice) {
                		case 1:
                    			address.addContact();
                   			break;
                		case 2:
                    			address.displayPerson();
                    			break;
                		case 3:
                    			address.editPersonDetails();
                    			break;
                		case 4:
                    			System.out.println("Exit");
                    			k = 1;
                    			break;
            		}
        	}
	}

}
