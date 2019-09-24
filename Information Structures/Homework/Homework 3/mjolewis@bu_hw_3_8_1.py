"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 3
Date: 9/25/19
Homework Problem: 8.1
"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""

"""A simple program to check if the user has entered a valid SSN"""

def validSSN(ssn):
    tmpSSN = list(ssn)
    isValidSSN = True

    for i, n_char in enumerate(tmpSSN):
        if i in range(0, 3):
            if ord(n_char) < 48 or ord(n_char) > 57:
                isValidSSN = False
        elif (i == 3 or i == 6):
            if ord(n_char) != 45:
                isValidSSN = False
        elif i in range(4, 6):
            if ord(n_char) < 48 or ord(n_char) > 57:
                isValidSSN = False
        else:
            if ord(n_char) < 48 or ord(n_char) > 57:
                isValidSSN = False

    return isValidSSN

def main():
    ssn = (input("Enter your social security number: ")).strip()
    if (validSSN(ssn)):
        print("Valid SSN")
    else:
        print("Invalid SSN")

if __name__ == "__main__":
    main()
else:
    print("Not in main")