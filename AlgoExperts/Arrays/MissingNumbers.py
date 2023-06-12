# O(n), O(n) space
def missingNumbers(nums):
    # we know it starts with 1, we can have n = 1, go up a numbers.
    # can we turn nums into a set?
    # while n<len(nums)+3, we check if numset[n] is true, if not then we add the num
    hashset = set(nums)
    n = 1
    list = []
    while n<len(nums)+3:
        if n in hashset:
            n+=1
        else:
            list.append(n)
            n+=1
    if list[0]>list[1]:
        return [list[1],list[0]]
    return list


# O(2n) time, O(n) space
def missingNumbers(nums):
    # unordered list, unique integers, 2 are missing
    # return a new list with the 2 missings #s only, sorted
    # create a list size n+2 with all -1, go through list, place numbers in index=val-1
    list = [-1 for __ in range(len(nums)+2)]
    a = []
    for val in nums:
        list[val-1] = val
    for x in range(len(list)):
        if list[x] == -1:
            a.append(x+1)
    if a[0]>a[1]:
        return [a[1],a[0]]
    else:
        return a
        
