package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, 0, target, res, new ArrayList<>());
        return res;
    }

    private void helper(int[] candidates, int idx, int target, List<List<Integer>> res, List<Integer> cur) {
        if (idx == candidates.length) {
            if (target == 0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }

        if (candidates[idx] <= target) {
            cur.add(candidates[idx]);
            helper(candidates, idx + 1, target - candidates[idx], res, cur);
            cur.remove(cur.size() - 1);
        }

        while (idx < candidates.length - 1 && candidates[idx] == candidates[idx + 1]) {
            idx++;
        }
        helper(candidates, idx + 1, target, res, cur);
    }
}
