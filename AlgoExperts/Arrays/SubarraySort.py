# O(2n) time, O(1) space
def subarraySort(array):
    left = -1
    right = -1
    # go through and record [val,index]
    max = float("-inf")
    lowest = float("inf")
    for i in range(len(array)):
        if array[i] > max:
            max = array[i]
        if array[i] < max:
            if array[i] < lowest:
                lowest = array[i]
            if i > right:
                right = i
    for k in range(len(array)):
        if array[k] > lowest:
            left = k
            break
    return [left,right]


# O(2nlogn) time, O(n) space
def subarraySort(array):
    # array of at least 2 integers, returns array of start/end indices of smallest subarray
    # we know how to determine ascending
    # how, do we know where the # belongs, when we find anomaly
    # say we find the 6 in index 9, how do we know it's going in index 3,
    # stacks no, hashmap of value no, hashmap of index no,
    # what if we recorded all the indexes when the value went lower, one value that tracks the highest #
    # an array that tracks when a num is lower than the highest #
    # [7,6,7], go through array again and see if the value can be switched.
    left = -1
    right = -1
    # go through and record [val,index]
    max = float("-inf")
    arr = []
    for i in range(len(array)):
        if array[i] > max:
            max = array[i]
        if array[i] < max:
            arr.append([array[i],i])
            if i > right:
                right = i
    if len(arr)>0:
        arr = sorted(arr)
    else:
        return [left,right]
    for k in range(len(array)):
        if array[k] > arr[0][0]:
            left = k
            break
    return [left,right]

  # brute force, O(n^2)
def subarraySort(array):
    # array of at least 2 integers, returns array of start/end indices of smallest subarray
    # we know how to determine ascending
    # how, do we know where the # belongs, when we find anomaly
    # say we find the 6 in index 9, how do we know it's going in index 3,
    # brute force says we compare every number and remember left and right pointers and return that,
    # that is n^2
    left = -1
    right = -1
    for i in range(len(array)-1):
        k = i
        while k < len(array):
            if left == -1 and array[i] > array[k]:
                left = i
                if array[k] > right:
                    right = k
            if array[i] > array[k] and k > right:
                right = k
            k += 1
    return [left,right]
