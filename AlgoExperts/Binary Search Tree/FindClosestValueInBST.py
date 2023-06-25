# re-visited. solved it faster, still small trouble. O(n) worst case, O(logN) average, O(n) space
def findClosestValueInBst(tree, target):
    # bst, greater is right, lower is left
    # need a last value, if last is closer to target, we retunr that
    # recurse, base case, if none, return.
    return recurse(tree,target,tree.value)

def recurse(tree,target,closest):
    if tree == None:
        return closest
    if abs(target-closest) > abs(target-tree.value):
        closest = tree.value
    if target > tree.value:
        return recurse(tree.right,target,closest)
    elif target < tree.value:
        return recurse(tree.left,target,closest)
    else:
        return closest


# O(log(n)) time, can be O(n) time, O(n) space ? if recursive, we're calling the recursion fcn multiple times. in this, we add frames on the call stack. hence using extra memory.
def findClosestValueInBst(tree, target):
    return recurse(tree,target,tree.value)

def recurse(tree,target,smallest):
    # check if larger or smaller
    # if larger then we do .right
    # if smaller then we do .left
    # we want to know if the abs(.value-target) of last value is smaller, then current .value
    # if so then we return the last value, else we recurse with new value
    if tree is None:
        return smallest
    if target == tree.value:
        return tree.value
    if abs(target-smallest) > abs(target-tree.value):
        smallest = tree.value
    if target > tree.value and tree.right is not None:
        return recurse(tree.right,target,smallest)
    elif target > tree.value and tree.right is None:
        return smallest
    if target < tree.value and tree.left is not None:
        return recurse(tree.left,target,smallest)
    elif target < tree.value and tree.left is None:
        return smallest


# This is the class of the input tree. Do not edit.
class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


# fail
def findClosestValueInBst(tree, target):
    # recursion, base case, if abs(target-curr.value) < abs(target-last.value)
    # return
    # recursive case: while tree.value!=None
    # it needs to compare left and then right
    pass

def rec(tree,target,last):
    if abs(target-last) < abs(target-tree.value):
        return last

    


# This is the class of the input tree. Do not edit.
class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None
