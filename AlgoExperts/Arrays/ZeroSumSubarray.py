# needed hints and didn't grasp edge cases, need to come back. O(n), O(n)
def zeroSumSubarray(nums):
    # what can we take away by iterating through the list in its entirety. we know the integers in each idx
    # it's ooo, for every positive, there has to be a negative unless its zero.
    # if there's a 1 on right side, left side won't matter until a -1 is found. but that's assuming a -100 isn't found
    # then the 1 on the right doesn't matter, so we move the right down, but what if we don't settle on -100. it's random
    # we can move up the row, since we know the numbers from prev, we can put the total in a different list
    # is best way really just go each number and spread out?
    # [-5, -10, -8, -5, -7]
    # if a sum is repeated, then we see a number return by the numbers in between included the repeat equaling to zero
    list = [0]
    count = 0
    for val in nums:
        count +=val
        if count in list:
            return True
        list.append(count)
    return False


# brute force, O(n^2)
def zeroSumSubarray(nums):
    # boolean whether there exists a zero-sum subarray of nums, subarray>=1
    # contiguous
    # if zero is found, can return early
    # will have to go through entire array with beginning to end added up
    # create new array? have total up to that point?
    # start from middle? expand out?
    # brute force, start from idx 0, add up all values, start over and add up all values starting on idx 2
    i,j = 0,0
    for i in range(len(nums)):
        if nums[i] == 0:
            return True
        count = nums[i]
        j = i+1
        while j < len(nums):
            if j == len(nums):
                break
            count += nums[j]
            if count == 0:
                return True
            j+=1
        i+=1
    return False
