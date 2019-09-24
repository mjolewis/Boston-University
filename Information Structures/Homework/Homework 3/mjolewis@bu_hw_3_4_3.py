"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 3
Date: 9/25/19
Homework Problem: 4.3
"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""

"""A simple program to solve 2 x 2 linear equations"""

def calculateCramersFirstEquation(a, b, c, d, e, f):
    return (e * d - b * f) / (a * d - b * c)

def calculateCramersSecondEquation(a, b, c, d, e, f):
    return (a * f - e * c) / (a * d - b * c)

def main():
    a, b, c, d, e, f = eval(input("Enter a, b, c, d, e, f: "))
    if (a * d - b * c == 0):
        print("The equation has no solution")
    else:
        x = calculateCramersFirstEquation(a, b, c, d, e, f)
        y = calculateCramersSecondEquation(a, b, c, d, e, f)

        print("x is " + format(x, ".1f") + " and y is " + format(y, ".1f"))
    
if __name__ == "__main__":
    main()
else:
    print("Not in main")