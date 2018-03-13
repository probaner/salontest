package SpringMy.Maven.db.enities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pay_status", catalog = "salontest")
public class PayStatus implements java.io.Serializable {
	
	private int payId;	
	private Users users;
	private int attemptSection;
	private int totalEntry;
	private String couponCodeNumber;
	private int totalAmount;
	private int discountAmount;
	private String courencyType;
	private int recivedAmont;
	private String recivedCourencyType;	
	private Date entryCreatedTime;
	private String payingStatus;
	private Date payTime;
	private Date lastUpdateTime;
	
	public PayStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PayStatus(int payId, Users users, int attemptSection, int totalEntry, String couponCodeNumber,
			int totalAmount, String courencyType, int recivedAmont, String recivedCourencyType, int discountAmount,
			Date entryCreatedTime, String payingStatus, Date payTime, Date lastUpdateTime) {
		super();
		this.payId = payId;
		this.users = users;
		this.attemptSection = attemptSection;
		this.totalEntry = totalEntry;
		this.couponCodeNumber = couponCodeNumber;
		this.totalAmount = totalAmount;
		this.courencyType = courencyType;
		this.recivedAmont = recivedAmont;
		this.recivedCourencyType = recivedCourencyType;
		this.discountAmount = discountAmount;
		this.entryCreatedTime = entryCreatedTime;
		this.payingStatus = payingStatus;
		this.payTime = payTime;
		this.lastUpdateTime = lastUpdateTime;
	}

	@Id
	@Column(name = "pay_id", unique = true, nullable = false)
	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
    
	@Column(name = "attempt_section", unique = false, nullable = false)
	public int getAttemptSection() {
		return attemptSection;
	}

	public void setAttemptSection(int attemptSection) {
		this.attemptSection = attemptSection;
	}

	@Column(name = "total_entry", unique = false, nullable = false)
	public int getTotalEntry() {
		return totalEntry;
	}

	public void setTotalEntry(int totalEntry) {
		this.totalEntry = totalEntry;
	}
    
	@Column(name = "coupon_code_number", nullable = true, length = 45)
	public String getCouponCodeNumber() {
		return couponCodeNumber;
	}

	public void setCouponCodeNumber(String couponCodeNumber) {
		this.couponCodeNumber = couponCodeNumber;
	}
    
	@Column(name = "total_amount", unique = false, nullable = false)
	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
    
	@Column(name = "discount_amount", unique = false, nullable = false)
	public int getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}
	
	@Column(name = "courency_type", nullable = false, length = 45)
	public String getCourencyType() {
		return courencyType;
	}

	public void setCourencyType(String courencyType) {
		this.courencyType = courencyType;
	}

	@Column(name = "recived_amont", unique = true, nullable = false)
	public int getRecivedAmont() {
		return recivedAmont;
	}

	public void setRecivedAmont(int recivedAmont) {
		this.recivedAmont = recivedAmont;
	}
    
	@Column(name = "recived_courency_type", nullable = true, length = 45)
	public String getRecivedCourencyType() {
		return recivedCourencyType;
	}

	public void setRecivedCourencyType(String recivedCourencyType) {
		this.recivedCourencyType = recivedCourencyType;
	}

	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "entry_created_time", nullable = false, length = 19)
	public Date getEntryCreatedTime() {
		return entryCreatedTime;
	}

	public void setEntryCreatedTime(Date entryCreatedTime) {
		this.entryCreatedTime = entryCreatedTime;
	}

	@Column(name = "paying_status", nullable = false, length = 45)
	public String getPayingStatus() {
		return payingStatus;
	}

	public void setPayingStatus(String payingStatus) {
		this.payingStatus = payingStatus;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pay_time", nullable = true, length = 19)
	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update_time", nullable = false, length = 19)
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Override
	public String toString() {
		return "PayStatus [payId=" + payId + ", users=" + users + ", attemptSection=" + attemptSection + ", totalEntry="
				+ totalEntry + ", couponCodeNumber=" + couponCodeNumber + ", totalAmount=" + totalAmount
				+ ", courencyType=" + courencyType + ", recivedAmont=" + recivedAmont + ", recivedCourencyType="
				+ recivedCourencyType + ", discountAmount=" + discountAmount + ", entryCreatedTime=" + entryCreatedTime
				+ ", payingStatus=" + payingStatus + ", payTime=" + payTime + ", lastUpdateTime=" + lastUpdateTime
				+ "]";
	}
	
	
		

}
