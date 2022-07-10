package src.main.java.sword_offer._05_hash;
/*
    给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，
    找出列表中任意两个时间的最小时间差并以分钟数表示。
    输入：timePoints = ["23:59","00:00"]
    输出：1

    解法：一天有24*60=1440，可定义一个数组，模拟哈希表
        key(索引)：时间
        value：true or false，代表数据中是否有这个时间
 */
public class _35_findMinDifference {
    public static void main(String[] args) {
        String[] timePoints = {"01:01", "02:01"};
        int result = findMinDifference(timePoints);
        System.out.println(result);
    }

    private static int findMinDifference(String[] timePoints) {
        // 优化,超过1440个数，至少有两个时间相同，返回0
        if(timePoints.length>1440){
            return 0;
        }
        // 将time映射到数组上
        boolean[] arr = new boolean [1440];
        for (String time: timePoints){
            String[] timeSplit = time.split(":");
            int key_time = Integer.parseInt(timeSplit[0])*60+Integer.parseInt(timeSplit[1]);
            // 优化，如果有相同的时间，直接返回0
            if(arr[key_time]){
                return 0;
            }
            arr[key_time] = true;
        }
        return helper(arr);
    }

    private static int helper(boolean[] arr) {
        // 依次，比较数组中的索引值
        // 但需要记录第一个数，和最后一个数，方便计算00:00 和23:59,只差一分钟
        int minDiff = arr.length-1;
        int pre = -1;   // 遍历时记录前一个数
        int first = arr.length - 1; // 第一个数，初始记为最大值
        int last = -1; // 最后一个数，初始记为-1

        // 开始遍历
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]){
                // 遇到有时间的节点，开始计算和记录
                if(pre>=0) {
                    minDiff = Math.min(minDiff, i - pre);
                }
                // 注意，这里是记录true的值，而不是false，所以要写在里面
                pre = i;
                first = Math.min(first, i);
                last = Math.max(last, i);
            }
        }
        // 遍历完后，比较特殊值，first+1440-last
        return Math.min(minDiff, first+arr.length-last);
    }
}
