"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 4
Date: 9/24/19
Homework Problem: 10.1
"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""

"""A simple program to read a list of scores and assign each score a grade"""

def calculateGrade(grades):
    maxGrade = int(max(grades))

    for index, grade in enumerate(grades):
        if (int(grade) >= maxGrade - 10):
            print("Student " + str(index) + " score is " + grade + " and grade is A")
        elif (int(grade) >= maxGrade - 20):
            print("Student " + str(index) + " score is " + grade + " and grade is B")
        elif (int(grade) >= maxGrade - 30):
            print("Student " + str(index) + " score is " + grade + " and grade is C")
        elif (int(grade) >= maxGrade - 40):
            print("Student " + str(index)+ " score is " + grade + " and grade is D")
        else:
            print("Student " + str(index) + " score is " + grade + " and grade is F")

def main():
    # Prompt user for grade input
    data = input("Enter scores: ")

    # Split the scores into a list
    grades = data.split()
    calculateGrade(grades)


if __name__ == "__main__":
    main()
else:
    print("Not in main")