package ccc.hut.c2.tool;

public class Pager {
	private int pageNow;         //��ǰҳ��
	private int pageSize=4;      //ÿҳ��ʾ��������¼
	private int totalPage;       //���ж���ҳ
	private int totalSize;       //һ�����ټ�¼
	private boolean hasFirst;    //�Ƿ�����ҳ
	private boolean hasPre;      //�Ƿ���ǰһҳ
	private boolean hasNext;     //�Ƿ�����һҳ
	private boolean hasLast;     //�Ƿ������һҳ
	public Pager(int pageNow,int totalSize){
		//���ù��췽��Ϊ������ֵ
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
		//�������ҳ
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
