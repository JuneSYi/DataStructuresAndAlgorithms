# O(n) time, O(n) space
def transposeMatrix(matrix):
    # matrix[x][y] to matrix[y][x]
    # [x][for length of y]
    # goes to for length of y[x]
    list = []
    for x in range(len(matrix)):
        for y in range(len(matrix[x])):
            if x == 0:
                list.append([matrix[x][y]])
            else:
                list[y].append(matrix[x][y])
                
    return list
