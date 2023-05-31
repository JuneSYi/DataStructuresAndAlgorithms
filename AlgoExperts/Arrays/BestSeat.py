# O(n) time, O(1) space
def bestSeat(seats):
    # there can be multiple 0s
    # if 3 zeroes, -1, if 4 then 4/2, subtract index -2, if 6,
    idx = -1
    ct = 0
    max = 0
    for i in range(len(seats)):
        if seats[i] == 1:
            ct = 0
            continue
        else:
            ct+=1
            if ct > max:
                max = ct
                idx = i-int((max/2))
    return idx
