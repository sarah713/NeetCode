package striverssheet.NeetCode.Stack;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        float arraytime[] = new float[target + 1], max = 0;
        for (int i = 0; i < position.length; i++) {
            arraytime[position[i]] = (float) (target - position[i]) / speed[i];
        }
        int count = 0;
        for (int i = target; i >= 0; i--) {
            if (arraytime[i] > max) {
                count++;
                max = arraytime[i];
            }
        }
        return count;
    }
}
