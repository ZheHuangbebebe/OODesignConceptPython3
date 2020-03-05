
import java.util.*;
import java.io.*;
import java.nio.*;


public class HotelBookingSys{
	private ArrayList<Booking> bookings;
	private ArrayList<Hotel> hotels;
	
	public HotelBookingSys() {
		bookings = new ArrayList<Booking>();
		hotels = new ArrayList<Hotel>();
	}
	/*
	public void testMethod() {
		for(Hotel h : hotels) {
			System.out.println(h.getRooms().toString());
			
		}
	}*/
	
	public ArrayList<Booking> getBookings(){
		return bookings;
	}
	
	public ArrayList<Hotel> getHotels(){
		return hotels;
	}
	
	public Booking booking(String name, String month, int date, int numDays, String capacity, int num) {
		
		if(!(month.equals("Jan")||month.equals("Feb")||month.equals("Mar")||month.equals("Apr")||month.equals("May")||month.equals("Jun")||month.equals("Jul")||month.equals("Aug")||month.equals("Sep")||month.equals("Oct")||month.equals("Nov")||month.equals("Dec"))) {
			return null;
		}
		Booking b = new Booking(name,month,date,numDays,capacity,num);
		
		Date d = new Date(b.getMonth(), b.getDate());
		if(!d.check()) {
			return null;
		}
		if(!(b.getCapacity().equals("single")||b.getCapacity().equals("double"))) {
			return null;
		}
		if(b.getNumDays()<=0||b.getNum()<=0) {
			return null;
		}
		for(Hotel h : hotels) {
			if(searchRoom(h,b)!=null) {
				bookings.add(b);
				return b;
			}
		}
		return null;
	}
	
	public ArrayList<Room> searchRoom(Hotel h, Booking b){
		boolean roomEmpty = true;
		ArrayList<Room> rs = new ArrayList<Room>();
		for(int i = 0; i < b.getNum();i++) {
			for(Room r : h.getRooms()) {
				roomEmpty = true;
				if(r.getCapacity().equals(b.getCapacity())) {
					for(int j = 0;j<b.getNumDays();j++) {
						Date d1 = new Date(b.getMonth(), b.getDate());
						d1.add(j);
						//System.out.println(d1.toString());
						for(Date d2 : r.getBookingDates()) {
							if(d1.equals(d2)) {
								//System.out.println("1");
								roomEmpty = false;
							}
						}
					}
					if(roomEmpty) {
						rs.add(r);
						//System.out.println(b.getMonth());
						r.addBookingDate(b.getMonth(),b.getDate(),b.getNumDays());
						break;
					}
				}
			}
		}
		if(rs.size() == b.getNum()) {
			//System.out.println(b.getName());
			b.setRooms(rs);
			return rs;
		}
		else {
			//System.out.println(b.getName());
			return null;
		}
	}
	
	public boolean cancel(String name) {
		//System.out.println(bookings.toString());
		ArrayList<Booking> bs = new ArrayList<Booking>();
		for(Booking b : getBookings()) {
			//System.out.println("11");
			if(b.getName().equals(name)) {
				//System.out.println(b.getRooms().toString());
				for(Room r : b.getRooms()) {
					r.deleteBookingDate(b.getMonth(), b.getDate(), b.getNumDays());
				}
					bs.add(b);
			}
		}
		if(bs.size() == 0) {
			return false;
		}
		for(Booking b2 : bs) {
			bookings.remove(b2);
		}
		return true;
	}
	public boolean specificCancel(Booking b){
		ArrayList<Booking> bs = new ArrayList<Booking>();
		for(Booking b2 : getBookings()) {
			if(b2 == b) {
				for(Room r : b.getRooms()) {
					r.deleteBookingDate(b.getMonth(), b.getDate(), b.getNumDays());
				}
					bs.add(b);
			}
		}
		if(bs.size() == 0) {
			return false;
		}
		for(Booking b2 : bs) {
			bookings.remove(b2);
		}
		return true;
	} 
	
	public Booking change(String name, String month, int date, int numDays, String capacity, int num) {
		if(!(month.equals("Jan")||month.equals("Feb")||month.equals("Mar")||month.equals("Apr")||month.equals("May")||month.equals("Jun")||month.equals("Jul")||month.equals("Aug")||month.equals("Sep")||month.equals("Oct")||month.equals("Nov")||month.equals("Dec"))) {
			return null;
		}
		if(!checkDate(month, date)) {
			return null;
		}
		if(!(capacity.equals("single")||capacity.equals("double"))) {
			return null;
		}
		if(numDays<=0||num<=0) {
			return null;
		}
		ArrayList<Booking> bs = new ArrayList<Booking>();
		for(Booking b : getBookings()) {
			//System.out.println("11");
			if(b.getName().equals(name)) {
				//System.out.println(b.getRooms().toString());
				for(Room r : b.getRooms()) {
					r.deleteBookingDate(b.getMonth(), b.getDate(), b.getNumDays());
				}
					bs.add(b);
			}
		}
		if(bs.size() == 0) {
			return null;
		}
		for(Booking b1 : bs) {
			bookings.remove(b1);
		}
		Booking b2 = new Booking(name,month,date,numDays,capacity,num);
		for(Hotel h : hotels) {
			if(searchRoom(h,b2)!=null) {
				bookings.add(b2);
				return b2;
			}
		}
		for(Booking b3 : bs){
			bookings.add(b3);
			for(Room r2 : b3.getRooms()){
				r2.addBookingDate(b3.getMonth(),b3.getDate(),b3.getNumDays());
			}
		}
		return null;
	}
	
	public void displayAllOccupancy(String hotelName){
		String str = new String();
		for(Hotel h : hotels) {
			if(h.getHotelName().equals(hotelName)) {
				for(Room r : h.getRooms()) {
					str = hotelName + " "+r.getRoomNum();
					for(Booking b : bookings) {
						//System.out.println(b.getRooms().contains(r));
						if(b.getRooms().contains(r)) {
							//System.out.println("1");
							str = str + " " + b.getStrMonth()+" "+b.getDate()+" "+b.getNumDays();
						}
					}
					System.out.println(str);
				}
			}
		}
	}
	
	public void addHotel(String hotelName) {
		Hotel h = new Hotel(hotelName);
		hotels.add(h);
	}
	public void addRoom(String hotelName, int num, int capacity) {
		String c = new String();
		if(capacity == 1)
			c = "single";
		else
			c = "double";
		for(Hotel h : hotels) {
			if(h.getHotelName().equals(hotelName))
				h.addRoom(num,c);
		}
	}
	
	public Hotel hotelExist(String hotelName) {
		for(Hotel h : hotels) {
			if(h.getHotelName().equals(hotelName)) {
				return h;
			}
		}
		return null;
	}

	public boolean checkDate(String month, int date){
		if(month.equals("Jan")||month.equals("Mar")||month.equals("May")||month.equals("Jul")||month.equals("Aug")||month.equals("Oct")||month.equals("Dec")) {
			if(date <= 31) {
				return true;
			}
		}
		else if(month.equals("Feb")) {
			if(date<=28) {
				return true;
			}
		}
		else {
			if(date<=30) {
				return true;
			}
		}
		return false;
	}
	








	public static void main(String []args) throws IOException {
		HotelBookingSys system = new HotelBookingSys();
		
		Scanner sc = null;
	      try
	      {
	          sc = new Scanner(new File(args[0]));    // args[0] is the first command line argument
	          // Read input from the scanner here
	      }
	      catch (FileNotFoundException e)
	      {
	          System.out.println(e.getMessage());
	      }
	      finally
	      {
	          if (sc != null) {
	        	  while(sc.hasNextLine()) {
		        	  String[] a = sc.nextLine().split("\\ ");
		        	  if(a[0].equals("Hotel")) {
		        		  if(system.hotelExist(a[1])!=null) {
		        			  system.addRoom(a[1],Integer.valueOf(a[2]), Integer.valueOf(a[3]));
		        		  }
		        		  else {
		        			  system.addHotel(a[1]);
		        			  system.addRoom(a[1],Integer.valueOf(a[2]), Integer.valueOf(a[3]));
		        		  }
		        		  System.out.println(a[0]+" "+a[1]+" "+a[2]+" "+a[3]);
		        	  }
		        	  else if(a[0].equals("Booking")) {
		        		  int length = a.length;
						  ArrayList<Booking> bs = new ArrayList<Booking>();
		        		  for(int i = 0;i<(length-4)/2;i++) {
		        			  bs.add(system.booking(a[1], a[2], Integer.valueOf(a[3]), Integer.valueOf(a[4]), a[5+i*2], Integer.valueOf(a[6+i*2])));
		        		  }
		        		  if(bs.contains(null)) {
							  System.out.println("Booking rejected");
							  for(Booking b : bs){
								  system.specificCancel(b);
							  }
		        			  continue;
		        		  }
		        		  String str = new String();
		        		  str = "Booking "+ bs.get(0).getName() + " "+ bs.get(0).getRooms().get(0).getHotelName();
		        		  for(Booking b : bs) {
		        			  for(Room r : b.getRooms()) {
		        				  str = str+ " " + r.getRoomNum();
		        			  }
		        		  }
		        		  System.out.println(str);
		        	  }
		        	  else if(a[0].equals("Cancel")) {
		        		  //system.testMethod();
		        		  if(!system.cancel(a[1])) {
		        			  System.out.println("Cancel rejected");
		        		  }
		        		  else {
		        			  System.out.println("Cancel " + a[1]);
		        		  }
		        	  }
		        	  else if(a[0].equals("Change")) {
		        		  int length = a.length;
		        		  ArrayList<Booking> bs = new ArrayList<Booking>();
		        		  for(int i = 0;i<(length-4)/2;i++) {
		        			  bs.add(system.change(a[1], a[2], Integer.valueOf(a[3]), Integer.valueOf(a[4]), a[5+i*2], Integer.valueOf(a[6+i*2])));
		        		  }
		        		  if(bs.contains(null)) {
		        			  System.out.println("Change rejected");
		        			  continue;
		        		  }
		        		  String str = new String();
		        		  str = "Change "+ bs.get(0).getName() + " "+ bs.get(0).getRooms().get(0).getHotelName();
		        		  for(Booking b : bs) {
		        			  for(Room r : b.getRooms()) {
		        				  str = str+ " " + r.getRoomNum();
		        			  }
		        		  }
		        		  System.out.println(str);
		        	  }
		        	  else if(a[0].equals("Print")) {
		        		  system.displayAllOccupancy(a[1]);
		        	  }
	        	  }
	        	  sc.close();
	          }
	      }
	}
}
