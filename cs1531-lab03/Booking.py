from Customer import Customer
from Car import Car
class Booking:
    def __init__(self,Customer,Car,period,pickup,dropoff):
        self.Customer = Customer
        self.Car = Car
        self.period = period
        self.pickup = pickup
        self.dropoff = dropoff
    def calculate_fee(Car,period):
        if Car.typeCar == 'large':
            if period <= 7:
                return int(Car.dailyFee*period+0.5)
            else:
                return int(0.95*Car.dailyFee*period+0.5)
        elif Car.typeCar == 'premium':
            if period > 7:
                return int(0.95*1.15*Car.dailyFee*period+0.5)
            else:
                return int(1.15*Car.dailyFee*period+0.5)
        else:
            return int(Car.dailyFee*period+0.5)
    def __str__(self):
        return 'Customer name: '+self.Customer.name+'\n'+'typeFee of car: '+self.Car.typeCar+'\n'+'Rental period: '+str(self.period)+'\n'+'Rental fee: '+str(Booking.calculate_fee(self.Car,self.period))

