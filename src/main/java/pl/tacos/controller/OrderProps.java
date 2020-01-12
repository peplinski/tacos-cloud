package pl.tacos.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Component
@ConfigurationProperties(prefix="taco.orders")
@Data
@Validated
public class OrderProps {


    @Min(value=5, message="Wartość musi mieścić się w przedziale od 5 do 25")
    @Max(value=25, message="Wartość musi mieścić się w przedziale od 5 do 25")
    private int pageSize = 20;

}
