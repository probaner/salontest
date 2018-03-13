package SpringMy.Maven.model;

public class PaymentDTO {
	
	String couponCode;
	
	public PaymentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public PaymentDTO(String couponCode) {
		super();
		this.couponCode = couponCode;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	@Override
	public String toString() {
		return "PaymentDTO [couponCode=" + couponCode + "]";
	}
	
}
