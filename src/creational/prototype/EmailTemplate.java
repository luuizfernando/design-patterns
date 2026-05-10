package creational.prototype;

public class EmailTemplate implements Cloneable {

    private String subject;
    private String body;
    private  String footer;

    public EmailTemplate(String subject, String body, String footer) {
        this.subject = subject;
        this.body = body;
        this.footer = footer;
    }

    public void sendEmail(String to) {
        System.out.println("Sending email to " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
        System.out.println("Footer: " + footer);
    }


    @Override
    public EmailTemplate clone() {
        try {
            return (EmailTemplate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "EmailTemplate{" +
                "subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", footer='" + footer + '\'' +
                '}';
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

}