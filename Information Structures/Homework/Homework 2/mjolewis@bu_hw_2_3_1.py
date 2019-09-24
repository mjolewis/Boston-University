"""
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 2
Date: 9/11/19
Homework Problem: 3.1
"""

import math

"""A simple program to calculate the area of a pentagon"""

def calculateAreaOfPentagon(radius):
    """Compute the area of a pentagon and return the result"""
    return (3 * math.sqrt(3) / 2) * calulateLengthOfSide(radius) ** 2

def calulateLengthOfSide(radius):
    """Compute the length of the side of a pentagon and return the result"""
    return (2 * radius) * math.sin(math.pi / 5)



def main():
    radius = eval(input("Enter the length from the center to a vertex: "))
    print("The area of the pentagon is " + format(calculateAreaOfPentagon(radius), ".2f"))

if __name__ == "__main__":
    main()
else:
    print("Not in main")