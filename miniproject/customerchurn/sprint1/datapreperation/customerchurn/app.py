import numpy as np
from flask import Flask, request, jsonify, render_template
import sklearn
import pickle
import joblib
# from tensorflow.keras.models import load_model

app = Flask(__name__)


rf_model = joblib.load('churn_predict_model (1).pkl')


loaded_models = {
   
    'rf': rf_model,
}   

# Function to decode predictions 
def decode(pred):
    if pred == 1: return 'Customer Exits'
    else: return 'Customer Stays'

@app.route('/')
def home():
    # Initial rendering
    result = [
              {'model': 'Random Forest', 'prediction': ' '}
            
              ]
    
    # Create main dictionary
    maind = {}
    maind['customer'] = {}
    maind['predictions'] = result

    return render_template('Index.html', maind=maind)

@app.route('/predict', methods=['POST'])
def predict():

    # List values received from index
    values = [x for x in request.form.values()]

    # new_array - input to models
    new_array = np.array(values).reshape(1, -1)
    print(new_array)
    print(values)
    
    # Key names for customer dictionary custd
    cols = ['CreditScore',
            'Gender',
            'Age',
            'Tenure',
            'Balance',
            'NumOfProducts',
            'HasCrCard',
            'IsActiveMember',
            'EstimatedSalary']

    # Create customer dictionary
    custd = {}
    for k, v in  zip(cols, values):
        custd[k] = v

    # Convert 1 or 0 to Yes or No    
    yn_val = ['HasCrCard', 'IsActiveMember']
    for val in  yn_val:
        if custd[val] == '1': custd[val] = 'Yes'
        else: custd[val] = 'No'

    # Loop through 'loaded_models' dictionary and
    # save predictiond to the list
    predl = []
    for m in loaded_models.values():
        predl.append(decode(m.predict(new_array)[0]))

    result = [
           
            {'model': 'Random Forest', 'prediction': predl[0]}
            
            ]

    # Create main dictionary
    maind = {}
    maind['customer'] = custd
    maind['predictions'] = result

    return render_template('Result.html', maind=maind)


if __name__ == "__main__":
    app.run(debug=True)