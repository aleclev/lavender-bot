package berry.groupEvents.domain.exceptions;

import berry.groupEvents.domain.Group;

public class FullGroupException extends RuntimeException {
    
    public FullGroupException(Group group) {
        super("Cannot join group %s, group is full.");
    }
}
