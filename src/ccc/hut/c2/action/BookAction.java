package ccc.hut.c2.action;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import ccc.hut.c2.dao.*;
import ccc.hut.c2.model.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class BookAction extends ActionSupport{
		private String message;
		private File photo;
		private Book book;
		public String getMessage(){
			return this.message;
		}
		public void setMessage(String message){
			this.message = message;
		}
		
		public File getPhoto(){
			return photo;
		}
		public void setPhoto(File photo){
			this.photo = photo;
		}
		
		public Book getBook(){
			return book;
		}
		public void setBook(Book book){
			this.book = book;
		}
		BookDao bookDao=new BookDao();
		public String addBook() throws Exception{
			Book bo=bookDao.selectBook(book.getISBN());
			if(bo!=null){
				this.setMessage("ISBN�Ѿ����ڣ�");
				return SUCCESS;
			}
			Book b=new Book();
			b.setISBN(book.getISBN());
			b.setBookName(book.getBookName());
			b.setAuthor(book.getAuthor());
			b.setPublisher(book.getPublisher());
			b.setPrice(book.getPrice());
			b.setCnum(book.getCnum());
			b.setSnum(book.getCnum());
			b.setSummary(book.getSummary());
			if(this.getPhoto()!=null){
				FileInputStream fis=new FileInputStream(this.getPhoto());
				byte[] buffer=new byte[fis.available()];
				fis.read(buffer);
				b.setPhoto(buffer);
			}
			bookDao.addBook(b);
			this.setMessage("��ӳɹ���");
			return SUCCESS;
		}
		
		public String deleteBook() throws Exception{
			if(new LendDao().selectByBookISBN(book.getISBN())!=null){
				this.setMessage("��ͼ���Ѿ������,����ɾ��");
				return SUCCESS;
			}
			Book bo=bookDao.selectBook(book.getISBN());
			if(bo==null){
				this.setMessage("Ҫɾ����ͼ�鲻���ڣ�");
				return SUCCESS;
			}else if(new LendDao().selectByBookISBN(book.getISBN())!=null){
				this.setMessage("��ͼ���Ѿ������,�ʲ���ɾ��ͼ����Ϣ��");
				return SUCCESS;
			}
			bookDao.deleteBook(book.getISBN());
			this.setMessage("ɾ���ɹ���");
			return SUCCESS;
		}

		public String selectBook() throws Exception{
			Book onebook=bookDao.selectBook(book.getISBN());
			if(onebook==null){
				this.setMessage("�����ڸ�ͼ�飡");
				return SUCCESS;
			}
			Map request=(Map) ActionContext.getContext().get("request");
			request.put("onebook", onebook);
			return SUCCESS;
		}

		public String getImage() throws Exception{
			HttpServletResponse response = ServletActionContext.getResponse();
			String ISBN=book.getISBN();
			Book b=bookDao.selectBook(ISBN);
			byte[] photo = b.getPhoto();
			response.setContentType("image/jpeg");
			ServletOutputStream os = response.getOutputStream();
			if ( photo != null && photo.length != 0 )
			{
				for (int i = 0; i < photo.length; i++)
				{
					os.write(photo[i]);
				}
				os.flush();
			}
			return NONE;
		}

		public String updateBook() throws Exception{
			Book b=bookDao.selectBook(book.getISBN());
			if(b==null){
				this.setMessage("Ҫ�޸ĵ�ͼ�鲻����,���Ȳ鿴�Ƿ���ڸ�ͼ�飡");
				return SUCCESS;
			}
			b.setISBN(book.getISBN());
			b.setBookName(book.getBookName());
			b.setAuthor(book.getAuthor());
			b.setPublisher(book.getPublisher());
			b.setPrice(book.getPrice());
			b.setCnum(book.getCnum());
			b.setSnum(book.getSnum());
			b.setSummary(book.getSummary());
			if(this.getPhoto()!=null){
				FileInputStream fis=new FileInputStream(this.getPhoto());
				byte[] buffer=new byte[fis.available()];
				fis.read(buffer);
				b.setPhoto(buffer);
			}
			bookDao.updateBook(b);
			this.setMessage("�޸ĳɹ���");
			return SUCCESS;
		}

}
