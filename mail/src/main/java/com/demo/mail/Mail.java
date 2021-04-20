package com.demo.mail;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Mail {
    private final String from;
    private final String title;
    private final String to;
    private final String content;

    @Override
    public String toString() {
        return "Mail{" +
                "from='" + from + '\'' +
                ", title='" + title + '\'' +
                ", to='" + to + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
