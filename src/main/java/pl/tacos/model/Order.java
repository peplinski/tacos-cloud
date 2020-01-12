package pl.tacos.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="Taco_Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Date placedAt;

    @ManyToOne
    private User user;

    @NotBlank(message="Podanie imienia i nazwiska jest obowiązkowe")
    private String deliveryName;

    @NotBlank(message="Podanie ulicy jest obowiązkowe")
    private String deliveryStreet;

    @NotBlank(message="Podanie miejscowości jest obowiązkowe")
    private String deliveryCity;

    @NotBlank(message="Podanie województwa jest obowiązkowe")
    private String deliveryState;

    @NotBlank(message="Podanie kodu pocztowego jest obowiązkowe")
    private String deliveryZip;

    //@CreditCardNumber(message="To nie jest prawidłowy numer karty kredytowej")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Wartość musi być w formacie MM/RR")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Nieprawidłowy kod CVV")
    private String ccCVV;

    @ManyToMany(targetEntity=Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }

}