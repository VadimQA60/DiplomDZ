package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WebStranitsa;
import data.DataHelper;


public class TestWebSite {

    WebStranitsa webStranitsa = new WebStranitsa();

    @Test

    @DisplayName("Оплата тура со занчком Купить с валидной картой  с статусом APPROVED")
    public void testCashValidCardApproved() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getApprovedCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageSuccessfully();

    }

    @Test
    @DisplayName("Кредит за тур со значком Купить в кредит валидной картой с статусом APPROVED")
    public void testCreditValidCardApproved() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getApprovedCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageSuccessfully();

    }

    @Test
    @DisplayName("Оплата тура со занчком Купить валидной картой с статусом DECLINED")
    public void testCashValidCardDeclined() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getDeclinedCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageError();

    }

    @Test
    @DisplayName("Кредит за тур со значком Купить в кредит валидной картой с статусом DECLINED")
    public void testCashValidCardDeclined2() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getDeclinedCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageError();

    }

    @Test
    @DisplayName("Ввод данных с пустым полем Номер карты во вкладке Купить")
    public void testEmptyFieldNumberCard() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getEmptyNumberCard());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();

    }

    @Test
    @DisplayName("Ввод данных в поле Номер карты менее 16 символов во вкладке Купить")
    public void testCardNumberLessThan16() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumberWithLength());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();

    }

    @Test
    @DisplayName("Ввод данных в поле Номер карты  с несуществующей картой во вкладке Купить")
    public void testCashInvalidCard() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getCardNumberNothing());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageError();
    }

    @Test
    @DisplayName("Ввод данных с пустым данными в поле Месяц во вкладке Купить")
    public void testEmptyMonth() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getEmptyMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();

    }

    @Test
    @DisplayName("Ввод данных в поле Месяц со значением 00 во вкладке Купить")
    public void testInvalidMonth() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getInvalidMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageInvalidDate();

    }

    @Test
    @DisplayName("Ввод данных в поле Месяц со значением больше 12 месяцев во вкладке Купить")
    public void testNonExistentMonth() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getRandomMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageInvalidDate();

    }

    //    @Test
//    @DisplayName("Ввод данных в поле Месяц со значением 1 цифры  во вкладке Купить")
    public void testInvalidNumber() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getOneMonthAgoMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();

    }

    @Test
    @DisplayName("Ввод данных в поле Владелец с пустым значением во вкладке Купить")
    public void testEmptyOwner() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getEmptyOwner());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();

    }

    //    @Test
//    @DisplayName("Ввод данных в поле Владелец на кириллице во вкладке Купить")
    public void testOwnerCyrillic() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomCyrillicName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();

    }

    @Test
    @DisplayName("Ввод данных в поле Владелец в цифровом значении во вкладке Купить")
    public void testNumbersOwner() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerNumber());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();

    }

    @Test
    @DisplayName("Ввод данных в поле Владелец со спецсимволами во вкладке Купить")
    public void testSymbolsOwner() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getSpecialCharactersOwner());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();


    }

    @Test
    @DisplayName("Ввод данных в поле Год с пустым значением во вкладке Купить")
    public void testBlankValueYear() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getEmptyYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();

    }

    //    @Test
    @DisplayName("Ввод данных в поле Год с 1 значением во вкладке Купить") {

    }


    @Test
    @DisplayName("Ввод данных в поле Год с меньшим значением текущего года во вкладке Купить")
    public void testLastYear() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getPreviousYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageCardExpired();

    }

    @Test
    @DisplayName("Ввод данных в поле Год со значением 5+ лет во вкладке Купить")
    public void testYearPlus5() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYearPlus5());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageInvalidDate();

    }

    @Test
    @DisplayName("Ввод данных в поле Год со значением 00 во вкладке Купить")
    public void testYear00() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getInvalidYear(());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageInvalidDate();
    }

    @Test
    @DisplayName("Ввод данных в поле CVC/CVV с пустым значением")
    public void testEmptyCvcCvv() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getEmptyCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();


    }

    @Test
    @DisplayName("Ввод данных в поле CVC/CVV с 1 значением")
    public void test1CVC() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getSingleDigitCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();

    }

    @Test
    @DisplayName("Ввод данных в поле CVC/CVV с 2 значением")
    public void test2CVC() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getDoubleDigitCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();

    }
}






