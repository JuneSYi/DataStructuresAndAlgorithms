# O(n^2), O(n) space
def threeNumberSum(array, targetSum):
    array.sort()
    ans = []
    for idx,val in enumerate(array[:-2]):
        left = idx+1
        right = len(array)-1
        while left < right:
            cs = val+array[left]+array[right]
            if cs==targetSum:
                temp = [val,array[left],array[right]]
                ans.append(temp)
            if cs>targetSum:
                right -= 1
            else:
                left +=1
    return ans


# fail
def threeNumberSum(array, targetSum):
    # non-empty array, distinct integers, find all triplets that sum up to target sum
    # return 2d array, number in each in ascending,
    # sort first, start for loop
    array.sort()
    twod = []
    for idx,val in enumerate(array):
        temp = []
        temp.append(val)
        print(temp)
        for num in array[idx+1:]:
            temp.append(num)
            print(temp)
            for tri in array[idx+2:]:
                sum = 0
                sum = tri + temp[0] + temp[1]
                if sum == targetSum:
                    temp.append(tri)
                    print(temp)
                    print("printing twod before append")
                    print(twod)
                    twod.append(temp)
                    print("printing twod after append")
                    print(twod)
                    temp.pop(len(temp)-1)
                    print(temp)
            temp.pop(len(temp)-1)
        if idx == len(array)-3:
            break
    return twod
