package gui;

import java.util.EventObject;

public class LoginEvent extends EventObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6478117731409562820L;
	private int customer_id;
	private int PIN;
		public LoginEvent(Object source) {
			super(source);
		}
		public LoginEvent(Object source,int customer_id,int PIN) {
			super(source);
			this.customer_id=customer_id;
			this.PIN=PIN;
		}
		public int getCustomerID() {
			return customer_id;
		}
		public void setCustomerID(int customer_id) {
			this.customer_id = customer_id;
		}
		public int getPIN() {
			return PIN;
		}
		public void setPIN(int PIN) {
			this.PIN = PIN;
		}
}
