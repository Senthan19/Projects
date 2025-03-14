# import  libraries
import os
import scipy
import numpy as np
import tensorflow as tf
from tensorflow import keras
import matplotlib.pyplot as plt
from tensorflow.keras import layers
from keras.optimizers import Adam
from keras.layers import Conv2D, MaxPooling2D
from tensorflow.keras.models import load_model
from tensorflow.keras.preprocessing import image
from keras.layers import Activation, Dense, Flatten, Dropout
from tensorflow.keras.preprocessing.image import ImageDataGenerator

# Image Augmentation for train and validation
train_datagen = ImageDataGenerator(
    rescale=1. / 255,
    rotation_range=20,
    width_shift_range=0.3,
    height_shift_range=0.3,
    horizontal_flip=True,
    fill_mode='nearest'
)

val_datagen = ImageDataGenerator(
    rescale=1. / 255,
    rotation_range=20,
    width_shift_range=0.3,
    height_shift_range=0.3,
    horizontal_flip=True,
    fill_mode='nearest'
)

# Import a Path For Train And Validation
train_data = train_datagen.flow_from_directory(
    'D:\\Dataset\\Training',
    target_size=(200, 200),
    batch_size=32,
    class_mode='categorical'
)
val_data = val_datagen.flow_from_directory(
    'D:\\Dataset\\Validating',
    target_size=(200, 200),
    batch_size=32,
    class_mode='categorical'
)

# Create A Model
model = keras.Sequential([
    layers.Conv2D(32, (3, 3), activation='relu', input_shape=(200, 200, 3)),
    layers.MaxPooling2D((2, 2)),
    layers.Conv2D(64, (3, 3), activation='relu'),
    layers.MaxPooling2D((2, 2)),
    layers.Conv2D(128, (3, 3), activation='relu'),
    layers.MaxPooling2D((2, 2)),
    layers.Flatten(),
    layers.Dense(128, activation='relu'),
    layers.Dense(4, activation='softmax')
])

model.summary()

# Model Compliation
model.compile(
    optimizer='adam',
    loss='categorical_crossentropy',
    metrics=['accuracy']
)

# History Of Model
history = model.fit(train_data,
                    validation_data=val_data,
                    epochs=30
                    )

# save model
model.save('eye2.h5')
