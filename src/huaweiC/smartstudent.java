package huaweiC;

import java.util.*;
import java.util.stream.Collectors;

/*
题目描述
小明来到某学校当老师，需要将学生按考试总分或单科分数进行排名，你能帮帮他吗?

输入描述
第1行输入两个整数，学生人数n和科目数量m。0<n<100,0<m<10

第2行输入m个科目名称，彼此之间用空格隔开。科目名称只由英文字母构成，单个长度不超过10个字符。科目的出现顺序和后续输入的学生成绩一一对应。不会出现重复的科目名称。

第3行开始的n行，每行包含一个学生的姓名和该生m个科目的成绩(空格隔开)，学生不会重名。学生姓名只由英文字母构成，长度不超过10个字符。成绩是0~100的整数，依次对应第2行中输入的科目。

第n+2行，输入用作排名的科目名称。若科目不存在，则按总分进行排序。

输出描述
输出一行，按成绩排序后的学生名字，空格隔开。成绩相同的按照学生姓名字典顺序排序。

*/

class Student {
    String name;
    int[] scores;
    int totalScore;

    public Student(String name, int[] scores) {
        this.name = name;
        this.scores = scores;
        this.totalScore = Arrays.stream(scores).sum();
    }

    public int getScore(int index) {
        return scores[index];
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class smartstudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取学生人数和科目数量
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        // 读取科目名称
        String[] subjects = scanner.nextLine().split(" ");
        Map<String, Integer> subjectIndexMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            subjectIndexMap.put(subjects[i], i);
        }

        // 读取学生信息
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split(" ");
            String name = parts[0];
            int[] scores = new int[m];
            for (int j = 0; j < m; j++) {
                scores[j] = Integer.parseInt(parts[j + 1]);
            }
            students.add(new Student(name, scores));
        }

        // 读取排名科目
        String rankingSubject = scanner.nextLine();

        // 使用sort函数，根据指定的 Comparator 对列表中的元素进行排序
        students.sort((s1, s2) -> {
            int score1, score2;
            if (subjectIndexMap.containsKey(rankingSubject)) {
                int index = subjectIndexMap.get(rankingSubject);
                score1 = s1.getScore(index);
                score2 = s2.getScore(index);
            } else {
                score1 = s1.getTotalScore();
                score2 = s2.getTotalScore();
            }
            if (score1 != score2) {
                return Integer.compare(score2, score1); // 降序排序
            } else {
                return s1.name.compareTo(s2.name); // 字典顺序排序
            }
        });

        // 输出结果
        System.out.println(students.stream().map(Student::toString).collect(Collectors.joining(" ")));
    }
}