package com.gift.giftproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documentstatus", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentstatusEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_documentstatus", nullable = false)
    private int idDocumentstatus;
    @Basic
    @Column(name = "is_specs_done", nullable = false)
    private Boolean isSpecsDone;
    @Basic
    @Column(name = "is_visit_form_done", nullable = false)
    private Boolean isVisitFormDone;
    @Basic
    @Column(name = "is_company_eval_form_done", nullable = false)
    private Boolean isCompanyEvalFormDone;
    @Basic
    @Column(name = "is_web_poll_done", nullable = false)
    private Boolean isWebPollDone;
    @Basic
    @Column(name = "is_report_done", nullable = false)
    private Boolean isReportDone;

    public int getIdDocumentstatus() {
        return idDocumentstatus;
    }

    public void setIdDocumentstatus(int idDocumentstatus) {
        this.idDocumentstatus = idDocumentstatus;
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

        DocumentstatusEntity that = (DocumentstatusEntity) o;

        if (idDocumentstatus != that.idDocumentstatus) return false;
        if (isSpecsDone != that.isSpecsDone) return false;
        if (isVisitFormDone != that.isVisitFormDone) return false;
        if (isCompanyEvalFormDone != that.isCompanyEvalFormDone) return false;
        if (isWebPollDone != that.isWebPollDone) return false;
        if (isReportDone != that.isReportDone) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDocumentstatus;
        result = 31 * result + (isSpecsDone ? 1 : 0);
        result = 31 * result + (isVisitFormDone ? 1 : 0);
        result = 31 * result + (isCompanyEvalFormDone ? 1 : 0);
        result = 31 * result + (isWebPollDone ? 1 : 0);
        result = 31 * result + (isReportDone ? 1 : 0);
        return result;
    }
}
