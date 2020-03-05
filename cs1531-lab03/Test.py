from Booking import Booking
from Car import Car,small,medium,large,premium
from Customer import Customer
print('#test 1  small car')
first_customer = Customer('aaa',20,4125,'12345678@gmail.com')
first_car = small('small',1,1,1,1,1,500)
Rental_period = 5
first = Booking(first_customer,first_car,Rental_period,'UNSW','Kingsford')
print(first,'\n')

