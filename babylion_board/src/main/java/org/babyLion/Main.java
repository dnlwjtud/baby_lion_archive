package org.babyLion;


import org.babyLion.sys.Request;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean programStatus = true;
        int postCount = 0;

        List<Post> postList = new ArrayList<>();

        while ( programStatus ) {

            System.out.print("명령어 : ");
            String command = sc.nextLine().trim();

            switch ( command ) {

                case "remove":

                    System.out.println("이전에 작성된 게시물을 삭제합니다.");
                    System.out.println("게시물 번호를 정수로 입력해주세요.");

                    System.out.print("게시물 번호 : ");
                    String removePostId = sc.nextLine().trim(); // 정수

                    try {

                        int postId = Integer.parseInt(removePostId);
                        Post findPost = postList.get(postId - 1);

                        postList.remove(findPost);

                        System.out.println("게시물이 성공적으로 삭제 되었습니다.");

                    } catch ( NumberFormatException e ) {
                        System.out.println("게시물 번호는 정수로 입력해주세요.");
                    } catch ( IndexOutOfBoundsException e ) {
                        System.out.println("게시물 번호를 한 번만 더 확인해 주세요");
                    } catch ( Exception e ) {
                        System.out.println("찾을 수 없습니다.");
                    }

                    break;
                case "update":
                    System.out.println("이전에 작성된 게시물을 수정합니다.");
                    System.out.println("게시물 번호를 정수로 입력해주세요.");

                    System.out.print("게시물 번호 : ");
                    String updateInputId = sc.nextLine().trim(); // 정수

                    try {

                        int postId = Integer.parseInt(updateInputId);
                        Post findPost = postList.get(postId - 1);

                        System.out.println("수정전 제목 : " + findPost.getTitle());
                        System.out.print("수정하는 제목 : ");
                        String updateTitle = sc.nextLine().trim();

                        System.out.println("수정전 내용 : " + findPost.getBody());
                        System.out.print("수정하는 내용 : ");
                        String updateBody = sc.nextLine().trim();

                        findPost.setTitle(updateTitle);
                        findPost.setBody(updateBody);
                        findPost.setUpdatedDate(LocalDate.now());

                        System.out.println("게시물이 수정되었습니다.");

                    } catch ( NumberFormatException e ) {
                        System.out.println("게시물 번호는 정수로 입력해주세요.");
                    } catch ( IndexOutOfBoundsException e ) {
                        System.out.println("게시물 번호를 한 번만 더 확인해 주세요");
                    } catch ( Exception e ) {
                        System.out.println("찾을 수 없습니다.");
                    }


                    break;
                case "view":
                    System.out.println("이전에 작성된 게시물들을 조회합니다.");
                    System.out.println("게시물 번호를 정수로 입력해주세요.");

                    System.out.print("게시물 번호 : ");
                    String viewInputId = sc.nextLine().trim(); // 정수

                    try {

                        int postId = Integer.parseInt(viewInputId);
                        Post findPost = postList.get(postId - 1);

                        System.out.println("findPost = " + findPost.toString());

                    } catch ( NumberFormatException e ) {
                        System.out.println("게시물 번호는 정수로 입력해주세요.");
                    } catch ( IndexOutOfBoundsException e ) {
                        System.out.println("게시물 번호를 한 번만 더 확인해 주세요");
                    } catch ( Exception e ) {
                        System.out.println("찾을 수 없습니다.");
                    }

                    break;
                case "write":
                    System.out.println("게시글을 작성합니다. ");

                    System.out.print("제목 : ");
                    String title = sc.nextLine().trim();

                    System.out.print("내용 : ");
                    String body = sc.nextLine().trim();

                    postCount++;

                    Post post = new Post(postCount, title, body);

                    postList.add(post);

                    System.out.println("작성된 게시물 번호 : " +  postCount);

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