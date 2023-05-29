#fail
def mergeOverlappingIntervals(intervals):
    # non-empty array, arbitrary intervals, 
    # merges any overlapping intervals
    # returns the new intervals, no particular order
    # what if we sort the lists so that the beginning are in ascending
    # [0] will always be <= [1]
    # we can compare if [1] >= the next interval [0] value
    # how do we have it keep going?
    sorted(intervals)
    ans = [][]
    i = 0
    while i < len(intervals)-1:
        newint = findInterval(i, intervals,[intervals[i][0],intervals[i][1]])
        if intervals[i+1][0] <= intervals[i][1]:
            
    return [[]]

def findInterval(val, array, interval):
    # base case
    if interval[1] < array[val][0]:
        return [interval[0],interval[1]]
    # recursive case
    else array[val+1][0] <= array[val][1]:
        interval = [array[val][0],array[val+1][1]]
        val += 1
