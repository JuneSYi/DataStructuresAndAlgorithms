# two pointers, O(nlogn) time, O(1) space
def smallestDifference(arrayOne, arrayTwo):
    # what if we sort both arrays? have ptrs for each one, move up the smaller number
    arrayOne.sort()
    arrayTwo.sort()
    i,j = 0, 0
    ans = [arrayOne[0],arrayTwo[0]]
    while i < len(arrayOne) and j < len(arrayTwo):
        if arrayTwo[j]-arrayOne[i] == 0:
            return [arrayTwo[j],arrayOne[i]]
        if (abs(arrayTwo[j]-arrayOne[i])<abs(ans[1]-ans[0])):
            ans = [arrayOne[i],arrayTwo[j]]
        if arrayTwo[j] < arrayOne[i]:
            j +=1
        else:
            i+=1
    return ans


# O(n^2) time, O(1) space
def smallestDifference(arrayOne, arrayTwo):
    # find the pairs (one from each), abs diff is cloest is zero
    # how to find abs diff, a-b or b-a
    # use min(), use abs() within min for both a-b and b-a
    diff = abs(arrayOne[0]-arrayTwo[0])
    ans = [0,0]
    for idx,val in enumerate(arrayOne):
        for ix,num in enumerate(arrayTwo):
            if min(abs(num-val),abs(val-num)) < diff:
                ans = [idx,ix]
                diff = min(abs(num-val),abs(val-num))
    return [arrayOne[ans[0]],arrayTwo[ans[1]]]
