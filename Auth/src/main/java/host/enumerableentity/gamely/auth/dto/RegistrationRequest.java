package host.enumerableentity.gamely.auth.dto;

public record RegistrationRequest(String username,
                                  String password,
                                  String email,
                                  String firstName,
                                  String lastName) {
}
