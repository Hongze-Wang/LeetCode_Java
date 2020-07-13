// 77. Combinations

class Solution {
    private void dfs(int n, int k, int index, List<Integer> path, List<List<Integer>> res) {
        if(k == 0) {
            res.add(new ArrayList(path));
        }
        for(int i=index+1; i<=n; i++) {
            path.add(i);
            dfs(n, k-1, i, path, res);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList();
        dfs(n, k, 0, new ArrayList(), res);
        return res;
    }
}
