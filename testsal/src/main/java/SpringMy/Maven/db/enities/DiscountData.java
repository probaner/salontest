package SpringMy.Maven.db.enities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "discount_data", catalog = "salontest")

public class DiscountData {
	
	private Integer discountId;
	private Integer createdBY;
	private Integer usrID;
	private Integer discountPersent;
	private String couponCode;
	
	

	public DiscountData() {
		super();
		// TODO Auto-generated constructor stub
	}



	public DiscountData(Integer discountId, Integer createdBY, Integer usrID, Integer discountPersent,
			String couponCode) {
		super();
		this.discountId = discountId;
		this.createdBY = createdBY;
		this.usrID = usrID;
		this.discountPersent = discountPersent;
		this.couponCode = couponCode;
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "discount_id", unique = true, nullable = false)
	public Integer getDiscountId() {
		return discountId;
	}



	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
	}


	@Column(name = "created_by", unique = false, nullable = false)
	public Integer getCreatedBY() {
		return createdBY;
	}



	public void setCreatedBY(Integer createdBY) {
		this.createdBY = createdBY;
	}


	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUsrID() {
		return usrID;
	}



	public void setUsrID(Integer usrID) {
		this.usrID = usrID;
	}


	@Column(name = "discount_persent", unique = false, nullable = false)
	public Integer getDiscountPersent() {
		return discountPersent;
	}



	public void setDiscountPersent(Integer discountPersent) {
		this.discountPersent = discountPersent;
	}


	@Column(name = "coupon_code", nullable = false, length = 45)
	public String getCouponCode() {
		return couponCode;
	}



	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	
		

}
