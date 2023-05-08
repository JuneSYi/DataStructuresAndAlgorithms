# O(n) time, O(1) space
def isValidSubsequence(array, sequence):
    # have pointer zero, go through array, if pointer == length of seq then return true
    ptr = 0
    for i in range(len(array)):
        if array[i] == sequence[ptr]:
            ptr +=1
        if ptr == len(sequence):
            return True
    return False
