package work.kaiyu.datastructure.leetcode;

/**
 * @author: hamster
 * @date: 2021/1/20 17:13
 * @description:
 * @url: https://leetcode-cn.com/problems/bulls-and-cows/
 */
public class _299_猜数字游戏 {
    public static String getHint(String secret, String guess) {
        // secretArray 和 guessArray 分别记录 两个字符串中非公牛的各个数字的数量
        int[] secretArray = new int[10];
        int[] guessArray = new int[10];
        // 公牛
        int A = 0;
        for (int i = 0; i < secret.length(); i++) {
            // 如果同位的数字相等则，公牛++
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            } else {
                secretArray[secret.charAt(i) - '0']++;
                guessArray[guess.charAt(i) - '0']++;
            }
        }
        // 奶牛
        int B = 0;
        for (int i = 0; i < 10; i++) {
            // 不同位上的相同数字的数量
            B += Math.min(secretArray[i], guessArray[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(A).append('A').append(B).append('B').toString();
    }
}
