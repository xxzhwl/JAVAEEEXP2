package ccc.hut.c2.model;

import java.util.Date;

public class Student {
	private String readerId;
	private String name;
	private String spec;
	private boolean sex;
	private Date born;
	private int num;
	private int snum;
	private byte[] photo;
	/**
	 * @param readerId the readerId to set
	 */
	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}
	/**
	 * @return the readerId
	 */
	public String getReaderId() {
		return readerId;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param spec the spec to set
	 */
	public void setSpec(String spec) {
		this.spec = spec;
	}
	/**
	 * @return the spec
	 */
	public String getSpec() {
		return spec;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	/**
	 * @return the sex
	 */
	public boolean isSex() {
		return sex;
	}
	/**
	 * @param born the born to set
	 */
	public void setBorn(Date born) {
		this.born = born;
	}
	/**
	 * @return the born
	 */
	public Date getBorn() {
		return born;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param snum the snum to set
	 */
	public void setSnum(int snum) {
		this.snum = snum;
	}
	/**
	 * @return the snum
	 */
	public int getSnum() {
		return snum;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	/**
	 * @return the photo
	 */
	public byte[] getPhoto() {
		return photo;
	}
	
}
