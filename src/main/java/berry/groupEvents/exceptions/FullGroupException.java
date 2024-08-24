package berry.groupEvents.exceptions;

import berry.groupEvents.Group;

public class FullGroupException extends RuntimeException {
    
    public FullGroupException(Group group) {
        super("Cannot join group %s, group is full.");
    }
}
