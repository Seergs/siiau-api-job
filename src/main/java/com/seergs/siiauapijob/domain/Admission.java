package com.seergs.siiauapijob.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Admission {
  private String calendar;
  private String schoolOfOrigin;
  private String admissionType;
  private String gpaSchoolOfOrigin;
  private String admissionTestScore;
  private String admissionScore;
  private String personalContribution;
  private String career;

  public Admission() {}

  public String getCalendar() {
    return calendar;
  }

  public void setCalendar(String calendar) {
    this.calendar = calendar;
  }

  public String getSchoolOfOrigin() {
    return schoolOfOrigin;
  }

  public void setSchoolOfOrigin(String schoolOfOrigin) {
    this.schoolOfOrigin = schoolOfOrigin;
  }

  public String getAdmissionType() {
    return admissionType;
  }

  public void setAdmissionType(String admissionType) {
    this.admissionType = admissionType;
  }

  public String getGpaSchoolOfOrigin() {
    return gpaSchoolOfOrigin;
  }

  public void setGpaSchoolOfOrigin(String gpaSchoolOfOrigin) {
    this.gpaSchoolOfOrigin = gpaSchoolOfOrigin;
  }

  public String getAdmissionTestScore() {
    return admissionTestScore;
  }

  public void setAdmissionTestScore(String admissionTestScore) {
    this.admissionTestScore = admissionTestScore;
  }

  public String getAdmissionScore() {
    return admissionScore;
  }

  public void setAdmissionScore(String admissionScore) {
    this.admissionScore = admissionScore;
  }

  public String getPersonalContribution() {
    return personalContribution;
  }

  public void setPersonalContribution(String personalContribution) {
    this.personalContribution = personalContribution;
  }

  public String getCareer() {
    return career;
  }

  public void setCareer(String career) {
    this.career = career;
  }

  @Override
  public String toString() {
    return "Admission{"
        + "calendar='"
        + calendar
        + '\''
        + ", schoolOfOrigin='"
        + schoolOfOrigin
        + '\''
        + ", admissionType='"
        + admissionType
        + '\''
        + ", gpaSchoolOfOrigin='"
        + gpaSchoolOfOrigin
        + '\''
        + ", admissionTestScore='"
        + admissionTestScore
        + '\''
        + ", admissionScore='"
        + admissionScore
        + '\''
        + ", personalContribution='"
        + personalContribution
        + '\''
        + ", career='"
        + career
        + '\''
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Admission admission = (Admission) o;
    return Objects.equals(calendar, admission.calendar)
        && Objects.equals(schoolOfOrigin, admission.schoolOfOrigin)
        && Objects.equals(admissionType, admission.admissionType)
        && Objects.equals(gpaSchoolOfOrigin, admission.gpaSchoolOfOrigin)
        && Objects.equals(admissionTestScore, admission.admissionTestScore)
        && Objects.equals(admissionScore, admission.admissionScore)
        && Objects.equals(personalContribution, admission.personalContribution)
        && Objects.equals(career, admission.career);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        calendar,
        schoolOfOrigin,
        admissionType,
        gpaSchoolOfOrigin,
        admissionTestScore,
        admissionScore,
        personalContribution,
        career);
  }
}
