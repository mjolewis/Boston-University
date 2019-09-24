"""
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 2
Date: 9/11/19
Homework Problem: 3.5
"""

import math

"""A simple program to compute the area of a regular polygon"""

def calculateAreaOfRegularPolygon(numberOfSides, lengthOfSides):
    """Calculate the area of a regular polygon and return the result"""
    return (numberOfSides * lengthOfSides ** 2) / (4 * math.tan(math.pi / numberOfSides))

def main():
    numberOfSides = eval(input("Enter the number of sides: "))
    lengthOfSides = eval(input("Enter the side length: "))
    print("The area of the polygon is " + format(calculateAreaOfRegularPolygon(numberOfSides, lengthOfSides)))

if __name__ == "__main__":
    main()
else:
    pass