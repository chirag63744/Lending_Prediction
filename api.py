import numpy as np
from flask import Flask, request,jsonify,make_response
import sklearn
import numpy
import pickle
import json

app = Flask(__name__)
model = pickle.load(open('ml_modelee.pkl', 'rb'))
#model1 = pickle.load(open('P4.pkl', 'rb'))

# Opening JSON file
#f = open("data.json")

# returns JSON object as
# a dictionary



@app.route('/json',methods=['POST'])
def json():
    # if request.method == 'POST':
    data = request.get_json()
    Gender = float(data['Gender'])
    Married = float(data['Married'])
    Dependents = float(data['Dependents'])
    Education = float(data['Education'])
    Self_Employed = float(data['Self_Employed'])
    ApplicantIncome = float(data['ApplicantIncome'])
    coapplicantIncome = float(data['coapplicantIncome'])
    LoanAmount = float(data['LoanAmount'])
    Loan_Amount_Term = float(data['Loan_Amount_Term'])
    Credit_History = float(data['Credit_History'])
    Property_Area = float(data['Property_Area'])
    #print(data['IFW'])
    array = np.array([[Gender, Married, Dependents, Education, Self_Employed, ApplicantIncome, coapplicantIncome,
                       LoanAmount, Loan_Amount_Term, Credit_History,Property_Area ]])
    pre=model.predict(array)
    fpre=int(pre)
    jpre={'pre':fpre}
    print(pre)
    r = make_response(jpre)
    r.mimetype = 'application/json'
    return r


if __name__=='__main__':
    app.run(debug=True)