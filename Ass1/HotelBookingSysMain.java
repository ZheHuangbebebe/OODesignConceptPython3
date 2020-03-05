

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class HotelBookingSysMain {

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
