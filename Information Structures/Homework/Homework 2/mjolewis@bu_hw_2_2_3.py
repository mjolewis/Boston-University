"""
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 2
Date: 9/11/19
Homework Problem: 2.3
"""

"""A simple program to convert feet into meters"""

def meterConverter(numberOfFeet):
    """Convert feet into meters and return the result"""
    meterPerFoot = .305
    return (numberOfFeet * meterPerFoot)

def main():
    feet = eval(input("Enter a value for feet: "))
    print(format(feet, ".1f") + " feet is " + format(meterConverter(feet), ".4f") + " meters")

if __name__ == "__main__":
    main()
else:
    print("Not in main")