package client.domain;

public class Staff {
	
		private String staffid;
		private String fname;
		private String lname;
		private int role;
		private String password;
		
		
		
		public Staff() {
			this.staffid = "";
			this.fname = "";
			this.lname = "";
			this.role = 1;
			this.password = "";
		}

		public Staff(String staffid, String fname, String lname, int role, String password) {
			this.staffid = staffid;
			this.fname = fname;
			this.lname = lname;
			this.role = role;
			this.password = password;
		}

		public String getStaffid() {
			return staffid;
		}

		public void setStaffid(String staffid) {
			this.staffid = staffid;
		}

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}

		public int getRole() {
			return role;
		}

		public void setRole(int role) {
			this.role = role;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "Staff [staffid=" + staffid + ", fname=" + fname + ", lname=" + lname + ", role=" + role + ", password="
					+ password + "]";
		}
		
		

}
