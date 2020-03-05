import java.util.*;


public class Room{
	private int roomNum;
	private String capacity;
	private ArrayList<Date> bookingDates;
	private String hotel;
	
	public Room(int roomNum, String type,String hotel) {
		this.roomNum = roomNum;
		this.capacity = type;
		this.hotel = hotel;
		bookingDates = new ArrayList<Date>();
	}
	
	public int getRoomNum() {
		return roomNum;
	}
	
	public String getCapacity() {
		return capacity;
	}
	
	public String getHotelName() {
		return hotel;
	}
	
	public ArrayList<Date> getBookingDates(){
		return bookingDates;
	}
	
	public void addBookingDate(int month, int date, int numDays){
		System.out.println(month);
		if(numDays == 1) {
			Date d1 = new Date(month,date);
			bookingDates.add(d1);
		}
		else {
			addBookingDate(month, date, numDays-1);
			Date d2 = new Date(month,date);
			//System.out.println(d2.toString());
			d2.add(numDays-1);
			bookingDates.add(d2);
		}
	}
	
	public void deleteBookingDate(int month, int date, int numDays) {
		for(int i = 0;i<numDays;i++) {
			Date d2 = new Date(month, date+i);
			for(int j=0;j<bookingDates.size();j++) {
				Date d = bookingDates.get(j);
				if(d.equals(d2)) {
					bookingDates.remove(d);
				}
			}
		}
	}

	@Override
	public String toString() {
		String str = new String();
		str = "Room number: "+this.roomNum+"\n"+"Capacity: "+this.capacity+"\n"+"Booked time: "+"\n";
		for(Date d : bookingDates) {
			str = str + d.toString()+"\n";
		}
		return str;
	}
	
}
