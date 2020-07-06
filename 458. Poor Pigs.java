// 458. Poor Pigs
// https://www.zhihu.com/question/60227816/answer/1274968885

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int) Math.ceil(Math.log(buckets) / Math.log(minutesToTest / minutesToDie + 1));
    }
}
