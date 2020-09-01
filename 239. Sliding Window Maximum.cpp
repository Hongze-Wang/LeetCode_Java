// 239. Sliding Window Maximum

// O(nlogk)

class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        map<int, int> window;
        vector<int> res;
        for(int i=0; i<nums.size(); i++) {
            window[nums[i]]++;
            if(i >= k && --window[nums[i-k]] == 0) {
                window.erase(window.find(nums[i-k]));
            }
            if(i >= k-1) {
                res.push_back((*window.rbegin()).first);
            }
        }
        return res;
    }
};

// monotonic queue
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        deque<int> deq;
        vector<int> res;
        for(int i=0; i<k; i++) {
            while(deq.size() && nums[deq.back()] < nums[i]) {
                deq.pop_back();
            }
            deq.push_back(i);
        }
        for(int i=k; i<nums.size(); i++) {
            res.push_back(nums[deq.front()]);
            if(deq.front() <= i-k) { // 维持窗口大小
                deq.pop_front();
            }
            while(deq.size() && nums[deq.back()] < nums[i]) {
                deq.pop_back();
            }
            deq.push_back(i);
        }
        res.push_back(nums[deq.front()]);
        return res;
    }
};
