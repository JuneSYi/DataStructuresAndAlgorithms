#closer
def minHeightBst(array):
    # we want to take length/2 and start tree from there
    # insert does everything for you, so we want to minimize by inserting in correct order
    # we want a fcn that takes in 2 idx pts, and an array
    # the function grabs the middle # and runs BST.insert(value)
    # once inserted, we convert the number in that index to the original middle number (since all unique)
    # if index+1 is not original middle #, recurse with index, original right point
    mp = len(array)//2
    unique = array[mp]
    tree = BST(array[mp])
    if len(array) == 1:
        return tree
    if len(array) == 2:
        tree.insert(array[0])
        return tree
    recurse(tree,0,mp,array,unique)
    recurse(tree,mp,len(array)-1,array,unique)
    return tree

def recurse(tree,left,right,array,block):
    mn = (right+left)//2
    if array[mn] == block or right<left:
        return
    else:
        tree.insert(array[mn])
        array[mn] = block
    # go right
    # if mn < len(array)-1 and array[mn+1] != block:
    recurse(tree,mn+1,right,array,block)
    # go left
    # if mn > 0 and array[mn-1] != block:
    recurse(tree,left,mn-1,array,block)
    return tree
        

class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def insert(self, value):
        if value < self.value:
            if self.left is None:
                self.left = BST(value)
            else:
                self.left.insert(value)
        else:
            if self.right is None:
                self.right = BST(value)
            else:
                self.right.insert(value)


# fail, ended up spending time learning classes, (self), __init__, etc
def minHeightBst(array):
    # start from middle to minimize height?
    # but tree.right and tree.left needs to be the middle of the middle for their
    # respective side
    # left and right pointers?
    tree = BST(array.firstValueHere)
    pass


class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def insert(self, value):
        if value < self.value:
            if self.left is None:
                self.left = BST(value)
            else:
                self.left.insert(value)
        else:
            if self.right is None:
                self.right = BST(value)
            else:
                self.right.insert(value)
