# remove duplicated from sorted array II 

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n=len(nums)
        p = 1   # pointer points at 1st index
        count = 1 # starts count from 2nd element

        for i in range(1,n):
            if nums[i] == nums[i-1]:
                count+=1
            else:
                count = 1
            if count <=2:
                nums[p] = nums[i]
                p+=1
        k = p
        return k
        





# some alternate solutions : 

        # for i in nums:
        #     while( nums.count(i)>2):
        #         nums.remove(i)
        #     else:
        #         nums
        # return len(nums)

