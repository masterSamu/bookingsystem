package data;

import java.security.PrivateKey;
import java.security.PublicKey;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer_Keys {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int key_id;
	
	PublicKey publicKey;
	PrivateKey privateKey;
	
	public Customer_Keys() {
		super();
	}

	public Customer_Keys(int key_id, PublicKey publickey, PrivateKey privatekey) {
		super();
		this.key_id = key_id;
		this.publicKey = publickey;
		this.privateKey = privatekey;
	}

	public int getKey_id() {
		return key_id;
	}

	public void setKey_id(int key_id) {
		this.key_id = key_id;
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(PublicKey publickey) {
		this.publicKey = publickey;
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(PrivateKey privatekey) {
		this.privateKey = privatekey;
	}

}
