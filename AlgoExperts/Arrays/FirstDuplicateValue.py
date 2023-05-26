# O(N) time, O(N) space
def firstDuplicateValue(array):
    # integers between 1 and n, inclusive, where n is length of array
    # returns first integer that appears more than once.
    list = []
    for val in array:
        if val in list:
            return val
        list.append(val)
    return -1
