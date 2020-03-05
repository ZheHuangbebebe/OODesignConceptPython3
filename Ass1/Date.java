
public class Date {

	private int month;
	private int date;
	String months[] = {
		      "Jan", "Feb", "Mar", "Apr",
		      "May", "Jun", "Jul", "Aug",
		      "Sep", "Oct", "Nov", "Dec"};
	
	public Date(int month,int date) {
		this.month = month;
		this.date = date;
	}
	
	public int getDate() {
		return date; 
	}
	
	public int getMonth() {
		return month;
	}
	
	public boolean check() {
		if(month == 0||month == 2||month == 4||month == 6||month == 7||month == 9||month == 11) {
			if(date <= 31) {
				return true;
			}
		}
		else if(month == 1) {
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
	
	public void add(int num) {
		this.date = date + num;
		if(this.month == 0||this.month == 2||this.month == 4||this.month == 6||this.month == 7||this.month == 9||this.month == 11) {
			if(date>31) {
				this.date = date-31;
				this.month = month+1;
			}
		}
		else if(this.month == 1) {
			if(date>28) {
				this.date = date - 28;
				this.month = month+1;
			}
		}
		else {
			if(this.date > 30) {
				this.date = date -30;
				this.month = month+1;
			}
		}
	}
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if(date == ((Date) o).getDate() && month == ((Date) o).getMonth())
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return months[month]+"/"+date;
	}
	
	
}
