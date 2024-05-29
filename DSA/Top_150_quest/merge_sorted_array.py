class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        
## this works if the separate array can be created for the result 
        # result = []

        # result = nums1[:m] + nums2
        # print("the resukt:",result)
        # result.sort()
        # print("sorted val:", result)

        # nums1 = result.copy()
        # print("nums1 val:",nums1)
        
        # return nums1
        
        ## HERE , we need to use the in-place method as the final sorted array must be stored inside nums1 not the new array 

        #intilaize the pointers for nums1, nums2 and the merged array (final)

        p1 = m-1          # pointer for nums1
        p2 = n-1          # pointer for nums2
        p = m+n-1         # pointer for merged array (m+n)

        #merge operations --- merge nums2 into nums1 in-place 

        while p1>=0 and p2>=0:
            # compare elements from last of nums 1 and nums 2
            if nums1[p1]<nums2[p2]:
                nums1[p] = nums2[p2]
                p2-=1
            else:
                nums1[p] = nums1[p1]
                p1-=1
            p-=1
            
       # copy the remaining items of nums2 to the merged nums1

        nums1[:p2 + 1] = nums2[:p2 + 1]

        