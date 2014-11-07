/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import FundraisingApp.*; // The package containing generated stubs.
import org.omg.CORBA.*; // All CORBA
// needed for output to the file system.
import java.io.*;

public class FundraisingClient {

	// Add the main method here in the next step.
    public static void main(String args[]) {
        // Put the try-catch block here in the next step.
        try { // Add the rest of the FundraisingClient code here.

            //Initialize the ORB
            ORB orb = ORB.init(args, null);
            //Read the object Reference for the FundraisingServant
            BufferedReader br = new BufferedReader(new FileReader("FundraisingIOR"));
            String ior = br.readLine();
            //Convert the string object reference to an object
            org.omg.CORBA.Object obj = orb.string_to_object(ior);
            //Convert the object to the correct type i.e. Fundraising
            Fundraising fundraisingRef = FundraisingHelper.narrow(obj);
			//Call theoperation on the servant

			// fundraisingRef.donate(10);
            // fundraisingRef.donate(20.5);
			//double  balance = fundraisingRef.getBalance();
            //System.out.println(balance);
            BufferedReader userEntry = new BufferedReader(new InputStreamReader(System.in));
            char menuChoice;

            do {
                System.out.println("Menu choice");
                System.out.println("1 Donate; 2 GetBalance; 3 Get average donation; 4 Get numbers Donors; 5 Quit.");
                menuChoice = (char) (System.in.read());
                userEntry.readLine(); //Need to clear the out the buffer
                if (menuChoice == (char) '1') {
                    System.out.println("Please enter the amount of money you want to donate");
                    String moneyString = userEntry.readLine();
                    double money = Double.parseDouble(moneyString);
                    fundraisingRef.donate(money);
                } else if (menuChoice == (char) '2') {

                    double balance = fundraisingRef.getBalance();
                    System.out.println(balance + " money were raised ");
                    System.out.println("Thank you");
                } else if (menuChoice == (char) '3') {

                    double balanceAvg = fundraisingRef.getAvgDonation();
                    System.out.println(balanceAvg + " money in average per donation");
                    System.out.println("Thank you");
                } else if (menuChoice == (char) '4') {

                    int numberDonors = fundraisingRef.getNumberDonors();
                    System.out.println(numberDonors + " donors ");
                    System.out.println("Thank you");
                }

            } while (menuChoice != (char) '5');

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
}
