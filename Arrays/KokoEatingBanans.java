package striverssheet.NeetCode.Arrays;

public class KokoEatingBanans {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 0;
        for (int i : piles) {
            hi = Math.max(hi, i);
        }
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isPossible(piles, h, mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public boolean isPossible(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile / k); // Divide pile size by k and round up to get hours required for
                                                   // current pile
        }
        return hours <= h;
    }
}
