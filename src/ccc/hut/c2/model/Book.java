package ccc.hut.c2.model;

public class Book {
	private String ISBN;
	private String bookName;
	private String author;
	private String publisher;
	private float price;
	private int cnum;
	private int snum;
	private String summary;
	private byte[] photo;
	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	/**
	 * @return the iSBN
	 */
	public String getISBN() {
		return ISBN;
	}
	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param cnum the cnum to set
	 */
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	/**
	 * @return the cnum
	 */
	public int getCnum() {
		return cnum;
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
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * @param photos the photo to set
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
