# Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
#
# 1634 = 14 + 64 + 34 + 44
# 8208 = 84 + 24 + 04 + 84
# 9474 = 94 + 44 + 74 + 44
# As 1 = 14 is not a sum it is not included.
#
# The sum of these numbers is 1634 + 8208 + 9474 = 19316.
#
# Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
x = 0;
finalCount = 0;
while True:
    x += 1
    counter = 0
    additionTotal = 0
    while counter < len(x.__str__()):
        additionTotal += int(x.__str__()[counter])**5
        counter += 1
    if additionTotal == x and x != 1:
        finalCount += x
        print(x)
    elif x > 354294:
        print(finalCount)
        break
