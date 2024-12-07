package com.ebuy.ebuy_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Feedback {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int feedbackid;
private String name,emailid,message;
public Feedback() {
	super();
	// TODO Auto-generated constructor stub
}
public Feedback(String name, String emailid, String message) {
	super();
	this.name = name;
	this.emailid = emailid;
	this.message = message;
}
public int getFeedbackid() {
	return feedbackid;
}
public void setFeedbackid(int feedbackid) {
	this.feedbackid = feedbackid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
@Override
public String toString() {
	return "Feedback [feedbackid=" + feedbackid + ", name=" + name + ", emailid=" + emailid + ", message=" + message
			+ "]";
}


	
}