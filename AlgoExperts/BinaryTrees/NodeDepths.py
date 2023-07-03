# O(n) time, O(n) space
# time because we have to travel through every node
# space because for worst case scenario, it recurses through every node before it returns in a single branche tree.
def nodeDepths(root):
    # Write your code here.
    return recNodes(root,0,0)

def recNodes(root,depth,sum):
    sum += depth
    leftSum,rightSum = 0,0
    if root.left is not None:
        leftSum = recNodes(root.left,depth+1,0)
    if root.right is not None:
        rightSum = recNodes(root.right,depth+1,0)
    return sum+leftSum+rightSum

# fail
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
