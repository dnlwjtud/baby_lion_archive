package io.dnlwjtud.builderP;

import java.time.LocalDateTime;

public class Question {

    private Integer id;
    private String subject;
    private String content;

    private LocalDateTime createDate;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", content=" + content  +
                ", createDate=" + createDate +
                '}';
    }

    public static class Builder {

        private Integer id;
        private String subject;
        private String content;

        private LocalDateTime createDate;

        public Builder() {
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder createDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public Question build() {
            return new Question(this);
        }

    }

    public Question(Builder builder) {
        this.id = builder.id;
        this.subject = builder.subject;
        this.content = builder.content;
        this.createDate = builder.createDate;
    }

}