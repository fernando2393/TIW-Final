package es.uc3m.tiw.messages.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


/**
 * The persistent class for the messages_admin database table.
 * 
 */
@Entity
@Table(name="messages_admin")
@NamedQuery(name="MessagesAdmin.findAll", query="SELECT m FROM MessagesAdmin m")
public class MessagesAdmin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MESSAGE_ID")
	private int messageId;

	@Lob
	@Column(name="MESSAGE_CONTENT")
	private String messageContent;

    @JsonInclude(value= JsonInclude.Include.NON_EMPTY)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy", timezone="PST")
    @JsonProperty("date")
	@Temporal(TemporalType.DATE)
	@Column(name="MESSAGE_DATE")
	private Date messageDate;

	@Column(name="MESSAGE_FROM_ADMIN")
	private byte messageFromAdmin;

	@Column(name="MESSAGE_READ")
	private byte messageRead;

	//bi-directional many-to-one association to Admin
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="MESSAGE_ADMIN_ID")
	@JsonBackReference(value="admin")
	private Admin admin;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="MESSAGE_USER_ID")
	@JsonBackReference(value="user")
	private User user;

	public MessagesAdmin() {
	}

	public int getMessageId() {
		return this.messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessageContent() {
		return this.messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public Date getMessageDate() {
		return this.messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	public byte getMessageFromAdmin() {
		return this.messageFromAdmin;
	}

	public void setMessageFromAdmin(byte messageFromAdmin) {
		this.messageFromAdmin = messageFromAdmin;
	}

	public byte getMessageRead() {
		return this.messageRead;
	}

	public void setMessageRead(byte messageRead) {
		this.messageRead = messageRead;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}