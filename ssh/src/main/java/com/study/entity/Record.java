package com.study.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Authorz; sloth
 * @Description:
 * @Data:Create in 10:22 2019/7/2
 * @Modificd By;
 */
@Entity
public class Record  implements Serializable {

    private static final long serialVersionUID = 4787840327796157317L;
    private String time;
    private String name;
    private String num;
    private String people;
    private String id;
    private String status;
    private String bookId;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Id
    @Column(name = "time", nullable = false, length = 40)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "num", nullable = true, length = 20)
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Basic
    @Column(name = "people", nullable = true, length = 20)
    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    @Basic
    @Column(name = "id", nullable = true, length = 20)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(time, record.time) &&
                Objects.equals(name, record.name) &&
                Objects.equals(num, record.num) &&
                Objects.equals(people, record.people) &&
                Objects.equals(id, record.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(time, name, num, people, id);
    }
}
