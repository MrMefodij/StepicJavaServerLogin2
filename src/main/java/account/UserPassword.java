package account;

public class UserPassword <T extends String> {
    private final T userPassword;
    public UserPassword (T _userName){
        this.userPassword = _userName;
    }
    public T getUserPassword(){
        return this.userPassword;
    }
}
