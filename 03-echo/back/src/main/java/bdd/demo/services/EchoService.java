package bdd.demo.services;

import javax.ejb.Stateless;

import bdd.demo.domain.Message;

@Stateless
public class EchoService {

    public Message strict(String content) {
        Message message = new Message().content(content);
        return message;
    }

    public Message uppercase(String content) {
        Message message = new Message().content(content.toUpperCase());
        return message;
    }

    public Message lowercase(String content) {
        Message message = new Message().content(content.toLowerCase());
        return message;
    }

}
