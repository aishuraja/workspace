# remove duplicates from sorted array 
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n = len(nums)
        i = 1  # starts from 2nd element
        p = 1  # pointer places at unique position in nums 

        while i < n:
            if nums[i]!= nums[i-1]:
                nums[p] = nums[i]
                p+=1
            i+=1
        
        k = p  # length of new unique elements 
        return k 
