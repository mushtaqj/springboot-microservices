package lk.mushtaqj.clients;

public interface UrlPaths
{
  interface Notifications
  {
    String basePath = "api/v1/notifications";
  }

  interface FraudCheck {
    String basePath = "api/v1/fraud-check";
  }
}
