"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 4
Date: 9/24/19
Homework Problem: 10.3
"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""

"""A simple program that reads some integers between 1 and 100 and counts the occurrences of each"""

def countOccurrences(numbersList):
    numberDictionary = {}

    # Add each number to the dictionary as the key and the number of occurrences at the value
    for number in numbersList:
        if (number not in numberDictionary.keys()):
            numberDictionary[number] = 1
        else:
            numberDictionary[number] += 1

    for key, value in numberDictionary.items():
        if (value == 1):
            print(str(key) + " occurs " + str(value) + " time")
        else:
            print(str(key) + " occurs " + str(value) + " times")



def main():
    # Get user input
    numbers = input("Enter integers between 1 and 100: ")

    # Convert the input into a list and sort the result
    numbersList = numbers.split(" ")
    convertedList = []
    for num in numbersList:
        convertedList.append(int(num))
    
    convertedList.sort()

    # Determine how many times each number appears in the list
    countOccurrences(convertedList)

if __name__ == "__main__":
    main()
else:
    print("Not in main")