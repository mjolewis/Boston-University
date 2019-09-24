"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 3
Date: 9/25/19
Homework Problem: 4.1
"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""

"""A simple program to calculate the quadrtic roots"""

def calculateDiscriminantValue(a, b, c):
    return (b ** 2) - (4 * a * c)

def calculateFirstQuadraticRoot(a, b, c):
    return (-b + calculateDiscriminantValue(a, b, c) ** 0.5) / (2 * a)

def calculateSecondQuadraticRoot(a, b, c):
    return (-b - calculateDiscriminantValue(a, b, c) ** 0.5) / (2 * a)

def main():
    a, b, c = eval(input("Enter a, b, c: "))

    if (calculateDiscriminantValue(a, b, c) > 0):
        root1 = calculateFirstQuadraticRoot(a, b, c)
        root2 = calculateSecondQuadraticRoot(a, b, c)
        print("The roots, rounded to two decimal places, are " + format(root1, ".2f") + " and " + format(root2, ".2f"))
    elif (calculateDiscriminantValue(a, b, c) == 0):
        root1 = calculateFirstQuadraticRoot(a, b, c)
        print("The root, rounded to two decimnal places, is " + format(root1, ".2f"))
    else:
        print("The equation has no real roots")


if __name__ == "__main__":
    main()
else:
    print("Not in main")