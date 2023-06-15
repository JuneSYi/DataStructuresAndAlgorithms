# O(n) time, O(1) space
def majorityElement(array):
    # non-empty unordered array, positive integers,
    # returns array's majority element without sorting and without using
    # more than constant space

    # have a counter? if number != x, then --;
    # if number < 0, number =x, count = 1
    count = 1
    number = array[0]
    i = 1
    while i<len(array):
        if number == array[i]:
            count+=1
        else:
            count-=1
        if count==0:
            number=array[i]
            count=1
        i+=1
    return number
    return -1
