# spent way too long on this, not sure why it keeps failing
def longestPeak(array):
    uptrend = False
    downtrend = False
    count = 1
    ans = 0
    for idx,val in enumerate(array[1:], start=1):
        if not uptrend and not downtrend:
            if array[idx-1] < array[idx]:
                count = 1
                uptrend = True
        if uptrend and array[idx-1]==array[idx]:
            uptrend = False
        if uptrend and array[idx-1] > array[idx]:
            downtrend = True
            uptrend = False
        if downtrend: 
            if array[idx-1] <= array[idx]:
                if count > ans:
                    ans = count
                    count = 1
                downtrend = False
        count +=1
        if idx == len(array)-1 and downtrend:
            if count > ans:
                ans = count
    return ans


# fail
def longestPeak(array):
    # returns length of longest peak
    # have counter start with first number
    # what is reset factor? if index is less than length-1, and next num
    # is greater. counter is passed to final, and counter is 0 or 1?
    ans = 0
    ct = 0
    prev = -999999
    downslope = False
    for idx,val in enumerate(array):
        if val > prev and not downslope:
            prev = val
            ct +=1
        elif downslope:
            prev = val
            ct+=1
        
    return ans
