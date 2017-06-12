package br.com.ncisaude.gr.infra.jsend;

import java.util.HashMap;
import java.util.Map;

public class JSENDResponse {

	private JSENDStatus status;

	protected Map<String, Object> data = new HashMap<>();

	public JSENDResponse(JSENDStatus status) {
		super();
		this.status = status;
	}

	public JSENDResponse addObject(String name, Object object) {
		data.put(name, object);
		return this;
	}

	public JSENDStatus getStatus() {
		return status;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
