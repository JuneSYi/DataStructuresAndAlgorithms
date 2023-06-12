def countSquares(points):
    # what defines a square? [0,10],[10,0],[0,0],[10,10]
                    # same as[x, y],[y ,x],[x,x],[ y, y]
    # create a hashset? what would that do?
    # loop through input again, function that checks if x,y exist, then checks reverse, then checks x,x, then checks yy,
    dict = {}
    sqrs = 0
    sqrsfd = []
    
    for arr in points:
        if dict.get((arr[0],arr[1])) != None:
            dict[(arr[0],arr[1])] = False
        else:
            dict[(arr[0],arr[1])] = True
    for i in range(len(points)):
        x,y = points[i][0], points[i][1]
        if x == y:
            if dict.get((x,y)) == True:
                continue
        if dict.get((y,x)) != None:
            if dict.get((x,x)) != None:
                if dict.get((y,y)) != None:
                    completeSet = {(x,y),(y,x),(x,x),(y,y)}
                    if completeSet not in sqrsfd:
                        sqrs+=1
                        sqrsfd.append(completeSet)
                    
    return sqrs
