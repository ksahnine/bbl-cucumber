package bdd.demo.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Message {
    private String content;
    private Date receivedAt = new Date();

    public Message() {}

    public Message content(String content) {
        this.content = content;
        return this;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }
}