# terrible solution, took too long, need to consider edge cases more often
# O(nlogn) time, O(1) space
def largestRange(array):
    # input of an array of integers, returns array of length 2, largest range of integers contained
    # first # = first # in the range, second # = last number
    # it's counting the #s
    # sort the array, have a counter, and check if increase is +1, if counter is 1, index is that index
    # if counter is > max, ans[] is [index,curr]
    if len(array)<2:
        return [array[0],array[0]]
    array = sorted(array)
    ans = []
    max = 0
    ct = 1
    idx = 0
    for pl,val in enumerate(array):
        if pl == 0:
            continue
        if val == array[pl-1]:
            continue
        if val == array[pl-1] +1:
            # when increase is noticed
            if ct == 1:
                # bookmarks start of increase
                idx = pl-1
            # count goes up by 1
            ct +=1
            if pl == len(array)-1:
                if ct > max:
                    return [array[idx],val]
        else:
            # increase has ended
            if ct > 1:
                # if there has been counting
                if ct > max:
                    # increase pattern is > max
                    max = ct
                    # new max
                    ans = [array[idx],array[pl-1]]
                    # new ans
            ct = 1
            # increase ended, we keep count at 1
    return ans














