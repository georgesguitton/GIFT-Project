package com.gift.giftproject.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "documents", schema = "public", catalog = "GIFTProject")
public class DocumentsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_documents", nullable = false)
    private int idDocuments;
    @Basic
    @Column(name = "is_specs_done", nullable = false)
    private boolean isSpecsDone;
    @Basic
    @Column(name = "is_visit_form_done", nullable = false)
    private boolean isVisitFormDone;
    @Basic
    @Column(name = "is_company_eval_form_done", nullable = false)
    private boolean isCompanyEvalFormDone;
    @Basic
    @Column(name = "is_web_poll_done", nullable = false)
    private boolean isWebPollDone;
    @Basic
    @Column(name = "is_report_done", nullable = false)
    private boolean isReportDone;
    @OneToMany(mappedBy = "documentsByIdDocuments")
    private Collection<StudentEntity> studentsByIdDocuments;

    public int getIdDocuments() {
        return idDocuments;
    }

    public void setIdDocuments(int idDocuments) {
        this.idDocuments = idDocuments;
    }

    public boolean isSpecsDone() {
        return isSpecsDone;
    }

    public void setSpecsDone(boolean specsDone) {
        isSpecsDone = specsDone;
    }

    public boolean isVisitFormDone() {
        return isVisitFormDone;
    }

    public void setVisitFormDone(boolean visitFormDone) {
        isVisitFormDone = visitFormDone;
    }

    public boolean isCompanyEvalFormDone() {
        return isCompanyEvalFormDone;
    }

    public void setCompanyEvalFormDone(boolean companyEvalFormDone) {
        isCompanyEvalFormDone = companyEvalFormDone;
    }

    public boolean isWebPollDone() {
        return isWebPollDone;
    }

    public void setWebPollDone(boolean webPollDone) {
        isWebPollDone = webPollDone;
    }

    public boolean isReportDone() {
        return isReportDone;
    }

    public void setReportDone(boolean reportDone) {
        isReportDone = reportDone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocumentsEntity that = (DocumentsEntity) o;

        if (idDocuments != that.idDocuments) return false;
        if (isSpecsDone != that.isSpecsDone) return false;
        if (isVisitFormDone != that.isVisitFormDone) return false;
        if (isCompanyEvalFormDone != that.isCompanyEvalFormDone) return false;
        if (isWebPollDone != that.isWebPollDone) return false;
        if (isReportDone != that.isReportDone) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDocuments;
        result = 31 * result + (isSpecsDone ? 1 : 0);
        result = 31 * result + (isVisitFormDone ? 1 : 0);
        result = 31 * result + (isCompanyEvalFormDone ? 1 : 0);
        result = 31 * result + (isWebPollDone ? 1 : 0);
        result = 31 * result + (isReportDone ? 1 : 0);
        return result;
    }

    public Collection<StudentEntity> getStudentsByIdDocuments() {
        return studentsByIdDocuments;
    }

    public void setStudentsByIdDocuments(Collection<StudentEntity> studentsByIdDocuments) {
        this.studentsByIdDocuments = studentsByIdDocuments;
    }
}
