package net.datafaker.providers.base;

import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;

class FinanceTest extends BaseFakerTest<BaseFaker> {

    private Finance finance = faker.finance();

    @RepeatedTest(100)
    void creditCard() {
        final String creditCard = finance.creditCard();
        assertCardLuhnDigit(creditCard);
    }

    private void assertCardLuhnDigit(String creditCard) {
        final String creditCardStripped = creditCard.replaceAll("-", "");
        assertThat(LuhnCheckDigit.LUHN_CHECK_DIGIT.isValid(creditCardStripped)).isTrue();
    }

    @RepeatedTest(10)
    void nasdaqTicker() {
        assertThat(finance.nasdaqTicker()).matches("[A-Z.-]+");
    }

    @RepeatedTest(10)
    void nyseTicker() {
        assertThat(finance.nyseTicker()).matches("[A-Z.-]+");
    }

    @Override
    protected Collection<TestSpec> providerListTest() {
        return Arrays.asList(TestSpec.of(finance::stockMarket, "finance.stock_market"));
    }

    @Test
    void bic() {
        assertThat(finance.bic()).matches("([A-Z]){4}([A-Z]){2}([0-9A-Z]){2}([0-9A-Z]{3})?");
    }

    @RepeatedTest(100)
    void iban() {
        assertThat(finance.iban()).matches("[A-Z]{2}\\p{Alnum}{13,30}");
    }

    @Test
    void ibanWithCountryCode() {
        assertThat(finance.iban("DE")).matches("DE\\d{20}");
    }

    @Test
    void creditCardWithType() {
        for (CreditCardType type : CreditCardType.values()) {
            final String creditCard = finance.creditCard(type);
            assertCardLuhnDigit(creditCard);
        }
    }

    @Test
    void costaRicaIbanMustBeValid() {
        final String givenCountryCode = "CR";
        final BaseFaker faker = new BaseFaker();
        final String ibanFaker = finance.iban(givenCountryCode).toUpperCase(faker.getContext().getLocale());
        assertThat(fr.marcwrobel.jbanking.iban.Iban.isValid(ibanFaker)).isTrue();
    }

    @RepeatedTest(100)
    void visaCard() {
        String creditCard = finance.creditCard(CreditCardType.VISA).replace("-", "");
        assertThat(creditCard).startsWith("4").hasSize(16);
    }

    @RepeatedTest(100)
    void discoverCard() {
        String creditCard = finance.creditCard(CreditCardType.DISCOVER).replace("-", "");
        assertThat(creditCard).startsWith("6").hasSize(16);
    }
}