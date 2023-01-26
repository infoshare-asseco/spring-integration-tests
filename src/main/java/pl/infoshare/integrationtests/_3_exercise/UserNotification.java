package pl.infoshare.integrationtests._3_exercise;

public class UserNotification {

    private final String text;
    private final String target;
    private final UserNotificationResult result;

    private UserNotification(String text, String target, UserNotificationResult result) {
        this.text = text;
        this.target = target;
        this.result = result;
    }

    public static UserNotification success(String text, String target) {
        return new UserNotification(text, target, UserNotificationResult.SUCCESS);
    }

    public static UserNotification inactive(String target) {
        return new UserNotification("", target, UserNotificationResult.INACTIVE);
    }

    public String getText() {
        return text;
    }

    public String getTarget() {
        return target;
    }

    public UserNotificationResult getResult() {
        return result;
    }
}
