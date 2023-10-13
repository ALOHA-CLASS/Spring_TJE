package controller;

import java.util.Map;

/**
 * MVC 에서 Model, View 정보를 관리하는 객체
 * @author ALOHA
 *
 */
public class ModelView {
	
	Map<String, Object> model;
	String view;
	boolean redirect = false;
	
	public ModelView() {
		
	}
	public ModelView(Map<String, Object> model, String view) {
		this.model = model;
		this.view = view;
	}
	
	public Map<String, Object> getModel() {
		return model;
	}
	
	public void addModel(Map<String, Object> model) {
		this.model = model;
	}
	
	public String getView() {
		return view;
	}
	
	public void setView(String view) {
		this.view = view;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public boolean isRedirect() {
		return redirect;
	}
	
	
	
	
	
	

}




