package com.apdca.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import com.apdca.config.Exceptionhandler.ValidPassword;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OnlineUsersDto {

	private Long user_id;
	private String firm_no;
	@NotEmpty
	private String user_nm;
	@NotEmpty(message = "Email should not be empty")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Please Provide valid email")
	private String reqloginnm;
	@NotEmpty
	@ValidPassword
	private String user_pwd;
	private Long req_id;
	private String email_id;
	@NotEmpty
	@Pattern(regexp = "^\\d{10}$", message = "Mobile Number Must be of 10 digit Number")
	private String mobile_no;
	@NotEmpty
	private String address;
	@NotEmpty
	private String area;
	@NotEmpty
	@Pattern(regexp = "^\\d{6}$", message = "Pincode Must be of 6 digit Number")
	private String pincode;
	private String ip_no;
	private LocalDateTime reset_pwd_date;
	private String firm_nm;
	private int role_id;
	private Date dob;
	private String captcha;

}
