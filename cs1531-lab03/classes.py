from abc import ABC, abstractmethod

class staff:
        def __init__(self, username, password):
    # Define attributes
       self.username = username
       self.password = password

    @property
    def username(self):
        return self.username

    @username.setter
    def name(self, username):
        self.username = username

    @property
    def password(self):
        return self.password

    @password.setter
    def name(self, password):
        self.password = password

class adminSystem:

    def email_customer(self):
        print("Example car data")

    def add_car(self, typeCar, make, model, year, dailyFee, status, rego):


class manager(staff):
    def log_data(self):
        print("example data")

class car(ABC):
    def __init__(self, make, model, year, dailyFee, status, rego)
    self.make = make
    self.model = model
    self.year = year
    self.dailyFee = dailyFee
    self.status = status
    self.rego = rego

    @property 
    def make(self):
        return self.make

    @make.setter(self, make)
        self.make = make 

    @property 
    def model(self):
        return self.model

    @model.setter(self, model)
        self.model = model 

    @property 
    def year(self):
        return self.year

    @year.setter(self, year)
        self.year = year 

    @property 
    def dailyFee(self):
        return self.dailyFee

    @dailyFee.setter(self, dailyFee)
        self.dailyFee = dailyFee 

    @property 
    def status(self):
        return self.status

    @status.setter(self, status)
        self.status = status 

    @property 
    def rego(self):
        return self.rego

    @rego.setter(self, rego)
        self.rego = rego 

class small(car):
    def __init__(self, typeCar, make, model, year, dailyFee, status, rego)
    self.typeCar = typeCar
    super(small, self).__init__(make, model, year, dailyFee, status, rego)

    @property 
    def typeCar(self):
        return self.typeCar

    @typeCar.setter(self, typeCar)
        self.typeCar = typeCar 

class medium(car):
    def __init__(self, typeCar, make, model, year, dailyFee, status, rego)
    self.typeCar = typeCar
    super(medium, self).__init__(make, model, year, dailyFee, status, rego)

    @property 
    def typeCar(self):
        return self.typeCar

    @typeCar.setter(self, typeCar)
        self.typeCar = typeCar 

class large(car):
    def __init__(self, typeCar, make, model, year, dailyFee, status, rego)
    self.typeCar = typeCar
    super(large, self).__init__(make, model, year, dailyFee, status, rego)

    @property 
    def typeCar(self):
        return self.typeCar

    @typeCar.setter(self, typeCar)
        self.typeCar = typeCar 

class premium(car):
    def __init__(self, typeCar, make, model, year, dailyFee, status, rego)
    self.typeCar = typeCar
    super(premium, self).__init__(make, model, year, dailyFee, status, rego)

    @property 
    def typeCar(self):
        return self.typeCar

    @typeCar.setter(self, typeCar)
        self.typeCar = typeCar 

    

class carSystem:
    def __init__(self, name, age):
    # Define attributes
        

class payment: