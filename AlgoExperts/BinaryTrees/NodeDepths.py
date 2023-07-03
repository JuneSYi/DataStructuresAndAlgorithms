def nodeDepths(root):
    # recursion is the only way i know, we need multiple avenues
    # a variable to keep track of node depth to add
    # add it to total and return it.
    left,right = 0,0
    if root.left != None:
        left = recurseNodes(root.left,1,0)
    if root.right != None:
        right = recurseNodes(root.right,1,0)
    return left+right

def recurseNodes(root,rootDepth,sum):
    currSum = sum+rootDepth
    if root.left != None:
        sum = recurseNodes(root.left,rootDepth+1,currSum)
        currSum = sum
    if root.right != None:
        sum = recurseNodes(root.right,rootDepth+1,currSum)
    return sum
