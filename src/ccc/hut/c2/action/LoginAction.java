package ccc.hut.c2.action;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import ccc.hut.c2.dao.LoginDao;
import ccc.hut.c2.model.Login;

public class LoginAction extends ActionSupport{
	private Login login;
	private String message;
	
	public String execute() throws Exception{
		LoginDao loginDao=new LoginDao();
		Login log=loginDao.checkLogin(login.getName(), login.getPassword());
		if(log!=null){
			Map session=ActionContext.getContext().getSession();
			session.put("login", 1);
			
			if(log.getRole()){
				return "admin";
			}else{
				return "student";
			}
		}else{
			return this.ERROR;
		}
	}
	
	public void validate(){
		if(login.getName()==null||login.getName().equals("")){
			this.addFieldError("name","用户名不能为空！");
			
		}else{
			if(login.getPassword()==null||login.getPassword().equals("")){
				this.addFieldError("password","密码不能为空！");
			}
		}
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
