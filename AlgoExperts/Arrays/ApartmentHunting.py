# passed but only O(N^3)
def apartmentHunting(blocks, reqs):
    shortestFd = float("inf")
    bestSpot = 0
    for idx,val in enumerate(blocks):
        farthestPt = 0
        for req in reqs:
            left, right = idx, idx
            dist = 0
            while left >=0 or right < len(blocks):
                if left < 0:
                    pass
                else:
                    if blocks[left][req]:
                        dist = idx-left
                        break
                    left-=1
                if right<len(blocks):
                    if blocks[right][req]:
                        dist = right-idx
                        break
                    right+=1
                else:
                    pass
            if left == -1 and right == len(blocks):
                dist = float("inf")
            if dist > farthestPt:
                farthestPt = dist
        if farthestPt < shortestFd:
            shortestFd = farthestPt
            bestSpot = idx
    return bestSpot
