# i suck
def sweetAndSavory(dishes, target):
    # negative = sweet, positive = savory, abs(val) = intensity
    # return pairing of two dishes that is closest to target, 
    # one sweet, 1 savory, never more savory than target

    # 2 booleans, hasPos and hasNeg, start as false and become true
    # we're looking for x + y = target
    # what if we go through array with target - dishes[i] and store y
    # we don't have to find exactly y, we can find if dishes[i]

    # sort array? start in middle with 2 pointers, sweet and savory,
    # if sweet + savory < target, savory +1, if > target sweet -1, if ==
    if len(dishes)==2:
        if min(dishes[0],dishes[1]) < 0 and max(dishes[0],dishes[1])>0 and dishes[0]+dishes[1]<=target:
            return [min(dishes[0],dishes[1]),max(dishes[0],dishes[1])]
        else:
            return [0,0]
    newdishes = sorted(dishes)
    hasNeg = False
    hasPos = False
    sweet = savory = len(dishes)//2
    while sweet>=0 and savory<= len(newdishes)-1:
        sum = newdishes[sweet]+newdishes[savory]
        if newdishes[sweet] < 0:
            hasNeg = True
        if newdishes[savory] > 0:
            hasPos = True
        if sum < target and savory != len(newdishes)-1:
            if abs(target-sum) < abs(target-(newdishes[sweet]+newdishes[savory+1])):
                if hasNeg and hasPos and sum<=target:
                    return [newdishes[sweet],newdishes[savory]]
            savory+=1
            sum = newdishes[sweet]+newdishes[savory]
        if sum > target and sweet != 0:
            sweet-=1
        elif sum == target and hasPos and hasNeg:
                return [newdishes[sweet], newdishes[savory]]
        else: 
            if not hasPos and savory != len(newdishes)-1:
                savory+=1
            if not hasNeg and sweet != 0:
                sweet-=1
        if sum < target and savory==len(newdishes)-1:
            if hasPos and hasNeg:
                return [newdishes[sweet],newdishes[savory]]
    if hasPos and hasNeg and sum<=target:
        return [newdishes[sweet],newdishes[savory]]
    else:
        return [0,0]
