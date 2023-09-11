package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WebStranitsa;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWebSite {

    WebStranitsa webStranitsa = new WebStranitsa();

    @Test

    @DisplayName("Оплата тура со занчком Купить с валидной картой  с статусом APPROVED")
    void testCashValidCardApproved() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getCardNumberApproved());
        webStranitsa.setCardMonth(DataHelper.getMonth());
        webStranitsa.setCardYear(DataHelper.getYear());
        webStranitsa.setCardOwner(DataHelper.getOwner());
        webStranitsa.setCardCVV(DataHelper.getCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageSuccessfully();
        assertEquals("APPROVED");
    }

    @Test
    @DisplayName("Кредит за тур со значком Купить в кредит валидной картой с статусом APPROVED")
    void testCreditValidCardApproved() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getCardNumberApproved());
        webStranitsa.setCardMonth(DataHelper.getMonth());
        webStranitsa.setCardYear(DataHelper.getYear());
        webStranitsa.setCardOwner(DataHelper.getOwner());
        webStranitsa.setCardCVV(DataHelper.getCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageSuccessfully();
        assertEquals("APPROVED");
    }

    @Test
    @DisplayName("Оплата тура со занчком Купить валидной картой с статусом DECLINED")
    void testCashValidCardDeclined() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getCardNumberDeclined());
        webStranitsa.setCardMonth(DataHelper.getMonth());
        webStranitsa.setCardYear(DataHelper.getYear());
        webStranitsa.setCardOwner(DataHelper.getOwner());
        webStranitsa.setCardCVV(DataHelper.getCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageError();
        assertEquals("DECLINED");
    }

    @Test
    @DisplayName("Кредит за тур со значком Купить в кредит валидной картой с статусом DECLINED")
    void testCashValidCardDeclined() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getCardNumberDeclined());
        webStranitsa.setCardMonth(DataHelper.getMonth());
        webStranitsa.setCardYear(DataHelper.getYear());
        webStranitsa.setCardOwner(DataHelper.getOwner());
        webStranitsa.setCardCVV(DataHelper.getCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageError();
        assertEquals("DECLINED");
    }


}
