import sys
import pathlib
import re

"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 3
Date: 9/25/19
Homework Problem: 13.1
"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""

"""A simple program to remove a specified string from an input file"""

def removeString(fileName, stringToRemove):
    """Open the file if it exists and remove the specified string. If the file does not exist, print notification and
    the program"""

    removeList = stringToRemove.split()
    try:
        # Open the file for reading and add each word to a temporary string
        with open(fileName, "r") as f:
            tmpString = " "
            for line in f:
                tmpString += line
            
            # Split the string into a temporary array for more efficient processing 
            # If the word is not in the target removal list, then append it to a temporary list
            # Close the file
            tmpList = tmpString.split(" ")
            output = []
            for word in tmpList:
                if word not in removeList:
                    output.append(word)
                print(word)
            f.close

        # Re-open the file with the write flag
        # Write the text with every targeted word removed
        with open(fileName, "w") as f:
            outputString = " ".join(output)
            f.write(outputString)

    # Throw an error if the file doesn't exist
    except FileNotFoundError:
        print(fileName + " does not exist")
        sys.exit()

def main():
    # Prompt the user for an input file
    fileName = input("Enter a file name: ").strip()
    stringToRemove = input("Enter the string to be removed: ")

    # Join the path name and file name and activate removeString to process the string removal
    removeString(fileName, stringToRemove)

    print("Done")

if __name__ == "__main__":
    main()
else:
    print("Not in main")