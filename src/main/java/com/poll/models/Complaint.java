package com.poll.models;

public class Complaint {
	int id;
	int complaintBy;
	int complaintOf;
	String status;
	String assignedTo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getComplaintBy() {
		return complaintBy;
	}

	public void setComplaintBy(int conplaintBy) {
		this.complaintBy = conplaintBy;
	}

	public int getComplaintOf() {
		return complaintOf;
	}

	public void setComplaintOf(int complaintOf) {
		this.complaintOf = complaintOf;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	@Override
	public String toString() {
		return "Complaint [id=" + id + ", conplaintBy=" + complaintBy + ", complaintOf=" + complaintOf + ", status=" + status + ", assignedTo=" + assignedTo + "]";
	}

}
