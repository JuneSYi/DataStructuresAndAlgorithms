# fail
# Do not edit the class below except for
# the insert, contains, and remove methods.
# Feel free to add new properties and methods
# to the class.
class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def insert(self, value):
        while True:
            if value >= self.value:
                if self.right == None:
                    self.right = value
                    break
                else:
                    self = self.right
            elif value < self.value:
                if self.left == None:
                    self.left = value
                    break
                else:
                    self = self.left
        # if value is >= BST.value
            # if tree.right = None, then tree.right=value
            # else tree = tree.right
        # if value is < BST.value
            # if tree.left = None, then tree.left = value
            # else tree = tree.left
        return self

    def contains(self, value):
        while True:
            if value == self.value:
                return True
            if value > self.value:
                if self.right == None:
                    return False
                self = self.right
            if value < self.value:
                if self.left == None:
                    return False
                self = self.left
        return False

    def remove(self, value):
        if self.left == None and self.right == None:
            return self
        while True:
            if self.value == value:
                target = self.value
                
        # needs to check is self.value == value, if it does it needs to be replaced by next value
            # we then find closest value that fits?
        # Write your code here.
        # Do not edit the return statement of this method.
        return self

    
            
