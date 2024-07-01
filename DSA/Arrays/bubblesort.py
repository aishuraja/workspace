arr = [10,8,1,2,9]
for i in range(len(arr)-1):
    for j in range(len(arr)-i-1):
        if arr[j]>arr[j+1]:
            arr[j], arr[j+1] = arr[j+1],arr[j]

print("sorted array:",arr)