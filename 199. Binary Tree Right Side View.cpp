// 199. Binary Tree Right Side View

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> res;
        if(!root) return res;

        queue<TreeNode*> que;
        que.push(root);
        TreeNode* temp; // the front of the queue
        int n;
        while(que.size()) {
            n = que.size();
            for(int i=1; i<=n; i++) {
                temp = que.front();
                que.pop();
                if(temp->left) {
                    que.push(temp->left);
                }
                if(temp->right) {
                    que.push(temp->right);
                }
                if(i == n) {
                    res.push_back(temp->val);
                }
            }
        }
        return res;
    }
};
