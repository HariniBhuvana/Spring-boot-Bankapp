package com.capgemini.purebankapp.entities;
import java.time.LocalDate;
import java.util.Objects;

public class Customer {

		private long customerId;
		private String customerName;
		private String password;
		private String email;
		private String address;
		private LocalDate dateOfBirth;
		private BankAccount account;

		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Customer(String customerName, long customerId, String email, String address, String password,
				LocalDate dateOfBirth, BankAccount account) {
			super();
			this.customerName = customerName;
			this.customerId = customerId;
			this.email = email;
			this.address = address;
			this.password = password;
			this.dateOfBirth = dateOfBirth;
			this.account = account;
		}
		
		
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public long getCustomerId() {
			return customerId;
		}
		public void setCustomerId(long customerId) {
			this.customerId = customerId;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public BankAccount getAccount() {
			return account;
		}
		public void setAccount(BankAccount account) {
			this.account = account;
		}
		@Override
		public String toString() {
			return "Customer [customerName=" + customerName + ", customerId=" + customerId + ", email=" + email
					+ ", address=" + address + ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", account="
					+ account + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(customerId, email);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Customer other = (Customer) obj;
			if (customerId != other.customerId)
				return false;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			return true;
		}


	}


