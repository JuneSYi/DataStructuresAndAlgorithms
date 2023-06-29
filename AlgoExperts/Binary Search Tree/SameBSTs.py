# O(n) space, O(2n) time
def sameBsts(arrayOne, arrayTwo):
    # dict with value being a list if theres more than one
    # go through second array and remove the values, if it's empty then
    # we can pop the dict
    dict = {}
    for val in arrayOne:
        if dict.get(val) != None:
            dict[val] = dict.get(val).append(val)
        else:
            dict[val] = [val]
    for num in arrayTwo:
        if dict.get(num) != None:
            dict[num] = dict.get(num).remove(num)
            if dict.get(num) == None:
                dict.pop(num)
    if len(dict) < 1:
        return True
    else:
        return False


def sameBsts(arrayOne, arrayTwo):
    return sorted(arrayOne) == sorted(arrayTwo)
