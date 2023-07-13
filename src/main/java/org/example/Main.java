package org.example;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
 


/*
 * 商品信息类
 */
 
class FruitItem {
 
   int ID;//商品编号
 
   String name;//商品名称
 
   double price;//商品价格
 
   int num;//商品数量
 
   double money;//商品zonge
 
}

class User {
   String username;
   String password;
   List<FruitItem> cart;

   public User(String username, String password) {
      this.username = username;
      this.password = password;
      this.cart = new ArrayList<>();
   }
}


/*
 * 超市管理系统的启动类
 * 实现基本功能
 *    增加商品
 *    删除商品
 *    修改商品
 *  查询商品
 */
 
public class Main {
   private static List<FruitItem> arry = new ArrayList<>();
   private static List<User> users = new ArrayList<>();
   private static User currentUser;

   public static void main(String[] args) {
      init();

      while (true) {
         mainMenu();

         Scanner scanner = new Scanner(System.in);
         int option = scanner.nextInt();
         scanner.nextLine();

         switch (option) {
            case 1:
               showFruitItems();
               break;
            case 2:
               addFruitItem();
               break;
            case 3:
               deleteFruitItem();
               break;
            case 4:
               updateFruitItem();
               break;
            case 5:
               registerUser();
               break;
            case 6:
               loginUser();
               break;
            case 7:
               changePassword();
               break;
            case 8:
               shop();
               break;
            case 9:
               logoutUser();
               break;
            case 10:
               System.out.println("谢谢使用！再见！");
               scanner.close();
               return;
            default:
               System.out.println("无效的操作编号，请重新输入！");
               break;
         }
      }
   }

   /*
    * 初始化商品和用户数据
    */
   public static void init() {
      FruitItem f1 = new FruitItem();
      f1.ID = 1000;
      f1.name = "笔记本";
      f1.price = 10.0;

      FruitItem f2 = new FruitItem();
      f2.ID = 1001;
      f2.name = "西红柿";
      f2.price = 2.0;

      FruitItem f3 = new FruitItem();
      f3.ID = 1002;
      f3.name = "辣条";
      f3.price = 5.0;

      arry.add(f1);
      arry.add(f2);
      arry.add(f3);
   }

   /*
    * 主菜单
    */
   public static void mainMenu() {
      System.out.println();
      System.out.println("==========超市管理系统===========");
      System.out.println("1:货物清单  2:增加货物  3:删除货物  4:修改货物");
      System.out.println("5:用户注册  6:用户登录  7:修改密码  8:用户购物  9:退出登录  10:退出程序");
      System.out.println("输出你要操作的编号");
   }

   /*
    * 查看商品清单
    */
   public static void showFruitItems() {
      System.out.println();
      System.out.println("==========商品清单===============");
      System.out.println("商品编号         商品单价          商品名称");

      for (FruitItem f : arry) {
         System.out.println(f.ID + "    " + f.price + "     " + f.name);
      }
   }

   /*
    * 增加商品
    */
   public static void addFruitItem() {
      System.out.println("选择的是添加商品功能");
      Scanner scanner = new Scanner(System.in);

      System.out.println("输出商品编号ID");
      int ID = scanner.nextInt();

      System.out.println("输入商品单价");
      double price = scanner.nextDouble();

      System.out.println("输入商品名称");
      String name = scanner.next();

      FruitItem f = new FruitItem();
      f.ID = ID;
      f.price = price;
      f.name = name;

      arry.add(f);
      System.out.println("添加成功");
   }

   /*
    * 删除商品
    */
   public static void deleteFruitItem() {
      System.out.println();
      System.err.println("选择的是删除功能");
      System.out.println("输出要删除的商品编号ID");

      Scanner scanner = new Scanner(System.in);
      int id = scanner.nextInt();

      for (FruitItem f : arry) {
         if (f.ID == id) {
            arry.remove(f);
            System.out.println("删除成功");
            return;
         }
      }

      System.out.println("不存在此商品");
   }

   /*
    * 修改商品
    */
   public static void updateFruitItem() {
      System.out.println();
      System.out.println("选择的是修改功能");
      System.out.println("输入要修改的商品编号ID");

      Scanner scanner = new Scanner(System.in);
      int id = scanner.nextInt();

      for (FruitItem f : arry) {
         if (f.ID == id) {
            System.out.println("输入新的商品编号");
            f.ID = scanner.nextInt();

            System.out.println("输入商品单价");
            f.price = scanner.nextDouble();

            System.out.println("输入商品名称");
            f.name = scanner.next();

            System.out.println("修改成功");
            return;
         }
      }

      System.out.println("不存在该商品");
   }

   /*
    * 用户注册
    */
   public static void registerUser() {
      System.out.println();
      System.out.println("选择的是用户注册功能");
      Scanner scanner = new Scanner(System.in);

      System.out.println("输入用户名");
      String username = scanner.nextLine();

      System.out.println("输入密码");
      String password = scanner.nextLine();

      User user = new User(username, password);
      users.add(user);
      System.out.println("注册成功");
   }

   /*
    * 用户登录
    */
   public static void loginUser() {
      System.out.println();
      System.out.println("选择的是用户登录功能");
      Scanner scanner = new Scanner(System.in);

      System.out.println("输入用户名");
      String username = scanner.nextLine();

      System.out.println("输入密码");
      String password = scanner.nextLine();

      for (User user : users) {
         if (user.username.equals(username) && user.password.equals(password)) {
            currentUser = user;
            System.out.println("登录成功");
            return;
         }
      }

      System.out.println("用户名或密码错误");
   }

   /*
    * 修改密码
    */
   public static void changePassword() {
      System.out.println();
      System.out.println("选择的是修改密码功能");

      if (currentUser == null) {
         System.out.println("请先登录");
         return;
      }

      Scanner scanner = new Scanner(System.in);

      System.out.println("输入旧密码");
      String oldPassword = scanner.nextLine();

      if (!currentUser.password.equals(oldPassword)) {
         System.out.println("旧密码错误");
         return;
      }

      System.out.println("输入新密码");
      String newPassword = scanner.nextLine();

      currentUser.password = newPassword;
      System.out.println("密码修改成功");
   }

   /*
    * 用户购物
    */
   public static void shop() {
      System.out.println();
      System.out.println("选择的是用户购物功能");

      if (currentUser == null) {
         System.out.println("请先登录");
         return;
      }

      showFruitItems();

      Scanner scanner = new Scanner(System.in);
      System.out.println("输入要购买的商品编号ID");
      int id = scanner.nextInt();

      FruitItem selectedFruit = null;
      for (FruitItem f : arry) {
         if (f.ID == id) {
            selectedFruit = f;
            break;
         }
      }

      if (selectedFruit == null) {
         System.out.println("不存在该商品");
         return;
      }

      currentUser.cart.add(selectedFruit);
      System.out.println("已将商品添加到购物车");
   }

   /*
    * 退出登录
    */
   public static void logoutUser() {
      System.out.println();
      System.out.println("选择的是退出登录功能");

      if (currentUser == null) {
         System.out.println("当前没有用户登录");
      } else {
         System.out.println("用户 " + currentUser.username + " 已退出登录");
         currentUser = null;
      }
   }
}