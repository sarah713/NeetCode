package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0)
            return res;

        helper(candidates, target, 0, res, new ArrayList<>());

        return res;
    }

    public void helper(int[] candidates, int target, int idx, List<List<Integer>> res, List<Integer> cur) {
        if (idx == candidates.length) {
            if (target == 0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        // inclusion
        if (candidates[idx] <= target) {
            cur.add(candidates[idx]);
            helper(candidates, target - candidates[idx], idx, res, cur);
            cur.remove(cur.size() - 1);
        }
        // exclusion
        helper(candidates, target, idx + 1, res, cur);

    }
}
