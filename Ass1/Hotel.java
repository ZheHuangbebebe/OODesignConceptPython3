
import java.util.ArrayList;


public class Hotel{
	private String hotelName;
	private ArrayList<Room> rooms;
	
	public String getHotelName() {
		return hotelName;
	}
	
	public ArrayList<Room> getRooms(){
		return rooms;
	}
	
	public Hotel(String name) {
		this.hotelName = name;
		rooms = new ArrayList<Room>();
	}
	
	public Room addRoom(int roomNum,String capacity) {
		Room r = new Room(roomNum, capacity,hotelName);
		rooms.add(r);
		return r;
	}

	@Override
	public String toString() {
		String str = new String();
		str = "Hotel name: "+this.hotelName+"\n"+"Rooms list: "+"\n";
		for(Room r : this.rooms) {
			str = str + r.getRoomNum()+"\n";
		}
		return str;
	}
	
}
