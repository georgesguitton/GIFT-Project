package com.gift.giftproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Table(name = "evaluations", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_evaluations", nullable = false)
    private int idEvaluations;
    @Basic
    @Column(name = "oral_presentation", nullable = false)
    private boolean oralPresentation;
    @Basic
    @Column(name = "technical_grade", nullable = false, precision = 0)
    private double technicalGrade;
    @Basic
    @Column(name = "communication_grade", nullable = false, precision = 0)
    private double communicationGrade;
    @OneToMany(mappedBy = "evaluationsByIdEvaluations")
    private Collection<StudentEntity> studentsByIdEvaluations;

    public int getIdEvaluations() {
        return idEvaluations;
    }

    public void setIdEvaluations(int idEvaluations) {
        this.idEvaluations = idEvaluations;
    }

    public boolean isOralPresentation() {
        return oralPresentation;
    }

    public void setOralPresentation(boolean oralPresentation) {
        this.oralPresentation = oralPresentation;
    }

    public double getTechnicalGrade() {
        return technicalGrade;
    }

    public void setTechnicalGrade(double technicalGrade) {
        this.technicalGrade = technicalGrade;
    }

    public double getCommunicationGrade() {
        return communicationGrade;
    }

    public void setCommunicationGrade(double communicationGrade) {
        this.communicationGrade = communicationGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluationsEntity that = (EvaluationsEntity) o;

        if (idEvaluations != that.idEvaluations) return false;
        if (oralPresentation != that.oralPresentation) return false;
        if (Double.compare(that.technicalGrade, technicalGrade) != 0) return false;
        if (Double.compare(that.communicationGrade, communicationGrade) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idEvaluations;
        result = 31 * result + (oralPresentation ? 1 : 0);
        temp = Double.doubleToLongBits(technicalGrade);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(communicationGrade);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Collection<StudentEntity> getStudentsByIdEvaluations() {
        return studentsByIdEvaluations;
    }

    public void setStudentsByIdEvaluations(Collection<StudentEntity> studentsByIdEvaluations) {
        this.studentsByIdEvaluations = studentsByIdEvaluations;
    }
}
