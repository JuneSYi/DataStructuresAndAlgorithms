# i suck so bad, spent over an hour on this one and still failed
def zigzagTraverse(array):
    # n x m 2d array, returns 1d array of all elements in zigzag
    # starts [0][0], [1][0], then [0][1], then [0][2],[1][1],[2][0], then [3][0],[2][1],[1][2],[0][3]
    #[len(array)][len(array[0])], numbers can never exceed the lengths -1
    # different pattern for going left to right, and right to left
    # it will always go to min m, to min n, to min m, to min n, when it reaches min n AND max y
    # or it reaches max n AND min m
    # it changes to max m to max n, then max n to max m, until [n-1][m-1]
    # what if its 10 x 2, whichever limit is hit first, it starts descending
    arr = []
    arr.append(array[0][0])
    if len(array) > 1:
        x,y = 1,0
    else:
        return [t for t in array[0]]
    if len(array[0]) == 1:
        return [z for z in array]
    last = False
    switch = True
    # either != array[len(array)-1][0] or array[0][len(array[0])-1]
    while ([x,y] != [len(array)-1,0] and last) or ([x,y] != [0,len(array[0])-1] and last):
        if switch:
            while x > 0:
                arr.append(array[x][y])
                x-=1
                y+=1
            arr.append(array[x][y])
            switch = False
            if y < len(array[x])-1:
                y+=1
        else:
            while y > 0:
                arr.append(array[x][y])
                x+=1
                y-=1
            arr.append(array[x][y])
            switch = True
            if x < len(array)-1:
                x+=1
        if [x,y] == [len(array)-1,0] or [x,y] == [0,len(array[0])-1]:
            last = True
    
    pass
