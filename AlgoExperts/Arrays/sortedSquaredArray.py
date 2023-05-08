# O(2n) time, O(1) space
def sortedSquaredArray(array):
    # sort in ascending
    for idx,value in enumerate(array):
        array[idx] = value**2
    array.sort()
    return array
