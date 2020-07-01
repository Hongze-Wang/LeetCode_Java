// 40. Combination Sum II

// class Solution {
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         List<List<Integer>> res = new ArrayList();
//         if(candidates == null || candidates.length == 0) return res;
//         Arrays.sort(candidates);
//         combinationSum(0, target, candidates, new ArrayList<Integer>(), res);
//         return res;
//     }
//     private void combinationSum(int index, int target, int[] candidates, List<Integer> list, List<List<Integer>> res) {
//         if(target == 0) {
//             res.add(new ArrayList(list));
//             return;
//         }
//         for(int i=index; i<candidates.length && candidates[i] <= target; i++) {
//             if(i > index && candidates[i] == candidates[i-1]) continue; // to avoid duplicate cases
//             list.add(candidates[i]);
//             combinationSum(i+1, target-candidates[i], candidates, list, res);
//             list.remove(list.size()-1);
//         }
//     }
// }

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if(i > index && candidates[i] == candidates[i-1]) continue; // to avoid duplicate cases
            list.add(candidates[i]);
            combinationSum(i+1, target-candidates[i], candidates, list, res);
            list.remove(list.size()-1);
        }
    }
}
 
