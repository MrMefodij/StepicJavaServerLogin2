package account;

public class UserName <T extends String> {
    private final T userName;

    public UserName (T _userName){
        this.userName = _userName;
    }
    public T getUserName(){
        return this.userName;
    }
}
