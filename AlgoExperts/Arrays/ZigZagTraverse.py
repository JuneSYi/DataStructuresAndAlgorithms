# logic i need to implement, not hard, just gotta think it through
# if left limit, or bot limit, we change goingDown and move one over (depending on limit)
# if at very bottom, move right one
# if at very right side, move down one
# else we go down one, and left one
# it keeps going down and left, until limit hit
# if goingDown = False, we're going up, if at top or right limit
# if top or right limit hit
# if at the most right, then row moves one down (+1)
# else it means we're at the most top so column goes over one
# keeps going up, right, until limit hit


# oof, still failing
def zigzagTraverse(array):
    # Write your code here.
    # quick potential solution that i thought about. 
    # it just needs to go until array[len(array)-1][len(array[0]-1)]
    # the rest is something with range() and + and - numbers for n and m
    # simple
    nlen = len(array)-1
    mlen = len(array[0])-1
    x,y = 0,0
    ans = []
    ans.append(array[x,y])
    x+=1
    while (x != nlen and y != 0) or (x != 0 and y != mlen):
        # if x == 0, then y+1 to start over
        # if y == 0, then x+1 to start over
        while x 
            
        
        pass
    while x != nlen and y != mlen:
        # after halfway, if y == mlen, then x+1
        # after halfway, if x == nlen, then y+1
        pass
    pass


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
