import os.path
import sys

"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 4
Date: 9/24/19
Homework Problem: 14.1
"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""

"""A simple program to display the keywords in a Python source file as well as to count the number of the keywords"""

def main():
    # Python keyword set
    keywords = {"and", "as", "assert", "break", "class", "continue", "def", "del", "elif", "else", "except", "False",
        "finally", "for", "from", "global", "if", "import", "in", "is", "lambda", "None", "nonlocal", "not", "or",
        "pass", "raise", "return", "True", "try", "while", "with", "yield"}

    filename = input("Enter a Python source code filename: ").strip()

    if not os.path.isfile(filename): # Check if a file exists
        print("File, ", filename, " does not exist")
        sys.exit()

    infile = open(filename, "r") # Open files for input

    text = infile.read().split() # Read and split words from the file

    keywordDictionary = {}
    for word in text:
        if word[-1] == ":":
            word = word[ : len(word) -1]
        if word in keywords:
            if word not in keywordDictionary.keys():
                keywordDictionary[word] = 1
            else:
                keywordDictionary[word] += 1

    for key in keywordDictionary:
        print("The keyword", key, "appeared", keywordDictionary[key], "times")

if __name__ == "__main__":
    main()
else:
    print("Not in main")