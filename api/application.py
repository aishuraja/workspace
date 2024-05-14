# creating basic flask application - set up flask 
from flask import Flask
app = Flask(__name__)
from flask_sqlalchemy import SQLAlchemy 


app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///data.db'
db = SQLAlchemy(app)

class Drink(db.Model):  #db.model --> sqlAlchemy (ORM)
    #define columns
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(80), unique=True, nullable=False)
    description = db.Column(db.String(120))

    #overriding another method
    def __refr__(self):
        return f"{self.name} - {self.description}"  # it will be invoked when trying to print out the drink in the list 
    



# make a route 
@app.route('/')
def index():    #defining method when you hit the route 
    return 'Hello!'  

@app.route('/drinks')
def get_drinks():
    return {"drinks": "drink data"}