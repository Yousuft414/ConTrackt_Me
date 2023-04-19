package com.example.contrackt_me.model;

public class Reviews {

    String Reviewer, ReviewDesc, ContractorID;
    float RateQualityOfWork, RateCommunication, RateValue, OverallRating;

    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String reviewer) {
        Reviewer = reviewer;
    }

    public String getReviewDesc() {
        return ReviewDesc;
    }

    public void setReviewDesc(String reviewDesc) {
        ReviewDesc = reviewDesc;
    }

    public String getContractorID() {
        return ContractorID;
    }

    public void setContractorID(String contractorID) {
        ContractorID = contractorID;
    }

    public float getRateQualityOfWork() {
        return RateQualityOfWork;
    }

    public void setRateQualityOfWork(float rateQualityOfWork) {
        RateQualityOfWork = rateQualityOfWork;
    }

    public float getRateCommunication() {
        return RateCommunication;
    }

    public void setRateCommunication(float rateCommunication) {
        RateCommunication = rateCommunication;
    }

    public float getRateValue() {
        return RateValue;
    }

    public void setRateValue(float rateValue) {
        RateValue = rateValue;
    }

    public float getOverallRating() {
        return OverallRating;
    }

    public void setOverallRating(float overallRating) {
        OverallRating = overallRating;
    }
}
