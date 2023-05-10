# failed
def nonConstructibleChange(coins):
    # whats the pattern? we're trying to count from 1 and +
    # whats the method we use to add up for each #? start with adding them all up?
    # how do we know in the sample we can create 12? maybe save the proess we used?
    # does sorting help?
    # for each #, we can start from below, if you can't create it with the #s leading up to that point
    # than its impossible, but how do we try every combination?
    # [1,1,2,3,5,7,22], how do we do 16? we try every combination up to 7, if it goes beyond, then we skip one down
    # with each number, we can add all the possibilities of previous numbers we calculated, plus that number, 
    # so we add curr, then everything else
    if len(coins) < 1:
        return 1
    coins.sort()
    possible = []
    for val in coins:
        possible.append(val)
        if num in possible:
            num +=1
            continue
        break
    return num
