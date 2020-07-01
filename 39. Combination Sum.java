// 39. Combination Sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        if(candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        combinationSum(0, target, candidates, new ArrayList<Integer>(), res);
        return res;
    }
    private void combinationSum(int index, int target, int[] candidates, List<Integer> list, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList(list));
            return;
        }
        for(int i=index; i<candidates.length; i++) {
            if(target - candidates[i] < 0) break;
            list.add(candidates[i]);
            combinationSum(i, target-candidates[i], candidates, list, res);
            list.remove(list.size()-1);
        }
    }
}
 
