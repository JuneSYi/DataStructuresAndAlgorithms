# O(n) space, O(n) time
def reconstructBst(preOrderTraversalValues):
    # return tree.root
    # if less, it goes .left,
    # if >, start back at root node and conduct .insert
    tree = BST(preOrderTraversalValues[0])
    if len(preOrderTraversalValues) == 1:
        return tree
    i = 1
    treeBuild = tree
    while i<len(preOrderTraversalValues) and preOrderTraversalValues[i] < preOrderTraversalValues[i-1]:
        treeBuild.left = BST(preOrderTraversalValues[i])
        treeBuild = treeBuild.left
        i+=1
    while i < len(preOrderTraversalValues):
        tree.insert(preOrderTraversalValues[i])
        i+=1
    return tree
  
# This is an input class. Do not edit.
class BST:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
    
    def insert(self,value):
        if value >= self.value:
            if self.right is None:
                self.right = BST(value)
            else:
                self.right.insert(value)
        else:
            if self.left is None:
                self.left = BST(value)
            else:
                self.left.insert(value)

        return self
