package com.poll.models;

public class Pole {

	int id;
	String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Pole [id=" + id + ", address=" + address + "]";
	}
}
