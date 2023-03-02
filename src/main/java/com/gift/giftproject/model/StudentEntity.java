package com.gift.giftproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student", schema = "public")
@NamedQuery(name = "findStudentsOfTutorId", query = "SELECT s from StudentEntity s where s.tutorByIdTutor.idTutor = :idTutor")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;
    @Basic
    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;
    @Basic
    @Column(name = "student_group", nullable = false, length = 50)
    private String studentGroup;
    @Basic
    @Column(name = "comments", nullable = false, length = -1)
    private String comments;

    @ManyToOne
    @JoinColumn(name = "id_tutor", referencedColumnName = "id_tutor", nullable = false)
    private TutorEntity tutorByIdTutor;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_internship", referencedColumnName = "id_internship", nullable = false)
    private InternshipEntity internshipByIdInternship;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_evaluations", referencedColumnName = "id_evaluations", nullable = false)
    private EvaluationsEntity evaluationsByIdEvaluations;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_documentstatus", referencedColumnName = "id_documentstatus", nullable = false)
    private DocumentstatusEntity documentsByIdDocuments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (studentGroup != null ? !studentGroup.equals(that.studentGroup) : that.studentGroup != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (studentGroup != null ? studentGroup.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }

    public TutorEntity getTutorByIdTutor() {
        return tutorByIdTutor;
    }

    public void setTutorByIdTutor(TutorEntity tutorByIdTutor) {
        this.tutorByIdTutor = tutorByIdTutor;
    }

    public InternshipEntity getInternshipByIdInternship() {
        return internshipByIdInternship;
    }

    public void setInternshipByIdInternship(InternshipEntity internshipByIdInternship) {
        this.internshipByIdInternship = internshipByIdInternship;
    }

    public EvaluationsEntity getEvaluationsByIdEvaluations() {
        return evaluationsByIdEvaluations;
    }

    public void setEvaluationsByIdEvaluations(EvaluationsEntity evaluationsByIdEvaluations) {
        this.evaluationsByIdEvaluations = evaluationsByIdEvaluations;
    }

    public DocumentstatusEntity getDocumentsByIdDocuments() {
        return documentsByIdDocuments;
    }

    public void setDocumentsByIdDocuments(DocumentstatusEntity documentsByIdDocuments) {
        this.documentsByIdDocuments = documentsByIdDocuments;
    }
}
