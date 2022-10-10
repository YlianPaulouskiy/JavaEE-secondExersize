package edu.step.entity.tariff;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class TariffConverter implements AttributeConverter<Tariff, String> {

    @Override
    public String convertToDatabaseColumn(Tariff attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getTitle();
    }

    @Override
    public Tariff convertToEntityAttribute(String source) {
        if (source == null) {
            return null;
        }
        return Stream.of(Tariff.values())
                .filter(tariff -> tariff.getTitle().equals(source))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
