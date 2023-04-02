package com.example.tests.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="student_answer")
@Table
public class StudentAnswer {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="test_id")
    private Long testID;

    @Column(name="user_id")
    private Long userID;

    @Column(name="answer_id")
    private Long answerID;

    public StudentAnswer() {
    }

    public StudentAnswer(Long rowID, Long testID, Long userID, Long answerID) {
        this.id = rowID;
        this.testID = testID;
        this.userID = userID;
        this.answerID = answerID;
    }

    public Long getRowID() {
        return id;
    }

    public void setRowID(Long rowID) {
        this.id = rowID;
    }

    public Long getTestID() {
        return testID;
    }

    public void setTestID(Long testID) {
        this.testID = testID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Long answerID) {
        this.answerID = answerID;
    }
}
