from flask import Flask, render_template, Response
import cv2
import numpy as np
from tensorflow.keras.models import load_model

app = Flask(__name__)

# Load the trained eye disease detection model
model = load_model('eye2.h5')

# Define the disease categories
labels = ['bulging_eye', 'Cataract', 'normal', 'uvetis']

def preprocess_image(img):
    img = cv2.resize(img, (200, 200))
    img = img.astype('float32') / 255.0
    img = np.expand_dims(img, axis=0)
    return img

def detect_eye_disease(frame):
    # Detect the eyes in the input frame
    eye_cascade = cv2.CascadeClassifier('haarcascade_eye.xml')
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    eyes = eye_cascade.detectMultiScale(gray, scaleFactor=1.3, minNeighbors=5)

    # Loop over each eye detected in the frame
    for (ex,ey,ew,eh) in eyes:
        # Extract the eye image from the frame
        eye_img = frame[ey:ey+eh, ex:ex+ew]

        # Preprocess the eye image for input to the model
        eye_img = preprocess_image(eye_img)

        # Predict the disease category for the eye image
        pred = model.predict(eye_img)[0]

        # Get the label of the predicted category
        label = labels[np.argmax(pred)]

        # Draw the predicted label on the frame
        cv2.putText(frame, label, (ex, ey-10), cv2.FONT_HERSHEY_SIMPLEX, 0.7, (0, 255, 0), 2)

        # Draw a rectangle around the eye in the frame
        cv2.rectangle(frame, (ex,ey), (ex+ew,ey+eh), (0,255,0), 2)

    return frame

@app.route('/')
def index():
    return render_template('index.html')

def gen():
    cap = cv2.VideoCapture(0)
    while True:
        ret, frame = cap.read()
        if not ret:
            break
        else:
            frame = detect_eye_disease(frame)
            ret, jpeg = cv2.imencode('.jpg', frame)
            frame = jpeg.tobytes()
            yield (b'--frame\r\n'
                   b'Content-Type: image/jpeg\r\n\r\n' + frame + b'\r\n')

@app.route('/video_feed')
def video_feed():
    return Response(gen(),
                    mimetype='multipart/x-mixed-replace; boundary=frame')

if __name__ == '__main__':
    app.run(debug=True)