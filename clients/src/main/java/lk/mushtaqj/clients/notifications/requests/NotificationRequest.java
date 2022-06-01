package lk.mushtaqj.clients.notifications.requests;

public record NotificationRequest(Long toCustomerId, String toCustomerEmail, String message)
{ }
