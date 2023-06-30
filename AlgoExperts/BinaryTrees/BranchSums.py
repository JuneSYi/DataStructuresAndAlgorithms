# O(n)?
def branchSums(root):
    # if left and right node = None, add sum
    list = []
    return findSums(root,list,0)

def findSums(root,list,sum):
    sum += root.value
    newlist = list
    if root.left != None:
        newlist = findSums(root.left,list,sum)
    newerlist = newlist
    if root.right != None:
        newerlist = findSums(root.right,newlist,sum)
    if root.left == None and root.right == None:
        newerlist.append(sum)
    return newerlist
        
