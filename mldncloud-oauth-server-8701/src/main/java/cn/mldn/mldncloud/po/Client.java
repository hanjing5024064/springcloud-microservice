package cn.mldn.mldncloud.po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String clientid;
	private String authorizedgranttypes;
	private String clientsecret;
	private String scope;
	// setter、getter略
	public String getClientid() {
		return clientid;
	}
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}
	public String getAuthorizedgranttypes() {
		return authorizedgranttypes;
	}
	public void setAuthorizedgranttypes(String authorizedgranttypes) {
		this.authorizedgranttypes = authorizedgranttypes;
	}
	public String getClientsecret() {
		return clientsecret;
	}
	public void setClientsecret(String clientsecret) {
		this.clientsecret = clientsecret;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	@Override
	public String toString() {
		return "Client [clientid=" + clientid + ", authorizedgranttypes=" + authorizedgranttypes + ", clientsecret="
				+ clientsecret + ", scope=" + scope + "]";
	}
}
