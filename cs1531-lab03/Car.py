#from abc import ABC, abstractclassmethod
class Car(object):
    def __init__(self, make, model, year, dailyFee, status, rego):
        pass
    @property 
    def make(self):
        return self.make

    @make.setter
    def make(self):
        self.make = make 

    @property 
    def model(self):
        return self.model

    @model.setter
    def model(self):
        self.model = model 

    @property 
    def year(self):
        return self.year

    @year.setter
    def year(self):
        self.year = year 

    @property 
    def dailyFee(self):
        return self.dailyFee

    @dailyFee.setter
    def dailyFee(self):
        self.dailyFee = dailyFee 

    @property 
    def status(self):
        return self.status

    @status.setter
    def status(self):
        self.status = status 

    @property 
    def rego(self):
        return self.rego

    @rego.setter
    def rego(self):
        self.rego = rego 

class small(Car):
    def __init__(self, typeCar,make, model, year, dailyFee, status, rego):
        self.typeCar = typeCar
        super(small, self).__init__(make, model, year, dailyFee, status, rego)

#    @property 
#    def typeCar(self):
#        return self.typeCar

#    @typeCar.setter
#    def typeCar(self):
#        self.typeCar = typeCar 

class medium(Car):
    def __init__(self, typeCar, make, model, year, dailyFee, status, rego):
        self.typeCar = typeCar
        super(medium, self).__init__(make, model, year, dailyFee, status, rego)

    @property 
    def typeCar(self):
        return self.typeCar

    @typeCar.setter
    def typeCar(self):
        self.typeCar = typeCar 

class large(Car):
    def __init__(self, typeCar, make, model, year, dailyFee, status, rego):
        self.typeCar = typeCar
        super(large, self).__init__(make, model, year, dailyFee, status, rego)

    @property 
    def typeCar(self):
        return self.typeCar

    @typeCar.setter
    def typeCar(self):
        self.typeCar = typeCar 

class premium(Car):
    def __init__(self, typeCar, make, model, year, dailyFee, status, rego):
        self.typeCar = typeCar
        super(premium, self).__init__(make, model, year, dailyFee, status, rego)

    @property 
    def typeCar(self):
        return self.typeCar

    @typeCar.setter
    def typeCar(self):
        self.typeCar = typeCar 