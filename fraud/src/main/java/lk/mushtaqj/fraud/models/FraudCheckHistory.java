package lk.mushtaqj.fraud.models;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FraudCheckHistory
{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_id_sequence")
  @SequenceGenerator(name = "fraud_id_sequence", sequenceName = "fraud_id_sequence", allocationSize = 1)
  @Column(name = "id", nullable = false)
  private Long id;

  private Long customerId;
  private Boolean isFraudster;
  private LocalDateTime createdAt;


  @Override
  public boolean equals (Object o)
  {
    if (this == o)
    {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
    {
      return false;
    }
    FraudCheckHistory that = (FraudCheckHistory) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode ()
  {
    return getClass().hashCode();
  }
}
