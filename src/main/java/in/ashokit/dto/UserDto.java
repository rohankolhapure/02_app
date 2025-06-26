package in.ashokit.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto {

	@NotEmpty(message = "Name is mandatory")
	private String name;

	@NotEmpty(message = "Email is mandatory")
	@Email(message = "Enter Valid Email ID")
	private String email;

	@NotNull(message = "Phno is mandatory")
	private Long phno;

}
