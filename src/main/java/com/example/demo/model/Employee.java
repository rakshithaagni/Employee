package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
@Entity
public class Employee {
	
	/** The eid. */
	@Id
	private int eid;
	
	/** The ename. */
	private String ename;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + "]";
	}
	
	/**
	 * Gets the eid.
	 *
	 * @return the eid
	 */
	public int getEid() {
		return eid;
	}
	
	/**
	 * Sets the eid.
	 *
	 * @param eid the new eid
	 */
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	/**
	 * Gets the ename.
	 *
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}
	
	/**
	 * Sets the ename.
	 *
	 * @param ename the new ename
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	

}
