from server import app, valid_time
from flask import request, render_template
from Calculator import Calculator


@app.route('/', methods=['POST', 'GET'])
def interest_total():
    if request.method == 'POST':
        amount = float(request.form["amount"])
        time = float(request.form["time"])
        rate = float(request.form["rate"])
        cal = Calculator(amount,rate)
        ans = cal.total_interest(time)
        return render_template('interest_form.html',total = ans,calc_total = True)
    return render_template('interest_form.html', calc_total=True)


@app.route('/time', methods=['POST', 'GET'])
def time_interest():
    if request.method == 'POST':
        amount = float(request.form["amount"])
        interest = float(request.form["total"])
        rate = float(request.form["rate"])
        cal = Calculator(amount,rate)
        ans = cal.time_required(interest)
        return render_template('interest_form.html',time = ans,time_total = True)
    return render_template('interest_form.html', time_total=True)


@app.route('/credits', methods=['GET'])
def credits():
    return render_template('credits.html',name = 'Evan in 2018')
