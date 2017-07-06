arr = [10, 22, 9, 33, 21, 41, 50, 60, 80]
LIS = [1] * 9

# Optimal substructure property is LIS[i] = 1 + max(LIS[j]) where 0 < j < i < n

for i in range(1, len(arr)):
    j,m = i-1, LIS[i]
    while j >= 0:
	if arr[i] > arr[j]:
	    m = max(m, LIS[j]+1)
	j = j - 1
    LIS[i] = m

print max(LIS)
