package org.example;

import java.util.Scanner;

public class Main {
    private static int caloriesBurned = 0; // 记录燃烧的卡路里

    public static void main(String[] args) {
        System.out.println("欢迎来到健身菜单！");

        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        while (true) {
            System.out.println("\n请选择你要进行的操作：");
            System.out.println("1. 查看健身计划");
            System.out.println("2. 记录训练进度");
            System.out.println("3. 查看历史记录");
            System.out.println("4. 重置卡路里");
            System.out.println("5. 退出");

            System.out.print("请输入操作编号：");
            userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    showFitnessPlan();
                    break;
                case "2":
                    recordTrainingProgress(scanner);
                    break;
                case "3":
                    showHistoryRecords();
                    break;
                case "4":
                    resetCalories();
                    break;
                case "5":
                    System.out.println("谢谢使用！再见！");
                    scanner.close();
                    return;
                default:
                    System.out.println("无效的操作编号，请重新输入！");
            }
        }
    }

    private static void showFitnessPlan() {
        System.out.println("\n*** 健身计划 ***");
        System.out.println("根据你的身体状况和目标制定的健身计划");
        System.out.println("这里是你的健身计划，根据计划进行训练吧！");
    }

    private static void recordTrainingProgress(Scanner scanner) {
        System.out.println("\n*** 记录训练进度 ***");

        System.out.print("请输入今天的训练内容：");
        String trainingContent = scanner.nextLine();

        System.out.print("请输入训练时间（分钟）：");
        int trainingTime = scanner.nextInt();
        scanner.nextLine();

        System.out.print("请输入消耗的卡路里：");
        int calories = scanner.nextInt();
        scanner.nextLine();

        caloriesBurned += calories;

        System.out.println("\n已记录训练进度：");
        System.out.println("训练内容：" + trainingContent);
        System.out.println("训练时间：" + trainingTime + "分钟");
        System.out.println("卡路里燃烧：" + caloriesBurned + "卡");
    }

    private static void showHistoryRecords() {
        System.out.println("\n*** 历史记录 ***");
        System.out.println("这里是你的历史训练记录");
        System.out.println("1. 训练日期：2023-04-20，内容：有氧运动，时间：30分钟，卡路里燃烧：200卡");
        System.out.println("2. 训练日期：2023-04-21，内容：力量训练，时间：45分钟，卡路里燃烧：300卡");
    }

    private static void resetCalories() {
        caloriesBurned = 0;
        System.out.println("已重置卡路里记录。");
    }
}
