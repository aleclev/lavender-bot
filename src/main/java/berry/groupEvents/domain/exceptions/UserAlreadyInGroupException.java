package berry.groupEvents.domain.exceptions;

import berry.groupEvents.domain.Group;
import berry.groupEvents.domain.User;

public class UserAlreadyInGroupException extends RuntimeException {
    
    public UserAlreadyInGroupException(Group group, User user) {
        super("User %s cannot join group %s. This user is already in this group.");
    }
}
