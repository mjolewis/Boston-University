'''
Author: Michael Lewis
Student ID: U14985193
Class: Information Structures
Instructor: Professor Pinsky
Lecture: 1
Date: 9/4/19
Homework Problem: 1.11
'''

'''A simple program to compute the projected population in the US over a 5 year period'''

def birthsPerYear(seconds, births):
    '''Calculates the number of births per year'''
    return seconds // births

def deathsPerYear(seconds, deaths):
    '''Calculates the number of deaths per year'''
    return seconds // deaths

def immigrationsPerYear(seconds, immigrations):
    '''Calculates the number of immigrations per year'''
    return seconds // immigrations

def population(currentPopulation, births, deaths, immigrations, years):
    '''Recursively calculates the projected US population over a 5 year period and prints the results'''
    if (years > 0):
        currentPopulation = currentPopulation + births + deaths + immigrations
        population(currentPopulation, births, deaths, immigrations, years - 1)
        print(currentPopulation)

# 
def main():
    '''Initializes the program contraints and invokes methods to project the US population'''

    # Determine the number of seconds per year and use the resulting helper variable to project population
    SECONDS_PER_MINUTE = 60
    MINUTES_PER_HOUR = 60
    HOURS_PER_DAY = 24
    DAYS_PER_YEAR = 365
    currentPopulation = 312032486
    numberOfYears = 5
    secondsPerYear = SECONDS_PER_MINUTE * MINUTES_PER_HOUR * HOURS_PER_DAY * DAYS_PER_YEAR

    # Number of seconds per population impacting event
    secondsPerBirth = 7
    secondsPerDeath = 13
    secondsPerImmigration = 45

    # Calculate the number of births, deaths, and immigrations per year
    births = birthsPerYear(secondsPerYear, secondsPerBirth)
    deaths = deathsPerYear(secondsPerYear, secondsPerDeath)
    immigrations = immigrationsPerYear(secondsPerYear, secondsPerImmigration)
    
    # Calculate the population over a 5 year period and print the results
    population(currentPopulation, births, deaths, immigrations, numberOfYears)

if __name__ == "__main__":
    main()
else:
    pass