package berry.groupEvents.exceptions;

import berry.groupEvents.Group;
import berry.groupEvents.User;

public class UserAlreadyInGroupException extends RuntimeException {
    
    public UserAlreadyInGroupException(Group group, User user) {
        super("User %s cannot join group %s. This user is already in this group.");
    }
}
