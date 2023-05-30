# took me too long but got it finally.
# learn that just doing sorted(val) doesn't make val sorted unless you make it: val = sorted(val)
# learned edge case of assuming too much
# 
def mergeOverlappingIntervals(intervals):
    # non-empty array, arbitrary intervals, 
    # merges any overlapping intervals
    # returns the new intervals, no particular order
    # what if we sort the lists so that the beginning are in ascending
    # [0] will always be <= [1]
    # we can compare if [1] >= the next interval [0] value
    # how do we have it keep going?
    intervals = sorted(intervals)
    ans = []
    i = 0
    while i < len(intervals)-1:
        newint = findInterval(i+1, intervals,[intervals[i][0],intervals[i][1]])
        ans.append(newint[0])
        i = newint[1]
        ## edge case where last interval is standalone
        if i == len(intervals)-1:
            ans.append([intervals[i][0],intervals[i][1]])
    return ans

# keeps going until no more overlap or end of array
# we also want to know where the last value ended so we don't repeat
def findInterval(val, array, interval):
    # base case, if no more overlap, return what's created with interval
    if val == len(array) or interval[1] < array[val][0]:
        return [interval,val]
    # recursive case, otherwise, create longer interval and recurse
    return findInterval(val+1, array, [interval[0],max(array[val][1],interval[1])])


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
