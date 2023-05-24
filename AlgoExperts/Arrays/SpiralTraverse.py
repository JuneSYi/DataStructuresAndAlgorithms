#closer, not quite tho
def spiralTraverse(array):
    # n x m, rows are restricted to n, length is restricted to m.
    # left to right, right to down, down to left, left to up
    # we want to track all values so we'll have 4 variables
    # how do we account for edge cases? e.g. odd # of rows/cols
    # for left to right, and top to bot, use >=
    leftcol, rightcol = 0, len(array[0])-1
    toprow, botrow = 0, len(array)-1
    ans = []
    while leftcol <= rightcol and toprow <= botrow:
        for i in range(leftcol,rightcol): # goes to last number
            ans.append(array[toprow][i])
        for x in range(toprow,botrow): # starts after last loop, goes to last #
            ans.append(array[x][rightcol])
        if toprow < botrow:
            for y in range(rightcol,leftcol,-1): # starts 1 from right col finished, 
                # leftcol-1 makes it go all the way
                ans.append(array[botrow][y])
        if leftcol < rightcol:
            for z in range(botrow,toprow,-1):
                ans.append(array[z][leftcol])
        leftcol +=1
        toprow +=1
        rightcol -=1
        botrow -=1
    return ans


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
