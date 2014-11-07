/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

// The package containing our stubs.
import Servant.FundraisingServant;
// All CORBA applications need these classes.
import org.omg.CORBA.*;
// needed for output to the file system.
import java.io.*;


public class FundraisingServer {
	// Add the main method here in the next step.

	public static void main(String args[]) {
		// Add the try-catch block here in the next step.

		try {
			//Initialize the ORB
			ORB orb = ORB.init(args, null);
			//Instantiate the FundraisingAppServant on the server
			FundraisingServant fundraisingRef = new FundraisingServant();
			//Connect the FundraisingServant to the orb
			orb.connect(fundraisingRef);
			//Store an object Reference to the FundraisingServant in a
			//String format
			String ior = orb.object_to_string(fundraisingRef);
			//Write the object reference to the fundraisingServant to a
			//file called FundraisingIOR
			FileOutputStream fos = new FileOutputStream("FundraisingIOR");
			PrintStream ps = new PrintStream(fos);
			ps.print(ior);
			ps.close();
			//Run the orb so that it waits for requests from the
			//client
			orb.run();

		}
		catch(Exception e) {
			System.err.println("ERROR: " + e);
			e.printStackTrace(System.out);
		}
	}
}