package gui;

import java.util.EventObject;

public class TicketingEvent extends EventObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8434460364308077808L;
	private String toplace;
		public TicketingEvent(Object source) {
			super(source);
		}
		public TicketingEvent(Object source,String toplace) {
			super(source);
			this.toplace=toplace;
		}
		public String getToPlace() {
			return toplace;
		}
}
