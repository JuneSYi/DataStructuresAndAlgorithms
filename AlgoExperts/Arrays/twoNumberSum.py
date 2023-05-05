def twoNumberSum(array, targetSum):
    newdict = dict()
    for idx, x in enumerate(array):
        newdict[x] = idx
    for x in array:
        temp = targetSum-x
        if newdict[temp] is not Null:
            return [temp,x]
    return []
# for loop
# dict 
