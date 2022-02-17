

import java.util.List;
import java.util.Scanner;

import controller.GeographyItemHelper;
import model.GeographyItem;

public class StartGeo {

		static Scanner in = new Scanner(System.in);
		static GeographyItemHelper gih = new GeographyItemHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a country: ");
			String country = in.nextLine();
			System.out.print("Enter a capital: ");
			String capital = in.nextLine();
			System.out.print("Enter a language: ");
			String language = in.nextLine();
			GeographyItem toAdd = new GeographyItem(country, capital, language);
			gih.InsertItem(toAdd);

		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the country to delete: ");
			String country = in.nextLine();
			System.out.print("Enter the capital to delete: ");
			String capital = in.nextLine();
			System.out.print("Enter the langauge to delete: ");
			String language = in.nextLine();
			GeographyItem toDelete = new GeographyItem(country, capital, language);
			gih.deleteItem(toDelete);

		}
        //search and edit
		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Country");
			System.out.println("2 : Search by Capital");
			System.out.print("3: Search by language");
			int searchBy = in.nextInt();
			in.nextLine();
			List<GeographyItem> foundCountry;
			if (searchBy == 1) {
				System.out.print("Enter country name: ");
				String countryName = in.nextLine();
				foundCountry = gih.searchForCountryByCountry(countryName);
				
			} else if (searchBy == 2) {
				System.out.print("Enter capital: ");
				String capitalName = in.nextLine();
				foundCountry = gih.searchForCountryByCapital(capitalName);
			} else  {
				System.out.print("Enter language: ");
			    String languageName = in.nextLine();
			    foundCountry = gih.searchCountryByLanguage(languageName);
			    }

			if (!foundCountry.isEmpty()) {
				System.out.println("Found Results.");
				for (GeographyItem l : foundCountry) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				GeographyItem toEdit = gih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getCapital() + " from " + toEdit.getCountry());
				System.out.println("1 : Update Country");
				System.out.println("2 : Update Capital");
				System.out.println("3 : Update Langauge");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Country: ");
					String newCountry = in.nextLine();
					toEdit.setCountry(newCountry);
				} else if (update == 2) {
					System.out.print("New Capital: ");
					String newCapital = in.nextLine();
					toEdit.setCapital(newCapital);
				} else if (update == 3) {
					System.out.print("New Langauge: ");
					String newLanguage = in.nextLine();
					toEdit.setLanguage(newLanguage);
					
				}

				gih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to my geography table! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add a country");
				System.out.println("*  2 -- Edit a country");
				System.out.println("*  3 -- Delete a country");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					//lih.cleanUp();
					System.out.println("   Goodbye! Au Revoir! Namaste! Hamba kahle!");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			 		List<GeographyItem>allItems = gih.showAllItems();
					for(GeographyItem singleItem:allItems) {
						System.out.println(singleItem.returnCountryDetails());
					}
			

		}

	}
