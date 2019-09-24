'''
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 1
Date: 9/4/19
Book Problem: 2.9
'''

'''
Compute the distance between two points
'''

# Calculate the distance between two points
def computeDistance(x1, y1, x2, y2):
    distance = ((x2 - x1) ** 2 + (y2 - y1) ** 2) ** 0.5
    return distance

# Ask the user for the two floating point values
def userInput():
    # Enter the first point with two float values
    x1, y1 = eval(input("Enter x1 and y1 for Point 1: "))

    # Enter the second point with two float values
    x2, y2 = eval(input("Enter x2 and y2 for Point 2: "))

    return x1, y1, x2, y2

def main():
    x1, y1, x2, y2 = userInput()
    print("The distance between the two points is: ", computeDistance(x1 ,y1, x2, y2))

if __name__ == "__main__":
    main()
else:
    pass