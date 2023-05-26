# bad solution, doesn't solve edge case of 1 zero
def arrayOfProducts(array):
    # takes in a non-empty array of integers
    # returns an array of same length, each element is equal to product of every other #
    # multiply every number, fill array with that number, divide by i
    total = 1
    for val in array:
        total*=val
    ans = []
    for i in range(len(array)):
        if array[i] == 0:
            ans.append(0)
            continue
        ans.append(total/array[i])
    return ans
