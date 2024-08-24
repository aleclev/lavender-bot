package berry.groupEvents.exceptions;

import berry.groupEvents.Group;
import berry.groupEvents.User;

public class UserNotInGroupException extends RuntimeException {
    
    public UserNotInGroupException(Group group, User user) {
        super("User %s cannot leave group %s. This user is not part of the group.");
    }
}
