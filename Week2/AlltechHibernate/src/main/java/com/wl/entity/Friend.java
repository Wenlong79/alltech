package com.wl.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Friend")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "real_name", nullable = false)
    private String realName;


    @ElementCollection
    @Column(name = "nick_name")
    /**
     * Friend_nicknames, name of the other table.
     * This name will be created by appending 'nicknames' to Friend(this table name).
     *
     */

    private Collection<String> nicknames = new ArrayList<>();

    public Friend() {

    }

    public Friend(String realName) {
        this.realName = realName;
    }


    public Collection<String> getNicknames() {
        return nicknames;
    }

    public void setNicknames(Collection<String> nicknames) {
        this.nicknames = nicknames;
    }
}
