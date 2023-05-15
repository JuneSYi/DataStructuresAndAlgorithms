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
