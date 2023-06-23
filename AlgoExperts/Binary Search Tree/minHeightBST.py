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
