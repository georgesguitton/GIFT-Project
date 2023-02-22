package com.gift.giftproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student", schema = "public", catalog = "GIFT-Project")
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
    @Basic
    @Column(name = "id_tutor", nullable = false)
    private int idTutor;
    @Basic
    @Column(name = "id_internship", nullable = false)
    private int idInternship;
    @Basic
    @Column(name = "id_evaluations", nullable = false)
    private int idEvaluations;
    @Basic
    @Column(name = "id_documents", nullable = false)
    private int idDocuments;
    @ManyToOne
    @JoinColumn(name = "id_internship", referencedColumnName = "id_internship", nullable = false)
    private InternshipEntity internshipByIdInternship;
    @ManyToOne
    @JoinColumn(name = "id_evaluations", referencedColumnName = "id_evaluations", nullable = false)
    private EvaluationsEntity evaluationsByIdEvaluations;
    @ManyToOne
    @JoinColumn(name = "id_documents", referencedColumnName = "id_documents", nullable = false)
    private DocumentsEntity documentsByIdDocuments;

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

    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
    }

    public int getIdInternship() {
        return idInternship;
    }

    public void setIdInternship(int idInternship) {
        this.idInternship = idInternship;
    }

    public int getIdEvaluations() {
        return idEvaluations;
    }

    public void setIdEvaluations(int idEvaluations) {
        this.idEvaluations = idEvaluations;
    }

    public int getIdDocuments() {
        return idDocuments;
    }

    public void setIdDocuments(int idDocuments) {
        this.idDocuments = idDocuments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (id != that.id) return false;
        if (idTutor != that.idTutor) return false;
        if (idInternship != that.idInternship) return false;
        if (idEvaluations != that.idEvaluations) return false;
        if (idDocuments != that.idDocuments) return false;
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
        result = 31 * result + idTutor;
        result = 31 * result + idInternship;
        result = 31 * result + idEvaluations;
        result = 31 * result + idDocuments;
        return result;
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

    public DocumentsEntity getDocumentsByIdDocuments() {
        return documentsByIdDocuments;
    }

    public void setDocumentsByIdDocuments(DocumentsEntity documentsByIdDocuments) {
        this.documentsByIdDocuments = documentsByIdDocuments;
    }
}
