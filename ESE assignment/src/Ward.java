/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: WAI YAN BHONE PYAE
 * Student ID: 22003495
 * Class: C298-5B-E65F-A
 * Date/Time created: Monday 12-12-2022 13:56
 */

/**
 * @author waiya
 *
 */
public class Ward {
	 private String ward;
	 private String description;
	 private int bedCount;
	 private double bedCharge;
	 
	 public Ward(String ward,String description,int bedCount,double bedCharge) {
		 this.ward=ward;
		 this.description=description;
		 this.bedCount=bedCount;
		 this.bedCharge=bedCharge;
		 
	 }
	 public String getWard() {
		 return ward;
	 }
	 public String getDescription() {
		 return description;
	 }
	 public int bedCount() {
		 return bedCount;
	 }
	 public double getBedCharge() {
		 return bedCharge;
	 }
	 
	 

}
