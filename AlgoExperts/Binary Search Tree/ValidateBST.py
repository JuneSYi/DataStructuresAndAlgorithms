# This is an input class. Do not edit.
class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def validateBst(tree):
    # Write your code here
    if tree.value is None:
        return
    if tree.left is not None:
        if "-" in tree.left.value:
            return False
        if tree.left.value >= tree.value:
            return False
        else:
            return validateBst(tree.left)
    if tree.right is not None:
        if "-" in tree.right.value:
            return False
        if tree.right.value < tree.value:
            return False
        else:
            return validateBst(tree.right)
    return True
