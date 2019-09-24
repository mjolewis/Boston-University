"""
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 2
Date: 9/11/19
Homework Problem: 2.1
"""

"""A simple program to convert Celsius to Fahrenheit"""

def fahrenheitConverter(degrees):
    """Convert Celsius to Fahrenheit and return the result"""
    return (9 / 5) * degrees + 32

def main():
    celsius = eval(input("Enter a degree in Celsius: "))
    print(format(celsius, ".1f") + " Celsius is " + format(fahrenheitConverter(celsius), ".1f") + " Fahrenheit")

if __name__ == "__main__":
    main()
else:
    print("Not in main")
