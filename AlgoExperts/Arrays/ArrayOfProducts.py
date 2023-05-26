# O(3N) time, O(3N) space, NOT GREAT
def arrayOfProducts(array):
    # what if we use 2 pointers, we have every number multiplied up to that point from left to right
    # another array that shows every number from right to left
    # left to right 5, 5, 20, 40
    # right to left 40,8, 8 , 2
    arrleft = []
    arright = []
    start = 1
    for val in array:
        start*=val
        arrleft.append(start)
    start = 1
    for val in reversed(array):
        start*=val
        arright.insert(0,start)
    ans = []
    ans.append(arright[1])
    for idx,i in enumerate(array[1:],start=1):
        if idx == len(array)-1:
            ans.append(arrleft[idx-1])
            break
        ans.append(arrleft[idx-1]*arright[idx+1])
    return ans


# bad solution, doesn't solve edge case of 1 zero
def arrayOfProducts(array):
    # takes in a non-empty array of integers
    # returns an array of same length, each element is equal to product of every other #
    # multiply every number, fill array with that number, divide by i
    total = 1
    for val in array:
        total*=val
    ans = []
    for i in range(len(array)):
        if array[i] == 0:
            ans.append(0)
            continue
        ans.append(total/array[i])
    return ans
