package creational.prototype;

public class MainApp {
    public static void main(String[] args) {
        EmailTemplate baseTemplate = new EmailTemplate("Hello!", "This is the main event", "luuizfernando");
        System.out.println("Base Template: "  + baseTemplate);

        System.out.println();

        System.out.println("SENDING GROUP EMAIL");
        EmailTemplate groupEmail = (EmailTemplate) baseTemplate.clone();
        groupEmail.setSubject("Hello team");
        groupEmail.sendEmail("testteam@email.com");

        System.out.println();

        System.out.println("SENDING INDIVIDUAL EMAIL");
        EmailTemplate individualEmail = (EmailTemplate) baseTemplate.clone();
        groupEmail.setSubject("Hello team");
        groupEmail.sendEmail("testindividual@email.com");
    }
}