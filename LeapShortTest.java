 /**
 * This class contains one constructor and three methods: 
 * 
 * The constructor doesn't take any parameters.
 * 
 * The first method (isALeapYear) checks if given year is a Leap Year and displays the answer.
 * 
 * The second method (displayCalendar) displays a calendar for given year, without days of the week,
 * considering only the amount of days of each month and whether the year is a leap year or not, to retrieve
 * the correct number of days of February.
 * 
 * The third method (displayCalendarDays) displays an enhanced calendar, considering days of the week.
 * I used the Gauss' algorithm to retrieve the day of week of January 1st of given year. Then, based on this 
 * information, the other months could have their starting days of week adjusted.
 * 
 * Author: Gustavo Lessa
 * Student number: 2016104
 * 
 */
 
 
 public class LeapShortTest { 
		
		int days = 0;
		int month = 0;
		int year = 2016; //change for desired year
		boolean leapYear = false;//will be changed if it's a leap year

		public LeapShortTest(){
		}
		
		public void isALeapYear(int yr){
			year = yr;
			if (year <=0){
				System.out.println("Year cannot be negative.");
			} else {
				if((year%4)==0){// divisible by 4
					if((year%100)==0 && (year%400)!=0){ // divisible by 4 and 100, but not by 400
					leapYear = false;
					} else {// all other years divisible by 4
						leapYear = true;
					}
				} else {//not divisible by 4
				leapYear = false;
				}	
			if(leapYear){
				System.out.println(year+ " is a Leap Year.");
			} else {
				System.out.println(year+ " is not a Leap year.");
			}
			System.out.println("");		
			}
		}	
		public void displayCalendar(int yr){
			year = yr;
			//check if it is a leap year:
			if (year <=0){
				System.out.println("Year cannot be negative.");
			} else {
				if((year%4)==0){// divisible by 4
					if((year%100)==0 && (year%400)!=0){ // divisible by 4 and 100, but not by 400
					leapYear = false;
					} else {// all other years divisible by 4
						leapYear = true;
					}
				} else {//not divisible by 4
				leapYear = false;
				}			
			}
				for (month = 1; month <= 12; month ++){
					
					// set the number of days for each month of the loop
					if (month==1 || month==3 || month ==5 || month ==7 || month==8 || month==10 || month == 12){
						days = 31;
					} else if (month==4 || month==6 || month==9 || month==11){
						days = 30;
					} else if (month==2 && leapYear==true){
						days = 29;
					} else {
						days = 28;
					}
					
					// set header
					if (month == 1){
						System.out.println("        January "+year);
				
					} else if (month == 2){//february
						System.out.println("        February "+year);
						
					} else if (month == 3){ //march
						System.out.println("         March "+year);
						
					} else if (month == 4){ //april
						System.out.println("         April "+year);
						
					} else if (month == 5){ //May
						System.out.println("          May "+year);
						
					} else if (month == 6){ //June
						System.out.println("         June "+year);
						
					} else if (month == 7){ //July
						System.out.println("         July "+year);
						
					} else if (month == 8){ //August
						System.out.println("         August "+year);
						
					} else if (month == 9){ //September
						System.out.println("        September "+year);
						
					} else if (month == 10){ //October
						System.out.println("        October "+year);
						
					} else if (month == 11){ //November
						System.out.println("        November "+year);
						
					} else if (month == 12){ //December
						System.out.println("        December "+year);
					}	

					// display days
					for (int date=1; date<=days; date++){
	     					if (date <= days){
	     	       				System.out.printf("%3d ", date);
	     	   				}
							if (date % 7 == 0) {
	 	     					System.out.println("");
	 	     	  			}
	  				}	
					System.out.println("\n");
						
				}

		}
		public void displayCalendarDays(int yr){
		year = yr;
			// check if it is a leap year
			if (year <=0){
				System.out.println("Year cannot be negative.");
			} else {
				if((year%4)==0){// divisible by 4
					if((year%100)==0 && (year%400)!=0){ // divisible by 4 and 100, but not by 400
					leapYear = false;
					} else {// all other years divisible by 4
						leapYear = true;
					}
				} else {//not divisible by 4
				leapYear = false;
				}			
			}
			
// Algorithm to determine the day of the week of 1st of January of given year, based on Gauss' formula:
			int a = 6*((year-1)%400);
			int b = 4*((year-1)%100);
			int c = 5*((year-1)%4);
			int startDay = (1+a+b+c)%7;//full algorithm, returns 1 for Monday
			
			int x = 0;//counter for items written for each month, including empty spaces
			int monthStart = 0;//will be negative if the month doesn't start on Sunday, in order to print empty spaces.
			
				for (month = 1; month <= 12; month ++){
					
					//set number of days
					if (month==1 || month==3 || month ==5 || month ==7 || month==8 || month==10 || month == 12){
						days = 31;
					} else if (month==4 || month==6 || month==9 || month==11){
						days = 30;
					} else if (month==2 && leapYear==true){
						days = 29;
					} else {
						days = 28;
					}
					//display header and set the starting day for each month.
					if (month == 1){
						monthStart = -startDay+1; // setting the amount of empty spaces to display. Week starts on Sunday.
						System.out.println("        January "+year);
	   					
					} else if (month == 2){//february
						monthStart = (-startDay-2)%7; // %7 is being used to avoid possible whole empty lines.
						System.out.println("        February "+year);
	   				
					} else if (month == 3){//March
						monthStart = (-startDay-2)%7;
						System.out.println("         March "+year);
	   				
					} else if (month == 4){//April
						monthStart = (-startDay-5)%7;
						System.out.println("         April "+year);

					} else if (month == 5){//May
						monthStart = -startDay;
						System.out.println("           May "+year);
	   					
					} else if (month == 6){//June
						monthStart = (-startDay-3)%7;
						System.out.println("          June "+year);

					} else if (month == 7){//July
						monthStart = (-startDay-5)%7;
						System.out.println("          July "+year);

					} else if (month == 8){//August
						monthStart = (-startDay-1)%7;
						System.out.println("        August "+year);

					} else if (month == 9){//September
						monthStart = (-startDay-4)%7;
						System.out.println("       September "+year);

					} else if (month == 10){//October
						monthStart = (-startDay+1)%7;
						System.out.println("         October "+year);

					} else if (month == 11){//November
						monthStart = (-startDay-2)%7;
						System.out.println("        November "+year);

					} else if (month == 12){//December
						monthStart = (-startDay-4)%7;
						System.out.println("        December "+year);
					}

					// correct the starting days for months after February of Leap Years.
					if (leapYear==true && month >=3){ 
	   					monthStart -= 1;
	   				}

	   				// avoid blank lines of 7 empty spaces
	   				if (monthStart==-6){
						monthStart = 1;   					
					}
					// avoid blank lines after all modifications on the starting day
						monthStart = monthStart%7;
	   					System.out.println(" Su  Mo  Tu  We  Th  Fr  Sa ");
	   					x=0;		


	   					// display days
						for (int date = monthStart; date <= days; date++) {
							if (date <= 0) {
	      						System.out.printf("%3s ", "");
	      	  				} else {
	     	       				System.out.printf("%3d ", date);
	     	   				}
					x++;
	       		    			if (x % 7 == 0 && date < days) {
	 	     					System.out.println("");
	 	     	  			}
	 	     	  		
						}	
	 	   			System.out.println("");
					System.out.println("");	
				}
		}
 }
