# creating basic flask application - set up flask 
from flask import Flask , request
from flask_sqlalchemy import SQLAlchemy   # setting up db : sqlalchemy 

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///data.db'
db = SQLAlchemy(app)

class Drink(db.Model):  #db.model --> sqlAlchemy (ORM)
    #define columns
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(80), unique=True, nullable=False)
    description = db.Column(db.String(120))

    #overriding another method
    def __repr__(self):
        return f"{self.name} - {self.description}"  # it will be invoked when trying to print out the drink in the list 
    




# make a route 
@app.route('/')
def index():    #defining method when you hit the route 
    return 'Hello!'  

@app.route('/drinks')
def get_drinks():
    drink = Drink.query.all()

    output =[]
    for alldrinks in drink:
        drink_data = {"name": alldrinks.name , "description": alldrinks.description}
        output.append(drink_data)


    return {"drinks": output}

@app.route('/drinks/<id>')
def get_drink(id):
    drinks = Drink.query.get_or_404(id)
    return {"name": drinks.name , "description": drinks.description} # here you are working with dictionary 

    # if you are not working with dictionary then,
    # return jsonify ({......}) 

#add the item 
@app.route('/drinks',methods=['POST'])
def add_drinks():
    drink = Drink(name=request.json['name'], description=request.json['description'])
    db.session.add(drink)
    db.session.commit()
    return {'id': drink.id}


