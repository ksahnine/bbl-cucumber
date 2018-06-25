package bdd.demo.services;

import bdd.demo.domain.Message;

public class EchoService {

    public Message strict(String content) {
        return new Message().content(content);
    }

    public Message uppercase(String content) {
        return new Message().content(content.toUpperCase());
    }

    public Message lowercase(String content) {
        return new Message().content(content.toLowerCase());
    }

}
