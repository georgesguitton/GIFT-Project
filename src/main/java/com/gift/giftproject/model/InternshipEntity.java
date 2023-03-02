package com.gift.giftproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "internship", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InternshipEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_internship", nullable = false)
    private int idInternship;
    @Basic
    @Column(name = "is_visit_planified", nullable = false)
    private boolean isVisitPlanified;
    @Basic
    @Column(name = "is_visit_done", nullable = false)
    private boolean isVisitDone;
    @Basic
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Basic
    @Column(name = "end_date", nullable = false)
    private Date endDate;
    @Basic
    @Column(name = "company_name", nullable = false, length = 50)
    private String companyName;
    @Basic
    @Column(name = "company_address", nullable = false, length = 200)
    private String companyAddress;
    @Basic
    @Column(name = "mission", nullable = false, length = -1)
    private String mission;
    @Basic
    @Column(name = "company_tutor", nullable = false, length = 50)
    private String companyTutor;
    @OneToMany(mappedBy = "internshipByIdInternship")
    private Collection<StudentEntity> studentsByIdInternship;

    public int getIdInternship() {
        return idInternship;
    }

    public void setIdInternship(int idInternship) {
        this.idInternship = idInternship;
    }

    public boolean isVisitPlanified() {
        return isVisitPlanified;
    }

    public void setVisitPlanified(boolean visitPlanified) {
        isVisitPlanified = visitPlanified;
    }

    public boolean isVisitDone() {
        return isVisitDone;
    }

    public void setVisitDone(boolean visitDone) {
        isVisitDone = visitDone;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getCompanyTutor() {
        return companyTutor;
    }

    public void setCompanyTutor(String companyTutor) {
        this.companyTutor = companyTutor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InternshipEntity that = (InternshipEntity) o;

        if (idInternship != that.idInternship) return false;
        if (isVisitPlanified != that.isVisitPlanified) return false;
        if (isVisitDone != that.isVisitDone) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (companyAddress != null ? !companyAddress.equals(that.companyAddress) : that.companyAddress != null)
            return false;
        if (mission != null ? !mission.equals(that.mission) : that.mission != null) return false;
        if (companyTutor != null ? !companyTutor.equals(that.companyTutor) : that.companyTutor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idInternship;
        result = 31 * result + (isVisitPlanified ? 1 : 0);
        result = 31 * result + (isVisitDone ? 1 : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (companyAddress != null ? companyAddress.hashCode() : 0);
        result = 31 * result + (mission != null ? mission.hashCode() : 0);
        result = 31 * result + (companyTutor != null ? companyTutor.hashCode() : 0);
        return result;
    }

    public Collection<StudentEntity> getStudentsByIdInternship() {
        return studentsByIdInternship;
    }

    public void setStudentsByIdInternship(Collection<StudentEntity> studentsByIdInternship) {
        this.studentsByIdInternship = studentsByIdInternship;
    }
}
