package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test
    public void testsGroupCreation() {

        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("Test2");
        app.group().create(group);
        Set<GroupData> after = app.group().all();
       Assert.assertEquals(after.size(), before.size() + 1);

//        int max = 0;
//        for (GroupData g : after) {
//            if (g.getId() > max) {
//                max = g.getId();
//            }
//        }
      group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before, after);

    }

}
