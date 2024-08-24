package berry.groupEvents.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import berry.groupEvents.domain.exceptions.FullGroupException;
import berry.groupEvents.domain.exceptions.UserAlreadyInGroupException;
import berry.groupEvents.domain.exceptions.UserNotInGroupException;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupTest {
    
    private static final int SMALL_GROUP_MAX_SIZE = 1;
    private static final int MEDIUM_GROUP_MAX_SIZE = 2;
    
    private User user1;
    private User user2;

    private Group smallGroup;
    private Group mediumGroup;

    @BeforeEach
    public void setup() {
        this.smallGroup = new Group(SMALL_GROUP_MAX_SIZE);
        this.mediumGroup = new Group(MEDIUM_GROUP_MAX_SIZE);
        this.user1 = new User();
        this.user2 = new User();
    }

    @Test
    public void givenEmptyGroup_whenAddingUserToGroup_thenUserIsAddedToGroup() {

        smallGroup.addUser(user1);

        assertEquals(user1, smallGroup.getUsers().get(0));
    }

    @Test
    public void givenFullGroup_whenAddingUser_thenThrowsGroupFullException() {

        smallGroup.addUser(user1);

        assertThrows(FullGroupException.class, () -> {
            smallGroup.addUser(user2);
        });
    }

    @Test
    public void givenGroupWithUser_whenAddingUserWhoIsAlreadyInGroup_thenUserAlreadyInGroupExceptionThrown() {

        mediumGroup.addUser(user1);

        assertThrows(UserAlreadyInGroupException.class, () -> mediumGroup.addUser(user1));
    }

    @Test
    public void givenGroupWithUser_whenRemovingUserWhoIsInGroup_thenUserIsRemovedFromGroup() {

        smallGroup.addUser(user1); 

        smallGroup.removeUser(user1);

        assertThat(smallGroup.getUsers()).doesNotContain(user1);
    }

    @Test
    public void givenGroup_whenRemovingUserWhoIsNotInGroup_thenUserNotInGroupExceptionThrown() {

        assertThrows(UserNotInGroupException.class, 
            () -> smallGroup.removeUser(user1));
    }
}
