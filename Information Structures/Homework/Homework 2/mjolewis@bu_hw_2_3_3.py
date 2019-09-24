"""
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 2
Date: 9/11/19
Homework Problem: 3.3
"""

import math

"""Compute the esitmated area enclosed by Atlanta, Georgia; Orlando, Florida; Savannah, Georgia; and Charlotte, 
North Carolina using the GPS data from www.gps-data-team.com/map/"""

def greatCircleDistance(x1, y1, x2, y2):
    """Compute the great distance (distance between two points on the surface of a sphere") and return the result"""
    AVERAGE_EARTH_RADIUS_IN_KILOMETERS = 6371.01

    # Convert latitude and longitude (x1, x2, y1, y2) into radians
    x1Radians = math.radians(x1)
    y1Radians = math.radians(y1)
    x2Radians = math.radians(x2)
    y2Radians = math.radians(y2)

    # Formula for The Great Circle Distance between two points
    distance = AVERAGE_EARTH_RADIUS_IN_KILOMETERS * math.acos(math.sin(x1Radians) * math.sin(x2Radians) + math.cos(x1Radians) * math.cos(x2Radians) * math.cos(y1Radians - y2Radians))

    return distance

def areaOfTriangle(side1, side2, side3):
    """Calculate the area of a triangle using the length of the three sides and return the result"""
    s = (side1 + side2 + side3) / 2
    return (s * (s - side1) * (s - side2) * (s - side3)) ** 0.5 # Area of a triangle

def calculateArea(x1, y1, x2, y2, x3, y3, x4, y4):
    """This method treats the polygon as two distinct triangles, computes the area for each triangle, and sums the result to calculate the area of the polygon"""
    
    # Calculate the side lengths of the first triangle
    side1 = greatCircleDistance(x1, y1, x2, y2)
    side2 = greatCircleDistance(x1, y1, x4, y4)
    side3 = greatCircleDistance(x2, y2, x4, y4)

    # Calculate the side lengths of the second triangle
    side4 = greatCircleDistance(x2, y2, x3, y3)
    side5 = greatCircleDistance(x3, y3, x4, y4)
    side6 = greatCircleDistance(x2, y2, x4, y4)

    # Calculate the area of both triangles
    triangle1 = areaOfTriangle(side1, side2, side3)
    triangle2 = areaOfTriangle(side4, side5, side6)

    return triangle1 + triangle2

def main():
    # Manual longitude and latitude input from www.gps-data-team.com/map/
    ATLANTA_LONGITUDE = -84.3879824
    ATLANTA_LATITUDE = 33.7489954

    ORLANDO_LONGITUDE = -81.379234
    ORLANDO_LATITUDE = 28.538336

    SAVANNAH_LONGITUDE = -81.0998342
    SAVANNAH_LATITUDE = 32.0835407

    CHARLOTTE_LONGITUDE = -80.8431267
    CHARLOTTE_LATITUDE = 35.2270869

    estimatedArea = calculateArea(ATLANTA_LONGITUDE, ATLANTA_LATITUDE, ORLANDO_LONGITUDE, ORLANDO_LATITUDE, SAVANNAH_LONGITUDE, SAVANNAH_LATITUDE, CHARLOTTE_LONGITUDE, CHARLOTTE_LATITUDE)
    print("The estimated area enclosed by Atlanta, Orlando, Savannah, and Charlotte is: " + format(estimatedArea, ".4f") + " square kilometers")


if __name__ == "__main__":
    main()
else:
    print("Not in main")