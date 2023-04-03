package io.dnlwjtud.builderP;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Question question = new Question
                .Builder()
                .id(1)
                .subject("sbb란 무엇인가요?")
                .content("sbb에 대해서 알고 싶습니다.")
                .createDate(LocalDateTime.now())
                .build();

        System.out.println("question = " + question);
    }

}
