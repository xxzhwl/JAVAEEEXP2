package ccc.hut.c2.tool;

public class Pager {
	private int pageNow;         //当前页数
	private int pageSize=4;      //每页显示多少条记录
	private int totalPage;       //共有多少页
	private int totalSize;       //一共多少记录
	private boolean hasFirst;    //是否有首页
	private boolean hasPre;      //是否有前一页
	private boolean hasNext;     //是否有下一页
	private boolean hasLast;     //是否有最后一页
	public Pager(int pageNow,int totalSize){
		//利用构造方法为变量赋值
		this.pageNow = pageNow;
		this.totalSize = totalSize;
	}
	/**
	 * @param pageNow the pageNow to set
	 */
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	/**
	 * @return the pageNow
	 */
	public int getPageNow() {
		return pageNow;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		//计算多少页
		totalPage = this.getTotalSize()/this.getPageSize();
		if(totalSize%pageSize!=0){
			totalPage++;
		}
		return totalPage;
	}
	/**
	 * @param totalSize the totalSize to set
	 */
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	/**
	 * @return the totalSize
	 */
	public int getTotalSize() {
		return totalSize;
	}
	/**
	 * @param hasFirst the hasFirst to set
	 */
	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}
	/**
	 * @return the hasFirst
	 */
	public boolean isHasFirst() {
		if(pageNow==1){
			return false;
		}
		else return true;
		
	}
	/**
	 * @param hasPre the hasPre to set
	 */
	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}
	/**
	 * @return the hasPre
	 */
	public boolean isHasPre() {
		if(this.isHasFirst())
			 return true;
		else return false;
	}
	/**
	 * @param hasNext the hasNext to set
	 */
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	/**
	 * @return the hasNext
	 */
	public boolean isHasNext() {
		if(this.isHasLast()){
			return true;
		}
		else return false;
	}
	/**
	 * @param hasLast the hasLast to set
	 */
	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
	/**
	 * @return the hasLast
	 */
	public boolean isHasLast() {
		if(pageNow == this.getTotalPage())
			return false;
		else return true;
	}
}
