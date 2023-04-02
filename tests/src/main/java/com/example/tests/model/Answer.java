package com.example.tests.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity(name="answer")
@Table
public class Answer {

    @Id
    @Column(name="question_id")
    private Long questionId;

    @Column(name="text")
    private String text;
    
    @Column(name="correct")
    private Boolean correct;

    @ManyToMany
    @JoinColumn(name="row_id", referencedColumnName = "answer_id")
    private Set<StudentAnswer> studentAnswerList;
    public Set<StudentAnswer> getStudentAnswerList(){
        return studentAnswerList;
    }

    public Answer(Long questionId, String text, Boolean correct) {
        this.questionId = questionId;
        this.text = text;
        this.correct = correct;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
