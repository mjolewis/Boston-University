''' Write an algorithm to determine if the given number is a perfect number'''
x = 24
midPoint = int((x + 1) / 2)
sum = 0

for i in range(1, midPoint + 1):
    if x % i == 0: 
        print(i)
        sum += i

print(sum == x)