import java.util.ArrayList;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.util.concurrent.TimeUnit;

 

/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Wai Yan Bhone Pyae
 * Student ID: 22003495
 * Class: C298-5B-E65F-A
 * Date/Time Last modified:Tuesday 31/01/2023
 */



public class WardManagement {
	//ArrayList<Patient> patientList = new ArrayList<Patient>();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//initialise Ward array with ward objects 
		Ward[] wardArr = new Ward[4];
		wardArr[0]=new Ward("A","1 Bed,attached bath/toilet",10,535.00);
		wardArr[1]=new Ward("B1","4 Bed,attached bath/toilet",20,466.43);
		wardArr[2]=new Ward("B2","6 Bed,common bath/toilet",20,83.00);
		wardArr[3]=new Ward("C","8 Bed,common bath/toilet",50,37.00);
		//-------------------
		// Complete code here.
	
			
		//initialise Patient arraylist with patient objects	
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		
		//-------------------
		// Complete code here
		patientList.add(new Patient("111A","John Lee","A",2,"01/12/2022","",0));
		patientList.add(new Patient("222B","Mary Jane","B1",11,"02/12/2022","",0));
		patientList.add(new Patient("333C","Abdul Musri","B1",12,"03/12/2022","",0));
		patientList.add(new Patient("444D","Jane Tan","B2",2,"12/12/2022","",3));
		patientList.add(new Patient("555E","Paul Tan","C",2,"02/11/2022","",4));
		patientList.add(new Patient("666F","Paul Ng","C",3,"03/11/2022","09/11/2022",0));
		patientList.add(new Patient("777G","Wong Kuan","C",4,"02/12/2022","",0));
	
		
		//-------------------



		//display standard menu and ask for option
		int option = -99;
		
		publicMenu();
		

		
		//indefinite while loop
		while(option != 10) {
			boolean patientfound = true;
			option = Helper.readInt("\nEnter option or 0 for main menu > ");

			//check for  options
			if(option == 0) {
				//display main menu
				publicMenu();
			} else if (option == 1) {
				//list ward info
				displayWardInfo(wardArr);		
			} else if (option == 2) {
				//display patient in ward
				displayPatientList(patientList);
			} else if (option == 3) {
				//admit patient
				admitPatient(patientList);
			} else if (option == 4) {
				//discharged patient
				patientfound = dischargePatient(patientList);
			} else if (option == 5) {
				//Remove patient visit
				patientfound = removePatient(patientList);
			} else if (option == 6) {
				//register visit
				patientfound = registerVisit(patientList);
			} else if (option == 7) {
				//End visit
				patientfound = endVisit(patientList);
			} else if (option == 8) {
				//End visit
				displayWardOverview(patientList, wardArr);
				
			} else if (option == 9) {
				//calcRevenue
				calcRevenue(patientList, wardArr);
			} else if (option == 10) {
				//log out
				System.out.println("\nGood bye!");
			} else {
				//invalid option chosen
				System.out.println("\n*** Invalid option selected ***\n");
			}

			//if patient does not exist based on return boolean
			if (!patientfound) {
				System.out.println("\n*** No such patient in ward ***\n");
			}

		}

	} // end of main



	

	//-------------------------------------------------------------------------------------------------------
	//static method to print the standard menu 
	//-------------------------------------------------------------------------------------------------------
	public static void publicMenu() {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     PATIENT  MANAGEMENT  MENU     *****");
		Helper.line(45, "*");
		System.out.println("1. View all Ward Info\n"
		 		+ "2. Display Patient List\n"
		 		+ "3. Admit Patient\n"
		 		+ "4. Discharge Patient\n"
		 		+ "5. Remove Patient\n"
		 		+ "6. Register Visit\n"
		 		+"7. End Visit\n"
		 		+"8. Display Ward Overview\n"
		 		+"9. Calculate Revenue\n"
		 		+"10. Logout");
		
		//-------------------
		// Complete code here
		//-------------------

	}



	//-------------------------------------------------------------------------------------------------------
	//static method takes in a ward array and list out ward details in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayWardInfo(Ward[] wardArr) {
		System.out.println();
		Helper.line(80, "-");
		String output=String.format("%-10s %-35s %-15s %-1s %-10s", "Ward","Description","Bed Count","","Bed Charge");
		System.out.println(output);
		Helper.line(80, "-");
	
		
		for (int i=0;i<wardArr.length;i++) {
			String output1=String.format("%-10s %-35s %-17d %-1s %-10.2f", wardArr[i].getWard(),wardArr[i].getDescription(),wardArr[i].bedCount(),"$",wardArr[i].getBedCharge());
			System.out.println(output1);
			

		}
		
		
		//-------------------
		// Complete code here
		//-------------------

	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and display all the patient information in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayPatientList(ArrayList<Patient> patientList) {
		Helper.line(120, "=");
		String output=String.format("%-10s%-15s%-25s%-10s%-15s%-30s%-10s","NRIC4","Name","Ward","Bed","Date Warded","Date Discharged","Visitor Count");
		System.out.println(output);
		Helper.line(120, "=");
		
		for (int i=0;i<patientList.size();i++) {
			String s1=patientList.get(i).getNric4();
			String s2=patientList.get(i).getName();
			String s3=patientList.get(i).getWard();
			int s4=patientList.get(i).getBed();
			String s5=patientList.get(i).getDateWarded();
			String s6=patientList.get(i).getDateDischarged();
			int s7=patientList.get(i).getVisitorCount();
			
			
			String output1=String.format("%-10s%-15s%-25s%-10d%-15s%-30s%-10d",s1,s2,s3,s4,s5,s6,s7);
			System.out.println(output1);
		}

		//-------------------
		// Complete code here
		//-------------------

	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the admit patient functionality
	//-------------------------------------------------------------------------------------------------------
	public static void admitPatient(ArrayList<Patient> patientList) {
		  
		String nric4=Helper.readString("Enter patient 4 digit NRIC > ");
		
		
		boolean isfound=false;
		for (int i=0;i<patientList.size();i++) {
			if (nric4.equalsIgnoreCase(patientList.get(i).getNric4())) {
				System.out.println("*** Existing patient! ***");
				isfound=true;
				
			}
		}
			if(nric4.length()!=4) {
				System.out.println("*** Invalid NRIC4 number! ***");
				isfound=true;
			}
		
			if(isfound==false){
				String name=Helper.readString("Enter patient name > ");
				String ward=Helper.readString("Enter ward > ");
				int bed=Helper.readInt("Enter bed > ");
				String dateWarded=Helper.readString("Enter date warded >\n ");
				nric4=nric4.substring(0,3)+nric4.substring(3,3+1).toUpperCase();
				Patient newPatient=new Patient(nric4,name,ward,bed,dateWarded);
				
				
				patientList.add(newPatient);
				
				newPatient.display();
						
						
						
				System.out.println("***Patient has been added***");
			}
		
		
		
		
		
	}
	
			
		
		
		//-------------------
		// Complete code here
		//-------------------

	



	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the discharge patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean dischargePatient(ArrayList<Patient> patientList) {

		boolean patientfound = false;
		String name = Helper.readString(" Enter patient name > ");
		System.out.println();
		
		for (int i=0; i < patientList.size(); i++) {
			if(patientList.get(i).getName().equalsIgnoreCase(name)&& patientList.get(i).getDateDischarged() == "") {
				patientList.get(i).display();
				System.out.println();
				String dateDischarged = Helper.readString("Enter date discharged > ");
				patientList.get(i).setDateDischarged(dateDischarged);
				patientList.get(i).setVisitorCount(0);
				System.out.println("\n*** Patient is discharged ***");
				patientfound =true;
			}
			else if(patientList.get(i).getName().equalsIgnoreCase(name)&& patientList.get(i).getDateDischarged() != "") {
				System.out.println(" *** Patient has already been discharged ***");
				patientfound = true;
			}
		}
		
		  
		    	
		    
		return patientfound;
		

		//-------------------
		// Complete code here
		//-------------------

		
	}





	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the remove patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean removePatient(ArrayList<Patient> patientList) {

		boolean patientfound = false;
		String name=Helper.readString("Enter patient name > ");
		for (int i=0;i<patientList.size();i++) {
			if (patientList.get(i).getDateDischarged()=="" && patientList.get(i).getName().equalsIgnoreCase(name)) {
				patientList.get(i).display();
				char delete=Helper.readChar("Confirm deletion(y/n)");
				if ((delete=='y')||(delete=='Y')) {
					patientList.remove(i);
					System.out.println("*** Patient has been deleted ***");
					patientfound=true;
				}
			
				//-------------------
		// Complete code here
		//-------------------

		
	}
		}
		return patientfound;
	}
	


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the register visit functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean registerVisit(ArrayList<Patient> patientList) {
		//-------------------
				// Complete code here
		boolean patientfound = false;

		//-------------------
		// Complete code here
		//-------------------
				//-------------------
		String name = Helper.readString("Enter patient name > ");
		System.out.println();
		
		for(int i = 0; i< patientList.size(); i++) {
			if(patientList.get(i).getName().equalsIgnoreCase(name)) {
				patientList.get(i).display();
				System.out.println();
				if((patientList.get(i).getDateDischarged()=="")&&(patientList.get(i).getVisitorCount()<4)){
					int vAllowed=4 - patientList.get(i). getVisitorCount();
					System.out.println("*** Only "+vAllowed+" visitor(s) allowed ***\n");
					System.out.println();
					patientfound=true;
					int vNew=Helper.readInt("Enter number of new visitors > ");
					if((patientList.get(i).getVisitorCount()+vNew)<=4) {
						int vCount=vNew+patientList.get(i).getVisitorCount();
						patientList.get(i).setVisitorCount(vCount);
						System.out.println("*** Please proceed to ward ***");
					}
					else {
						System.out.println("\n*** Visitors exceeded ***");
						patientfound=true;
					}
				}
				else if((patientList.get(i).getDateDischarged()=="")&&(patientList.get(i).getVisitorCount()==4)){
					System.out.println("*** No additional visitor allowed ***");
					patientfound=true;
				}
				else {
					System.out.println("*** Patient has been discharged ***");
					patientfound=true;
				}
			}
			
			
		}
		return patientfound;
	
	 
	}
	

	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the end visit functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean endVisit(ArrayList<Patient> patientList) {

		boolean patientfound = false;
		String name=Helper.readString("Enter patient name > ");
		for (int i=0;i<patientList.size();i++){
			
			
			if((patientList.get(i).getDateDischarged()=="")&&(patientList.get(i).getName().equalsIgnoreCase(name))){
				patientList.get(i).display();
				System.out.println();
				int vLeave=Helper.readInt("Enter number of visitor(s) leaving > ");
				int vLeft=patientList.get(i).getVisitorCount()-vLeave;
				
				if(vLeave<patientList.get(i).getVisitorCount()) {
					patientList.get(i).setVisitorCount(vLeft);
					System.out.println("*** No of visitor(s) still at work : "+vLeft+" ***");
					patientfound=true;
				}
				else {
					System.out.println("*** Visitor(s) leaving is more than visited ***");
					patientList.get(i).getVisitorCount();
					patientfound=true;
				}
			}
			

			else if((patientList.get(i).getName().equalsIgnoreCase(name))&&(patientList.get(i).getDateDischarged()!="")){
				patientList.get(i).display();
				System.out.println("*** Patient has been discharged ***");
				patientfound=true;
			}
					}
		//-------------------
		// Complete code here
		//-------------------

		return patientfound;
	} 

	
	
	//------------------------------------------------------------------------------------------------------------
	//static method that takes in a patient arraylist, a ward array and display an overview of the ward information
	//------------------------------------------------------------------------------------------------------------
	public static void displayWardOverview (ArrayList<Patient> patientList, Ward[] wardArr) {
		//-------------------
		// Complete code here
		int totalPatient = 0;
		int totalVisitor = 0;
		int totalBed = 0;
	    Helper.line(97, "-");
	    System.out.println(String.format("|%-7s |%-35s |%-15s |%-15s |%-15s| ", "WARD", "DESCRIPTION", 
	    		"BED COUNT","TOTAL PATIENTS", "TOTAL VISITORS"));
	    Helper.line(97, "-");
	    
	    for (int i = 0; i < wardArr.length; i++) {
	    	int patient = 0;
	    	int visitor = 0;
	    	totalBed += wardArr[i].bedCount();
	    	for (int z = 0; z < patientList.size(); z++) {
	    		if (patientList.get(z).getWard().equals(wardArr[i].getWard())) {
	    			visitor += patientList.get(z).getVisitorCount();
	    			totalVisitor += patientList.get(z).getVisitorCount();
	    		if (patientList.get(z).getDateDischarged() == "") {
	    			patient ++;
	    			totalPatient ++;

	          }
	        }
	      }
	      System.out.println(String.format("|%-7s |%-35s |%-15d |%-15d |%-15s| ", wardArr[i].getWard(),
	    		  wardArr[i].getDescription(), wardArr[i].bedCount(), patient, visitor));
	    }
	
	    Helper.line(97, "=");
	    System.out.println(String.format("%-7s %-35s   |%-15d |%-15d |%-15d|", "TOTAL", "",
	    		totalBed, totalPatient, totalVisitor));
	    Helper.line(97,"-");
	}
	

	public static boolean calcRevenue (ArrayList<Patient> patientList,Ward[]wardArr) {
		
		boolean patientfound = false;
		double totalRevenue = 0.0;
		Helper.line(55, "*");
		System.out.println("*****     TOTAL BED CHARGE FOR CENTAIL PERIOD     *****");
		Helper.line(55 ,"*");
		Helper.line(100,"=");
    	System.out.println(String.format("%-10s| %-13s| %-15s| %-20s| %-15s| %-15s", "NRIC4","NAME","DATE WARDED","DATE DISCAHRGED","DAYS","TOTAL BED CHARGE"));
    	Helper.line(100,"=");
		for(int i=0;i<patientList.size();i++) {
			if(patientList.get(i).getDateDischarged()!="") {
				try {
					// Convert `String` to `Date`
					    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					    Date dateBefore = sdf.parse(patientList.get(i).getDateWarded());
					    Date dateAfter = sdf.parse(patientList.get(i).getDateDischarged());

					// Calculate the number of days between dates
					    long timeDiff = Math.abs(dateAfter.getTime() - dateBefore.getTime());
					    long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
					    
					    for(int j=0;j<wardArr.length;j++) {
					    	if((patientList.get(i).getWard())==wardArr[j].getWard()) {
					    		 double revenue = wardArr[j].getBedCharge()*daysDiff;
					    		 totalRevenue+=revenue;
					    		 System.out.println( String.format("%-10s| %-13s| %-15s| %-20s| %-15d| %-1s %-15.2f", patientList.get(i).getNric4(),patientList.get(i).getName()
						    			 ,patientList.get(i).getDateWarded(),patientList.get(i).getDateDischarged(),daysDiff,"$",revenue));
						    	 
					    		
						    	
					    	}
					    }
					    
					}
				
					catch(Exception e)
					{
					    e.printStackTrace();
					}
				}
		
		}
		String output=String.format("%-10s %-13s %-15s %-24s %-13s %-2s %-1s %-15.2f", "","","","","TOTAL","=","$",totalRevenue);
		Helper.line(100,"=");
	    System.out.println(output);
	    Helper.line(100,"=");
		return patientfound;
	} 
}









