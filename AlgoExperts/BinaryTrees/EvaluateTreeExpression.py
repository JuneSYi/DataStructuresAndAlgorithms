# Wow, I suck so bad
def evaluateExpressionTree(tree):
    if tree.value < 0:
        tree.left.value = recurse(tree.left)
        tree.right.value = recurse(tree.right)
        if tree.value == -1:
            return recurse(tree.left)+recurse(tree.right)
        elif tree.value == -2:
            return tree.left.value-tree.right.value
        elif tree.value == -3:
            return tree.left.value//tree.right.value
        elif tree.value == -4:
            return tree.left.value*tree.right.value
    else:
        return tree.value

def recurse(tree):
    # base case
    if tree.left >= 0 and tree.right >= 0:
        if tree.value == -1:
            return tree.left.value+tree.right.value
        elif tree.value == -2:
            return tree.left.value-tree.right.value
        elif tree.value == -3:
            return tree.left.value//tree.right.value
        elif tree.value == -4:
            return tree.left.value*tree.right.value
    # recursive
    elif tree.value < 0:
        tree.left.value = recurse(tree.left)
        tree.right.value = recurse(tree.right)
        if tree.value == -1:
            return tree.left.value+tree.right.value
        elif tree.value == -2:
            return tree.left.value-tree.right.value
        elif tree.value == -3:
            return tree.left.value//tree.right.value
        elif tree.value == -4:
            return tree.left.value*tree.right.value
    return tree.value
'''
since we can assume valid tree expression, and always positive integers,
we can recurse until .left and .right are positive, then we return with a 
value that replace .value,

recursive case:
if tree.value < 0:
    tree.value = recursivefunction(input)
return tree.value

edge cases:

'''
