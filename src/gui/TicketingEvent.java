package gui;

import java.util.EventObject;

public class TicketingEvent extends EventObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8434460364308077808L;
	private String fromplace;
	private String toplace;
		public TicketingEvent(Object source) {
			super(source);
		}
		public TicketingEvent(Object source,String fromplace,String toplace) {
			super(source);
			this.fromplace=fromplace;
			this.toplace=toplace;
		}
		public String getFromPlace() {
			return fromplace;
		}
		public void setCustomerID(String fromplace) {
			this.fromplace = fromplace;
		}
		public String getToPlace() {
			return toplace;
		}
		public void setPIN(String toplace) {
			this.toplace = toplace;
		}

}
