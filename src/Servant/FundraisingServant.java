/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servant;
// The package containing our stubs.
import FundraisingApp.*;

//Servant must inherit the generated code
public class FundraisingServant extends _FundraisingImplBase {

	//atributes
	double fundraisingBalance = 0;
	int donors=0;

	// Add the methods
	public void donate(double amount){
		fundraisingBalance = fundraisingBalance+amount;
		donors = donors +1;
		}

	public double getBalance(){
		return fundraisingBalance;
		}
	public double getAvgDonation(){
		double avg=fundraisingBalance/donors;
		return avg;
		}
    public int  getNumberDonors(){
		return donors;
		}

}
