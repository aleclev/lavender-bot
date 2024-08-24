package berry.groupEvents.domain.exceptions;

import berry.groupEvents.domain.Group;
import berry.groupEvents.domain.User;

public class UserNotInGroupException extends RuntimeException {
    
    public UserNotInGroupException(Group group, User user) {
        super("User %s cannot leave group %s. This user is not part of the group.");
    }
}
