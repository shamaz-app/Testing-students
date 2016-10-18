package by.testing.entities.student;

import by.testing.entities.IdEntity;
import by.testing.entities.test.AnswerOption;
import by.testing.entities.test.Question;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Анастасия on 07.09.2016.
 */
@Entity
public class StudentQuestion extends IdEntity {

    @NotNull
    private Student student;

    @NotNull
    private Question question;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "student_answer",
//            joinColumns = @JoinColumn(name = "student_question_id"),
//            inverseJoinColumns = @JoinColumn(name = "answer_option_id"))
//    private Set<AnswerOption> answerOptions;

//    public Set<AnswerOption> getAnswerOptions() {
//        return answerOptions;
//    }
//
//    public void setAnswerOptions(Set<AnswerOption> answerOptions) {
//        this.answerOptions = answerOptions;
//    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
