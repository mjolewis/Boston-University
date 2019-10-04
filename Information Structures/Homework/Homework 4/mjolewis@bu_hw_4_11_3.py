"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 4
Date: 9/24/19
Homework Problem: 11.3
"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""

"""A simple program to display scores in increasing order"""


def main():
    # Students' answers to the questions
    answers = [['A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'],
        ['D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'],
        ['E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'],
        ['C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'],
        ['A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'],
        ['B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'],
        ['B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'],
        ['E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D']]
    
    # Key to the questions
    keys = ['D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D']

    # Grade all answers
    studentResuts = {}
    for row in range(len(answers)):
        if row not in studentResuts.keys():
            studentResuts[row] = 0

    for row in range(len(answers)): 
        for column in range(len(answers[row])):
            if answers[row][column] == keys[column]:
                studentResuts[row] += 1

    #Sort the dictionary using list comprehension
    sortedDict = sorted((value, key) for (key, value) in studentResuts.items())

    for index in sortedDict:
        print("Student " + str(index[1]) + " correct count is " + str(index[0]))
        

if __name__ == "__main__":
    main()
else:
    print("Not in main")