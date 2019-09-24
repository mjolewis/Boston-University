'''
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 1
Date: 9/4/19
Book Problem: 2.8
'''

'''
This program will compute the monthly payment and total payment for any given loan
'''

# Calculate payment
def paymentCalculator(interest, years, amount):
    monthlyPayment = (amount * interest) / (1 - (1 / (1 + interest) ** (years * 12)))
    totalPayment = monthlyPayment * years * 12
    return monthlyPayment, totalPayment

# Get interest rate, length of loan in years, and the loan amount from the user
def userInput():
    # Enter the annual interest rate as a percentage (4.5%)
    interestRate = eval(input("Enter the annual interest rate, e.g. 4.5%: "))
    monthlyInterest = interestRate / 1200 #(100 * 12 to convert to decimal for 12 months)

    # Enter number of years
    numberOfYears = eval(input("Enter the number of years as an integer, e.g. 5: "))

    # Enter the loan amount
    loanAmount = eval(input("Enter the amount of the loan, e.g 10000: "))

    return monthlyInterest, numberOfYears, loanAmount
    
def main():
    interest, years, loanAmount = userInput()
    monthlyPayment, totalPayment = paymentCalculator(interest, years, loanAmount)
    print("The monthly payment is $", int(monthlyPayment * 100) / 100, " and the toal payment is $", int(totalPayment * 100) / 100)

if __name__ == "__main__":
    main()
else:
    pass