#fail, took too long
def spiralTraverse(array):
    # new array, goes right
    # goes down last index of every array
    # traverses backwards back to first index
    # goes up first index of every array
    # 4 values while top right is < bottom row or left index is < right index
    toprow = 0
    botrow = len(array)-1
    leftcol = 0
    # rightcol = they're not all square so we'll need to use a # that is length minus value
    rightcol = len(array[0])-1
    ans = []
    iteration = 1
    while topright < botrow or leftcol < rightcol:
        # top row
        for i in range(leftcol,len(array[toprow])):
            if i > rightcol:
                break
            ans.append(array[toprow][i])
            # append every value of top row until it goes past rightcol
        toprow +=1
        # right col
        for i in range(toprow,len(array)):
            if i>botrow:
                break
            ans.append(array[i][len(array[i])-iteration])
            # starts with last value, iteration goes up so we know how much to subtract from each side
        rightcol-=1
        #bottom row
        temp = rightcol
        for val in array[botrow][rightcol::-1]:
            if temp < leftcol:
                break
            temp-=1
            ans.append(val)
        botrow-=1
        #left col
        for i in range(toprow,botrow):
            if
        iteration +=1
    return ans
