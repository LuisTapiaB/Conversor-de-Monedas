package Modelos;

public record ConversionRateRaw(String result,
                                String base_code,
                                String target_code,
                                Double conversion_rate,
                                Double conversion_result,
                                Double amount
                             ) {

}
