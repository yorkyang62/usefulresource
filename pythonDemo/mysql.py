from flask import Flask
from flask import jsonify
from flaskext.mysql import MySQL

app = Flask(__name__)
mysql = MySQL()
app.config['MYSQL_DATABASE_USER'] = 'root'
app.config['MYSQL_DATABASE_PASSWORD'] = ''
app.config['MYSQL_DATABASE_DB'] = 'pythonDemo'
app.config['MYSQL_DATABASE_HOST'] = 'localhost'
mysql.init_app(app)
conn = mysql.connect()
cursor =conn.cursor()

cursor.execute("SELECT * from user")
data = cursor.fetchall()
a = []
for i in data:  
    a.append({'id':i[0],'name':i[1]})
print(a);
