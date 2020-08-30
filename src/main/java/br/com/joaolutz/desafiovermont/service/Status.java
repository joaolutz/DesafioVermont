package br.com.joaolutz.desafiovermont.service;

import java.io.Serializable;

public class Status<T> implements Serializable {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int code;
	private String message;
	private T data;
	
	public Status() {}
	
	//Construtor de retorno (Response) de sucesso
	public Status(String message) {
		this.code = 0;
		this.message = message;
	}
	
	//Construtor de retorno (Response) para outros cenários
	public Status(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	

}
