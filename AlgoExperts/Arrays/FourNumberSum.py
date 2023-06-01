# fail
def fourNumberSum(array, targetSum):
    # non-empty array, distinct integers, so unique,
    # find all quadruplets that sum up to targetsum
    # return 2d array of the quadruplets
    # brute force, 4 for loops
    # what happens if we add up all the numbers
    # [7,13,17,16,17,19], [19,12,6,2,3,2]
    # what if we have the sum of every number in pairs, its n^2,
    # [13,11,6,8,2,10,5,6,8,3,5,6,0,1,3]
    # 16 = x + y
    # take 16-x = y, solve for y,
    # but how do we know what index? hashmap? every key, has value that represents the index
    # dict does not allow duplicates, so we can use 2d list,
    list = []
    index= []
    for idx,val in enumerate(array[:len(array)-1]):
        for lvl,num in enumerate(array[idx+1:]):
            list.append(val+num)
            index.append([idx,lvl])
    ans = []
    idx = 0
    lvl = 0
    while idx < len(list)-1:
        lvl = idx+1
        while lvl < len(list):
            if targetSum-list[idx] == list[lvl]:
                ans.append([array[index[idx][0]],array[index[idx][1]],array[index[lvl][0]],array[index[lvl][1]]])
            lvl +=1
        idx+=1
    return ans
