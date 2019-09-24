"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 3
Date: 9/25/19
Homework Problem: 5.1
"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""

"""A simple program to count the number of input values and return the total and average results"""

def main():
    data = eval(input("Enter an integer, the input ends if it is 0: "))

    sum = 0
    positiveNumberCount = 0
    negativeNumberCount = 0
    while data != 0:
        sum += data

        if data > 0:
            positiveNumberCount += 1
        else:
            negativeNumberCount += 1

        data = eval(input("Enter an integer, the input ends if it is 0: "))
    
    print("The number of positives is: " + str(positiveNumberCount))
    print("The number of negatives is: " + str(negativeNumberCount))
    print("The total is: " + str(sum))
    print("The average is: " + str(sum / (positiveNumberCount + negativeNumberCount)))
    
if __name__ == "__main__":
    main()
else:
    print("Not in main")