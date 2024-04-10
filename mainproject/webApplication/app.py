from __future__ import division, print_function
# coding=utf-8
import sys
import os
import glob
import re
import numpy as np

# Keras

from keras.models import load_model
from keras.preprocessing import image
from PIL import Image

import tensorflow as tf

#model = tf.keras.models.load_model('model/malaria_resnet18.h5')

# Flask utils
from flask import Flask, redirect, url_for, request, render_template
from werkzeug.utils import secure_filename
from gevent.pywsgi import WSGIServer

# Define a flask app
app = Flask(__name__)

# Model saved with Keras model.save()


custom_objects = {}
# Load your trained model
model1 = tf.keras.models.load_model('model/malaria_resnet18.h5', custom_objects=custom_objects)
model2 = tf.keras.models.load_model('model/malaria_vgg16.h5', custom_objects=custom_objects)
model3 = tf.keras.models.load_model('model/malaria_vgg19.h5', custom_objects=custom_objects)
# model._make_predict_function()  # Necessary
print('Model loaded. Start serving...')

print('Model loaded. Check http://127.0.0.1:5000/')


def model_predict(img_path, model):
    img = image.load_img(img_path, target_size=(130, 130))

    # Preprocessing the image
    x = image.img_to_array(img)
    # x = np.true_divide(x, 255)
    x = np.expand_dims(x, axis=0)

    # Be careful how your trained model deals with the input
    # otherwise, it won't make correct prediction!
    # x = preprocess_input(x, mode='caffe')
    images = np.vstack([x])

    preds = model.predict(images, batch_size=32)
    print(preds, flush=True)
    return preds



@app.route('/', methods=['GET'])
def home():
    # Main page
    return render_template('home.html')


@app.route('/index', methods=['GET', 'POST'])
def index():
    return render_template('index.html')


@app.route('/predict', methods=['POST'])
def upload():
    if request.method == 'POST':
        # Get the file from post request
        f = request.files['file']

        # Save the file to ./uploads
        basepath = os.path.dirname(__file__)
        file_path = os.path.join(
            basepath, 'uploads', secure_filename(f.filename))
        f.save(file_path)


        

        # Make predictions using other models
        preds1 = model_predict(file_path, model1)
        preds2 = model_predict(file_path, model2)
        preds3 = model_predict(file_path, model3)

        '''selected_model = request.form.get('model')

        
# Process prediction results
    result1 = "Uninfected" if preds1[0] > 0.5 else "Infected"
    return f"ResNet18 : {result1}"
    #print("ResNet18:", result1)
    
    result2 = "Uninfected" if preds2[0] > 0.5 else "Infected"
    return f"VGG16 : {result2}"
    #print("VGG16:", result1)
    result3 = "Uninfected" if preds3[0]> 0.5 else "Infected"
    return f"VGG19 : {result3}"
    #print("VGG19:", result1)
        # Return the combined result
    return f"ResNet: {result1}, VGG16: {result2}, VGG19: {result3}"'''
    
    # Process prediction results
        result1 = "Uninfected" if preds1[0] > 0.5 else "Infected"
        result2 = "Uninfected" if preds2[0] > 0.5 else "Infected"
        result3 = "Uninfected" if preds3[0] > 0.5 else "Infected"
        
    
    
     # Return the predictions of all models
    return {
            
            'model1': result1,
            'model2': result2,
            'model3': result3
        }
    

    return None


if __name__ == '__main__':
    app.run(debug=True)
