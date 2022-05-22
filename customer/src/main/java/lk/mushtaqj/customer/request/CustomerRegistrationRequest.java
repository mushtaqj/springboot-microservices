package lk.mushtaqj.customer.request;

import java.util.StringJoiner;

public record CustomerRegistrationRequest(String firstName, String lastName, String email)
{
  @Override
  public String toString ()
  {
    return new StringJoiner(", ", CustomerRegistrationRequest.class.getSimpleName() + "[", "]").add(
      "firstName='" + firstName + "'").add("lastName='" + lastName + "'").add("email='" + email + "'").toString();
  }
}
