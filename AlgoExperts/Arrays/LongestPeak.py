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
