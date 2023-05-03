def max_subarray_sum(arr):
    if len(arr) == 1:
        return arr[0]
    
    mid = len(arr) // 2
    left_sum = max_subarray_sum(arr[:mid])
    right_sum = max_subarray_sum(arr[mid:])
    
    crossing_sum = max_crossing_sum(arr, mid)
    
    return max(left_sum, right_sum, crossing_sum)
    
def max_crossing_sum(arr, mid):
    left_sum = float('-inf')
    current_sum = 0
    for i in range(mid - 1, -1, -1):
        current_sum += arr[i]
        left_sum = max(left_sum, current_sum)
    
    right_sum = float('-inf')
    current_sum = 0
    for i in range(mid, len(arr)):
        current_sum += arr[i]
        right_sum = max(right_sum, current_sum)
    
    return left_sum + right_sum
    
arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
print(max_subarray_sum(arr))