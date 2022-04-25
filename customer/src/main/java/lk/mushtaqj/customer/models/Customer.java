package lk.mushtaqj.customer.models;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer
{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_sequence")
  @SequenceGenerator(name = "customer_id_sequence", sequenceName = "customer_id_sequence")
  private Long id;

  private String firstName;
  private String lastName;
  private String email;

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
    Customer customer = (Customer) o;
    return id != null && Objects.equals(id, customer.id);
  }

  @Override
  public int hashCode ()
  {
    return getClass().hashCode();
  }
}
