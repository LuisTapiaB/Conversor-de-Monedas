package Modelos;

import java.time.LocalDateTime;

public class ConversionRate {
    private final String result;
    private final String baseCode;
    private final String targetCode;
    private final String baseNombre;
    private final String targetNombre;
    private final Double conversionRate;
    private final Double conversionResult;
    private final Double amount;
    private final LocalDateTime creationTime;

    public ConversionRate(ConversionRateRaw raw) {
        this.result = raw.result();
        this.baseCode = raw.base_code();
        this.targetCode = raw.target_code();
        this.conversionRate = raw.conversion_rate();
        this.conversionResult = raw.conversion_result();
        this.amount = raw.amount();
        this.creationTime = LocalDateTime.now();
        this.baseNombre = Monedas.getMonedasMap().get(this.baseCode);
        this.targetNombre = Monedas.getMonedasMap().get(this.targetCode);
    }

    public String getResult() {
        return result;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public Double getConversionResult() {
        return conversionResult;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    @Override
    public String toString() {
        return  amount +" "+baseNombre+" equivalen a "+conversionResult+" "+targetNombre;
    }
}
