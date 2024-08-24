package berry.groupEvents.domain;

import java.util.ArrayList;
import java.util.List;

import berry.groupEvents.domain.exceptions.FullGroupException;
import berry.groupEvents.domain.exceptions.UserAlreadyInGroupException;
import berry.groupEvents.domain.exceptions.UserNotInGroupException;

public class Group {

    private List<User> users;
    private int maxUserCount;

    public Group(int maxUserCount) {
        
        this.maxUserCount = maxUserCount;
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        
        if (users.size() >= maxUserCount)
            throw new FullGroupException(this);
        else if (users.contains(user))
            throw new UserAlreadyInGroupException(this, user);
        else
            users.add(user);
    }

    public List<User> getUsers() {
        
        return users;
    }

    public void removeUser(User user) {
        
        if (!users.contains(user))
            throw new UserNotInGroupException(this, user);
        else
            this.users.remove(user);
    }
    
}
