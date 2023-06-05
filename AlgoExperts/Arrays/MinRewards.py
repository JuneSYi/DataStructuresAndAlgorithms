# fail
def minRewards(scores):
    # all students must receive one reward, if better score than adjacent then more rewards
    # if worse score than adjacent then less rewards
    # all scores are unique, in a particular order, so can't change order
    # start with lowest number? have counter? as it compares and count total?
    lo = float("inf")
    idx = 0
    for pl,val in enumerate(scores):
        if val < lo:
            lo = val
            idx = pl
    total = 1
    left = idx-1
    right = idx+1
    count = 1
    while left >= 0:
        if scores[left] > scores[left+1]:
            count +=1
        else:
            if count == 1:
                total += idx-left-1
                count = 2
            count -= 1
            if left == 0:
                count =1
        total += count
        left -= 1
    count = 1
    while right < len(scores):
        if scores[right] > scores[right-1]:
            count+=1
        else:
            if count == 1:
                total += right-idx-1
                count = 2
            count-=1
            if right == len(scores)-1:
                count =1
        total+=count
        right+=1
    return total
