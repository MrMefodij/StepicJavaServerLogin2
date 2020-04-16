package account;

public class UserProfile {
    private final UserName userName;
    private final UserPassword userPassword;
    private final UserEmail userEmail;

    public UserProfile(String _userName, String _userPassword, String _userEmail){
        this.userName = new UserName(_userName);
        this.userPassword = new UserPassword(_userPassword);
        this.userEmail = new UserEmail(_userEmail);
    }

    public UserProfile(String _userName){
        this.userName = new UserName(_userName);
        this.userPassword = new UserPassword(_userName);
        this.userEmail = new UserEmail(_userName + "@mail.ru");
    }

    public String getLogin() {
        return this.userName.getUserName();
    }

    public String getPass() {
        return this.userPassword.getUserPassword();
    }

    public String getEmail() {
        return this.userEmail.getUserEmail();
    }

}
