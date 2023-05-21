# O(n) time, O(1) space
def moveElementToEnd(array, toMove):
    # two pointers, while loop
    if len(array)<2:
        return array
    left = 0
    right = len(array)-1
    while left < right:
        if array[right] == toMove:
            right-=1
            continue
        if array[left] == toMove:
            temp=array[left]
            array[left]=array[right]
            array[right]=temp
        left+=1
    return array
