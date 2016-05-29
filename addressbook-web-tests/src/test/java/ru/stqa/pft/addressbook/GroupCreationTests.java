package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testsGroupCreation() {
        gotoGroupPage();
        createNewGroup();
        fillGroupForm(new GroupData("Test1", "test2", "test3"));
        submitGroup();
        returnToGroups();
    }

}
