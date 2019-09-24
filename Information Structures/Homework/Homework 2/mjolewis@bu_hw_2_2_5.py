"""
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 2
Date: 9/11/19
Homework Problem: 2.5
"""

"""A simple program to convert feet into meters"""

def calculateBill(subtotal, gratuityRate):
    """Calculate payment due based on given subtotal and gratuity rate"""
    return subtotal + (subtotal * (gratuityRate / 100))

def main():
    subtotal, gratuityRate = eval(input("Enter the subtotal and a gratuity rate: "))
    totalBill = calculateBill(subtotal, gratuityRate)
    print("The gratuity is $" + format(totalBill - subtotal, ".2f") + " and the total is $" + format(totalBill, ".2f"))

if __name__ == "__main__":
    main()
else:
    print("Not in main")