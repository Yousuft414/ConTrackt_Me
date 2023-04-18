package com.example.contrackt_me.view;

import java.util.List;

public class Contractor {

    String Name, Quote, PostalCode, Address, PhoneNumber, Email;
    List<String> Keywords;
    float Rating;
    Reviews [] reviews;

    public Contractor() {
    }

    public Contractor(String name, String quote, String postalCode, String address, String phoneNumber, String email, List<String> keywords, float rating, Reviews[] reviews) {
        Name = name;
        Quote = quote;
        PostalCode = postalCode;
        Address = address;
        PhoneNumber = phoneNumber;
        Email = email;
        Keywords = keywords;
        Rating = rating;
        this.reviews = reviews;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getQuote() {
        return Quote;
    }

    public void setQuote(String quote) {
        Quote = quote;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public List<String> getKeywords() {
        return Keywords;
    }

    public void setKeywords(List<String> keywords) {
        Keywords = keywords;
    }

    public float getRating() {
        return Rating;
    }

    public void setRating(float rating) {
        Rating = rating;
    }

    public Reviews[] getReviews() {
        return reviews;
    }

    public void setReviews(Reviews[] reviews) {
        this.reviews = reviews;
    }
}
