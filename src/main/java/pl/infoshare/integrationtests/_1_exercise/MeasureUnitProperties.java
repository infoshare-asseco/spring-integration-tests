package pl.infoshare.integrationtests._1_exercise;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Map;

@ConstructorBinding
@ConfigurationProperties("measure")
public class MeasureUnitProperties {

    private final String defaultUnit;
    private final Map<String, BigDecimal> unitFactor;

    public MeasureUnitProperties(String defaultUnit, Map<String, BigDecimal> unitFactor) {
        this.defaultUnit = defaultUnit;
        this.unitFactor = unitFactor;
    }

    @PostConstruct
    public void init() {
        if (!unitFactor.containsKey(defaultUnit)) {
            throw new IllegalStateException("Default unit should be set");
        }
    }

    public String getDefaultUnit() {
        return defaultUnit;
    }

    public Map<String, BigDecimal> getUnitFactor() {
        return unitFactor;
    }

    public BigDecimal getUnitFor(String unit) {
        return unitFactor.getOrDefault(unit, unitFactor.get(defaultUnit));
    }
}
