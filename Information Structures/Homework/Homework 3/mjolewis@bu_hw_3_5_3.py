"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 3
Date: 9/25/19
Homework Problem: 5.3
"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""

"""A simple program to display a kilogram to pound conversion table"""

def main():
    KILOS_TO_POUND = 2.2
    print("Kilograms   Pounds")
    print() # Jump to new line

    # Display the body of the table
    for i in range(1, 200):
        print(format(i, "<3d") + format(i * KILOS_TO_POUND, ">15.1f"))
        print()


if __name__ == "__main__":
    main()
else:
    print("Not in main")