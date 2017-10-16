package com.collaborate.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Job_details")
@Component
public class Job {
	
	private int JobId;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	

	private String jobTitle;

	private String jobDescription;
	private String qualification;
	private String yrsOfExp;
	private String skillsRequired;
	private String salary;
	private Date postedOn;
	private String location;
	private String companyName;
	private String status;
	public int getJobId() {
		return JobId;
	}
	public void setJobId(int jobId) {
		JobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public String getQualification() {
		return qualification;
	}
	public String getYrsOfExp() {
		return yrsOfExp;
	}
	public String getSkillsRequired() {
		return skillsRequired;
	}
	public String getSalary() {
		return salary;
	}
	public Date getPostedOn() {
		return postedOn;
	}
	public String getLocation() {
		return location;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getStatus() {
		return status;
	}
	
}
