package org.will.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * ClassName:org.will.interview.Nio
 * Description:蔚来汽车面试编程题
 *
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2018-08-06
 */
public class Nio {
    /**
     * 题目1:输入一行字符，分别统计出其英文字母、空格、数字和其他字符出现的次数。
     */
    public void count() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char[] chars = string.toCharArray();
        Map<String, Integer> result = new HashMap<>();
        result.put("English letter", 0);
        result.put("space", 0);
        result.put("number", 0);
        result.put("other characters", 0);
        for (char c : chars) {
            if ((0x61 <= c && c <= 0x7A) || (0x41 <= c && c <= 0x5A)) {
                result.put("English letter", result.get("English letter") + 1);
            } else if (c == 0x20) {
                result.put("space", result.get("space") + 1);
            } else if (0x30 <= c && c <= 0x39) {
                result.put("number", result.get("number") + 1);
            } else {
                result.put("other characters", result.get("other characters") + 1);
            }
        }
        Set<Map.Entry<String, Integer>> entries = result.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + "的数量：" + entry.getValue());
        }
        scanner.close();
    }

    /**
     * 题目2:利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，
     * 60-89分之间的用B表示，
     * 60分以下的用C表示，
     * 如果离特殊线分数x差5分的用D表示。
     */
    public String question2(double score) {
        String result;
        if (score > 100 || score < 0) {
            throw new IllegalArgumentException("输入分数必须在0-100之间");
        } else if (Math.abs(score - 90) == 5 || Math.abs(score - 60) == 5) {
            result = "D";
        } else {
            if (score >= 90) {
                result = "A";
            } else {
                if (score >= 60) {
                    result = "B";
                } else {
                    result = "C";
                }
            }
        }

        return result;
    }

    /**
     * 题目3:打印出能被3整除的所有"水仙花数"，
     * 所谓"水仙花数"是指一个三位数，
     * 其各位数字立方和等于该数本身。
     * 例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
     */
    public void narcissus() {
        for (int i = 100; i < 1000; i++) {
            // 百位
            int x = i / 100;
            // 十位
            int y = (i - x * 100) / 10;
            // 个位
            int z = i % 10;
            if (i == x * x * x + y * y * y + z * z * z) {
                if (i % 3 == 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
