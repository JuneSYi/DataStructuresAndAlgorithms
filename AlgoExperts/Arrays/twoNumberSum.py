# O(nlog(n)) - at most, go through all #s once, log(n) for quicksort? the sort()?
# O(1) for space
def twoNumberSum(array, targetSum):
    array.sort()
    right = len(array)-1
    left = 0
    while left < right:
        if array[left] + array[right] == targetSum:
            return [array[left],array[right]]
        if array[left]+array[right]>targetSum:
            right -=1
        else:
            left +=1
    return []

def twoNumberSum(array, targetSum):
    nums = {} # dict or set, [] is list, () is tuple
    for num in array:
        temp = targetSum - num
        if temp in nums: # if the number we're looking for exists in dict
            return [temp, num]
        else:
            nums[num] = True # we add the number into the dict
            # this will add every number from the array into nums,
            # for [4,6], with targetSum 10, adds 4, when num is on 6, immediately detects
            # targetSum - 6 as 4, so we know the sum exists
            # for [4,6,1], adds number 4, first number by itself will never work unless the sum is 0.
            # next number, temp is -1, doesn't exist (5-6), adds 6, next number, temp is 4, which exists.
            
    return []
# this works because we know x+y=targetSum. if we can find what y is and it exists in the hashtable, we know the x
# value was stored in the dict at an earlier iteration so those 2 numbers can sum
# we're using num and we're seeing if the other number was in the history of numbers used. we check back so we
# can compare the curr number with every other number in past since we only need to compare 2

# WORKING O(2N)
def twoNumberSum(array, targetSum):
    newdict = dict()
    for idx, x in enumerate(array):
        newdict[x] = idx
    for idx, x in enumerate(array):
        temp = targetSum-x
        if newdict.get(temp) is not None:
            if newdict[temp] is idx:
                continue
            return [temp,x]
    return []
# for loop
# dict 


#FAIL
def twoNumberSum(array, targetSum):
    newdict = dict()
    for idx, x in enumerate(array):
        newdict[x] = idx
    for x in array:
        temp = targetSum-x
        if newdict[temp] is not Null:
            return [temp,x]
    return []
# for loop
# dict 
