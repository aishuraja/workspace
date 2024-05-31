class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        # nums =[] , remove val from the nums (in-place)
        #order can be anything 
        # n - no of elements ---> [n = nums.count() != val] = k
        # return k 
        #O(n)
        # n = len(nums)
    
    
       
        count = nums.count(val)
        for i in range(count):
            nums.remove(val)
        # k= nums.count(i)
        k= len(nums)
        return k

      

        