#!/usr/bin/python
# -*- coding: utf-8 -*-
import json
from flask import Flask
from flask import request
from flask import redirect
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

@app.route('/' , methods=['GET', 'POST'])
def index():
    a = []
    param = {'id':request.values.get('id'),'name':request.values.get('name')}
    cursor.execute("SELECT * from user where id="+param['id'])
    data = cursor.fetchall()
    for i in data:  
        a.append({'id':i[0],'name':i[1]})
    return json.dumps(a)

@app.route('/user/<name>')
def haha(name):
    return test()+'<h1>hello, %s</h1>' % name
def test():
    return 'test'

if __name__ =='__main__':
    app.run(debug=True)
