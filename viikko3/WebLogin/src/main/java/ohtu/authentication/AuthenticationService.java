package ohtu.authentication;

import static java.lang.Character.isLetter;
import ohtu.data_access.UserDao;
import ohtu.domain.User;
import ohtu.util.CreationStatus;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public CreationStatus createUser(String username, String password, String passwordConfirmation) {
        CreationStatus status = new CreationStatus();
        
        if (userDao.findByName(username) != null) {
            status.addError("username is already taken");
        }

        if (username.length()<3 ) {
            status.addError("username should have at least 3 characters");
        }
        
        for (int i = 0; i < username.length(); i++) {
            if (!isLetter(username.charAt(i))) {
                status.addError("username should have only letters");
            }
        }
        
        if (password.length() < 8) {
            status.addError("password should have at least 8 characters");
        }
        
        boolean passunMerkit = false;
        for (int j = 0; j < password.length(); j++) {
            if (!isLetter(password.charAt(j))) {
                passunMerkit = true;
            }
        }
        if (passunMerkit == false) {
            status.addError("password should not have only letters");
        }
                        
        if (!password.equals(passwordConfirmation)) {
            status.addError("password and password confirmation do not match");
        }
        
        if (status.isOk()) {
            userDao.add(new User(username, password));
        }
        
        return status;
    }

}
