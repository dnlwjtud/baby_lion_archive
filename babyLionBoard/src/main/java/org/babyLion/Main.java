package org.babyLion;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean programStatus = true;
        int postCount = 0;

        while ( programStatus ) {

            System.out.print("명령어 : ");
            String command = sc.nextLine().trim();

            switch ( command ) {

                case "write":
                    System.out.println("게시글을 작성합니다. ");

                    System.out.print("제목 : ");
                    String title = sc.nextLine().trim();

                    System.out.print("내용 : ");
                    String body = sc.nextLine().trim();

                    postCount++;

                    Post post = new Post(postCount, title, body);

                    System.out.println("작성된 게시물 : " + post);
                    break;

                case "exit" :
                    System.out.println("프로그램을 종료합니다.");
                    programStatus = false;
                    break;

                default:
                    System.out.println("존재하지 않는 명령어 입니다.");

            }



        }


    }

}