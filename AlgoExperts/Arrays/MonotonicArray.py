# O(n) time, O(1) space
def isMonotonic(array):
    # criteria for non-increasing - left to right, next # is not greater
    # criteria for non-decreasing - next # is not less
    # factor if one is active, other can't be active
    # edge case, lots of zeros
    # we check for increasing or decrease while it moves left to right
    # if one or other, it switches variable to True
    if len(array)<2:
        return True
    left = 1
    nondec = False
    noninc = False
    while left < len(array):
        if nondec:
            if array[left] < array[left-1]:
                return False
        elif noninc:
            if array[left] > array[left-1]:
                return False
        else:
            if array[left] > array[left-1]:
                nondec = True
            if array[left] < array[left-1]:
                noninc = True
        left +=1
    if nondec == noninc:
        return True
    return nondec or noninc
