'''
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 1
Date: 9/4/19
Homework Problem: 1.9
'''

'''A simple program to compute the area and perimeter of a rectangle'''

def perimeter(width, height):
    '''Compute the perimeter of a rectangle'''
    return 2 * (width + height)

def area(width, height):
    '''Compute the area of a rectangle'''
    return width * height

def main():
    width = 4.5
    height = 7.9
    print("The area of the rectangle is ", area(width, height), " and the perimeter is ", perimeter(width,height))

if __name__ == "__main__":
    main()
else:
    pass
