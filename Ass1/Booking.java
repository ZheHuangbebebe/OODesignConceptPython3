

import java.util.ArrayList;


public class Booking{
	String name;
	int month;
	int date;
	int numDays;
	String capacity;
	int num;
	ArrayList<Room> rooms = null;
	
	public String getName() {
		return name;
	}
	
	public int getMonth() {
		return month;
	}
	
	public String getCapacity() {
		return capacity;
	}
	
	public String getStrMonth() {
		if(month == 0)
			return "Jan";
		else if(month == 1)
			return "Feb";
		else if(month == 2)
			return "Mar";
		else if(month == 3)
			return "Apr";
		else if(month == 4)
			return "May";
		else if(month == 5)
			return "Jun";
		else if(month == 6)
			return "Jul";
		else if(month == 7)
			return "Aug";
		else if(month == 8)
			return "Sep";
		else if(month == 9)
			return "Oct";
		else if(month == 10)
			return "Nov";
		else
			return "Dec";
		
	}

	public int getDate() {
		return date;
	}

	public int getNumDays() {
		return numDays;
	}
	
	public int getNum() {
		return num;
	}

	public ArrayList<Room> getRooms(){
		return rooms;
	}
	
	public void setRooms(ArrayList<Room> room){
		//System.out.println(room.toString());
		rooms.addAll(room);
	}
	
	public Booking(String name, String month,int date, int numDays, String capacity,int num) {
		if(month.equals("Jan"))
			this.month = 0;
		else if(month.equals("Feb"))
			this.month = 1;
		else if(month.equals("Mar"))
			this.month = 2;
		else if(month.equals("Apr"))
			this.month = 3;
		else if(month.equals("May"))
			this.month = 4;
		else if(month.equals("Jun"))
			this.month = 5;
		else if(month.equals("Jul"))
			this.month = 6;
		else if(month.equals("Aug"))
			this.month = 7;
		else if(month.equals("Sep"))
			this.month = 8;
		else if(month.equals("Oct"))
			this.month = 9;
		else if(month.equals("Nov"))
			this.month = 10;
		else if(month.equals("Dec"))
			this.month = 11;
		this.name = name;
		this.date = date;
		this.numDays = numDays;
		this.capacity = capacity;
		this.num = num;
		rooms = new ArrayList<Room>();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = new String();
		str = "Name: "+this.name+"\n"+"Date: "+getStrMonth()+"/"+this.date+"number of days: "
				+ this.numDays;
		return str;
	}
	
}
