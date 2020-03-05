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
