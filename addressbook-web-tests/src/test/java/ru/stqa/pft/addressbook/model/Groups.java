package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.security.acl.Group;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kompu on 6/18/2016.
 */
public class Groups extends ForwardingSet<GroupData>{

  private Set<GroupData> delegate;

  public Groups(Groups groups) {
    this.delegate = new HashSet<GroupData>(groups.delegate);
  }

  public Groups() {
    this.delegate = new HashSet<GroupData>();
  }

  @Override
  protected Set<GroupData> delegate() {
    return null;
  }
  public Groups withAdded(GroupData group){
    Groups groups = new Groups(this);
    groups.add(group);
    return groups;
  }
  public Groups without(GroupData group){
    Groups groups = new Groups(this);
    groups.remove(group);
    return groups;
  }
}
