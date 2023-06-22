def inOrderTraverse(tree, array):
    # goes all the way down .left until very bottom, then add .value and return
    # if there's a .right, it adds
    # adds .current
    # goes all the way down .right
    if tree.left is not None:
        array = inOrderTraverse(tree.left,array)
    array.append(tree.value)
    if tree.right is not None:
        array = inOrderTraverse(tree.right,array)
    # add tree.value
    return array


def preOrderTraverse(tree, array):
    # it needs to go down all .left until very bottom, then add .value and return.
    # 
    # if tree.left is not None, preOrderTraverse
    # if tree.right is not None.preOrderTraverse
    array.append(tree.value)
    if tree.left is not None:
        array = preOrderTraverse(tree.left,array)
    if tree.right is not None:
        array = preOrderTraverse(tree.right,array)
    return array


def postOrderTraverse(tree, array):
    if tree.left is not None:
        array = postOrderTraverse(tree.left,array)
    if tree.right is not None:
        array = postOrderTraverse(tree.right,array)
    array.append(tree.value)
    return array
