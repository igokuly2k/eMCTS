package gui;

import java.util.EventObject;

public class RegistrationEvent extends EventObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3542646471849246146L;
	private long aadhar_id;
	private String blood_group;
	private int PIN;
		public RegistrationEvent(Object source) {
			super(source);
		}
		public RegistrationEvent(Object source,long aadhar_id,String blood_group,int PIN) {
			super(source);
			this.aadhar_id=aadhar_id;
			this.blood_group=blood_group;
			this.PIN=PIN;
		}
		public long getAadharID() {
			return aadhar_id;
		}
		public String getBloodGroup() {
			return blood_group;
		}
		public int getPIN() {
			return PIN;
		}


}
