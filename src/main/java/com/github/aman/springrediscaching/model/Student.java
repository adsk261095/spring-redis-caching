package com.github.aman.springrediscaching.model;

import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Student implements Serializable {

    private static final long serialVersionUID = 7156526077883281623L;

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")

    private int id;
    private String name;
    private long followers;

    public Student() {
    }

    public Student(String name, long followers) {
        this.name = name;
        this.followers = followers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFollowers() {
        return followers;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
    }


    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', followers=%d}", id, name, followers);
    }
}
