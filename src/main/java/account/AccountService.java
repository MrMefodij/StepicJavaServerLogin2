package account;

import java.util.Map;
import java.util.HashMap;

public class AccountService {
    private final Map<String,UserProfile> loginToProfile;
    private final Map<String,UserProfile> sessionIdToProfile;

    public AccountService() {
        loginToProfile = new HashMap<>();
        sessionIdToProfile = new HashMap<>();
    }

    public void addNewUser(String _userProfile){
        UserProfile userProfile = new UserProfile(_userProfile);
        System.out.println(userProfile.getLogin() + " " +userProfile.getPass() +" " + userProfile.getEmail());
    }

    public void addNewUser(String _name, String _password, String _email) {
        UserProfile userProfile = new UserProfile(_name, _password,_email);
        System.out.println(userProfile.getLogin() + " " +userProfile.getPass() +" " + userProfile.getEmail());
    }

    public UserProfile getUserByLogin(String login) {
        return loginToProfile.get(login);
    }

    public UserProfile getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }

    public void addSession(String sessionId, UserProfile userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }

    public void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }
}
