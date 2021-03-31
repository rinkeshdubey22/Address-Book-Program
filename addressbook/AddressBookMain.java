package addressbook;

import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookMain {

	public ArrayList<Contact> addressBook = new ArrayList<>();
	ArrayList<AddressBookList> addressBookNameList = new ArrayList<>();
	Scanner scan = new Scanner(System.in);

	public void addContact() {

		System.out.println("Enter Your First Name");
		String first = scan.nextLine();
		duplicateNameCheck(first);

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
		long mobileNo = Long.parseLong(scan.nextLine());

		System.out.println("Enter Zip Code of Your Area");
                int zip = Integer.parseInt(scan.nextLine());


		Contact contact = new Contact(first, last, address, city, state, email, mobileNo, zip);
		addressBook.add(contact);
		System.out.println("All Contact Details Added Successfully");
		System.out.println("\n You can add multiple person's entry");

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
				int option = Integer.parseInt(scan.nextLine());

				switch  (option) {
					case 1 : {
						System.out.println("Enter New Mobile No:");
						long mobileNo = Long.parseLong(scan.nextLine());

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
                                                int zip = Integer.parseInt(scan.nextLine());


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

	public void deletePersonDetails() {

		System.out.println("Enter Your First Name to Delete Details");
		String name = scan.nextLine();

		for (int i=0; i < addressBook.size(); i++) {
			String personName = addressBook.get(i).firstName;

			if (name.equals(personName)) {
				addressBook.remove(i);
				System.out.println("This Person Details Is Deleted");
				break;
			} else {
				System.out.println("Please Enter Valid Name");

			}
		}
	}

	public void newAddressBook() {

		System.out.println("Enter Address Book Name:");
		String userInputBookName = scan.nextLine();

		AddressBookList addressbook = new AddressBookList(userInputBookName);
		addressBookNameList.add(addressbook);
		System.out.println("New Address Book Name Is Added In the List");

	}

	public void displayAddressBook() {

		System.out.println("Existing Address Book Names Are:");

		for (AddressBookList addressBookList : addressBookNameList) {
			System.out.println(addressBookList);

		}
	}

	public void duplicateNameCheck(String first) {

		for (int i = 0; i < addressBook.size(); i++) {
			String contactName = addressBook.get(i).firstName;

			if (first.equals(contactName)) {

				System.out.println("This Person Is Already Present");

			} else {

				System.out.println("You Can Add This person");
				break;
			}
		}
	}

	public void searchPersonByCity() {

		System.out.println("Enter City Name To Search Person By City Name");
		String cityName = scan.nextLine();

		Dictionary Citywisedict = new Hashtable();

		addressBook.stream().filter(map -> map.getCity().contains(cityName)).forEach(addressBook -> Citywisedict.put(addressBook.getFirstName(),cityName));
		System.out.println("City Name: " + cityName);

		for (Enumeration i = Citywisedict.keys(); i.hasMoreElements();) {

			System.out.println("Name:" + i.nextElement());

		}
	}


	public void searchPersonByState() {

        System.out.println("Enter the state name to search Person by state name");
        String stateName = scan.nextLine();

	Dictionary Statewisedict = new Hashtable();

		addressBook.stream().filter(map -> map.getState().contains(stateName)).forEach(addressBook -> Statewisedict.put(addressBook.getFirstName(),stateName));
                System.out.println("State Name: " + stateName);

                for (Enumeration i = Statewisedict.keys(); i.hasMoreElements();) {

                        System.out.println("Name:" + i.nextElement());

                }


	}

	public void countByCity(){
        System.out.println(addressBook.stream().collect(Collectors.groupingBy((Contact C) -> C.getCity())));
        System.out.println((addressBook.stream().collect(Collectors.groupingBy((Contact C) -> C.getCity(),Collectors.counting()))));
    	}

    	public void countByState(){
        System.out.println(addressBook.stream().collect(Collectors.groupingBy((Contact C) -> C.getState())));
        System.out.println((addressBook.stream().collect(Collectors.groupingBy((Contact C) -> C.getState(),Collectors.counting()))));
    	}

	public static void main(String[] args) {

		System.out.println("................Welcome To The Address Book Problem.................");
		AddressBookMain address = new AddressBookMain();
		Scanner sc = new Scanner(System.in);
        	System.out.println("1.Add Contact");
        	System.out.println("2.Display Contact");
        	System.out.println("3.Edit Contact");
		System.out.println("4.Delete Contact");
		System.out.println("5.Add New Address Book");
		System.out.println("6.Display New Address Book");
        	System.out.println("7.Search Person By City Name");
		System.out.println("8.Search Person By State Name");
		System.out.println("9.Count By City Name");
		System.out.println("10.Count By State Name");
		System.out.println("10.Exit");



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
                    			address.deletePersonDetails();
					break;
				case 5:
					address.newAddressBook();
					break;
				case 6:
					address.displayAddressBook();
					break;
				case 7:
                                        address.searchPersonByCity();
                                        break;
				case 8:
                                        address.searchPersonByState();
                                        break;
				 case 9:
                    			address.countByCity();
                    			break;
                		case 10:
                    			address.countByState();
                    			break;
                		case 11:
                    			System.out.println("Exit");
                    			k = 1;
                    			break;
            		}
        	}
	}

}
