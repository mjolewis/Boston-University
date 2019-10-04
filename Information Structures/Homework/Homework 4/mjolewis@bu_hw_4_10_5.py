"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 4
Date: 9/24/19
Homework Problem: 10.5
"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""

"""A simple program to print distint numbers based on user input"""

def main():
    # Get numbers from the user and put them into a list
    userInput = input("Enter ten numbers: ")
    list1 = userInput.split()

    # Add all distinct numbers to list2
    list2 = []
    for number in list1:
        if number not in list2:
            list2.append(number)
    
     # Print the results of list2
    result = " ".join(list2)
    print("The distinct numbers are: " + result)


if __name__ == "__main__":
    main()
else:
    print("Not in main")