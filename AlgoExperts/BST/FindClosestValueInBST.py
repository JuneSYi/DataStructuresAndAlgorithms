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
