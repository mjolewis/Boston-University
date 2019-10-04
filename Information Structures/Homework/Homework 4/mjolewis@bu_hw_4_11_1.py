"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 4
Date: 9/24/19
Homework Problem: 11.1
"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""

"""A simple program to sum all of the elements in a specified column in a matrix"""

def sumColumn(m, columnIndex):
    total = float(m[0][columnIndex]) + float(m[1][columnIndex]) + float(m[2][columnIndex])
    print("Sum of elements for column " + str(columnIndex) + " is " + str(total))

def main():
    # Get the row input from the user
    input0 = input("Enter a 3-by-4 matrix row for row 0: ")
    input1 = input("Enter a 3-by-4 matrix row for row 1: ")
    input2 = input("Enter a 3-by-4 matrix row for row 2: ")

    # Split the input into a list
    row0 = input0.split()
    row1 = input1.split()
    row2 = input2.split()

    # Split the input into columns
    matrix = [row0, row1, row2]
    print(matrix[0][0])

    for column in range(0, 4):
        sumColumn(matrix, column)



if __name__ == "__main__":
    main()
else:
    print("Not in main")