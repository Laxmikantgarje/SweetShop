package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    private String password;

public RegisterRequest(String username, String password) {
    this.username = username;
    this.password = password;
}
public RegisterRequest() {
}

public String getUsername() {
    return username;
}

public String getPassword() {
    return password;
}
}
