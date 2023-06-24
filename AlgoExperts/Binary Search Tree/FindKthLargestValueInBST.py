# got caught up focusing on postorder traversal, fail
def findKthLargestValueInBst(tree, k):
    # to find largest, we can't go top down, we'll need to go bottom up
    # have a counter, use in order traversal, have a way to determine what last # was for duplicates
    # the return can be a list with 2 values, count and last numb
    # when count reaches k, return numb
    if tree.left == None and tree.right == None:
        return tree.value
    ans = recurse(tree,0,k,tree.value)
    return ans[1]

# needs to return: [curr,last]
def recurse(tree,curr,k,last):
    leftdated = [curr,last]
    if leftdated[0] == k:
        return leftdated
    if tree.right !=None:
        leftdated = recurse(tree.right,leftdated[0],k,leftdated[1])
    if leftdated[0] == k:
        return leftdated
    if leftdated[1] != tree.value:
        leftdated[1] = tree.value
        leftdated[0] += 1
    if tree.left != None:
        leftdated = recurse(tree.left,leftdated[0],k,leftdated[1])
    return leftdated


