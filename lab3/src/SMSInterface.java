import java.time.LocalDateTime;

//Interfaces are designed to define common behaviours,enums to define common values.
// Enum represents a real value which can be compared to another value,
// or stored in the database easily.

public interface SMSInterface {
    public boolean insertSms();
    public String retrieveSmsByDate(LocalDateTime startDate, LocalDateTime endDate);
    public String retrieveSmsByPromoCode(String promo_code);
    public String retrieveSmsByMsisdn(String msisdn);
    public String retrieveSmsByShortCode(String short_code);
    public String retrieveSmsBySent();
    public String retrieveSmsByManyMsisdn(String [] msisdn);
}
