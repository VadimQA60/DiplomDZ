package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelperDB;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import pages.WebStranitsa;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWebSite {

    WebStranitsa webStranitsa = new WebStranitsa();

    @BeforeEach
    void clearDatabaseTables() {
        open("http://localhost:8080/");
        DataHelperDB.clearTables();
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


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
        assertEquals("APPROVED", DataHelperDB.findPayStatus());

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
        assertEquals("APPROVED", DataHelperDB.findCreditStatus());
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
        assertEquals("DECLINED", DataHelperDB.findPayStatus());
    }


    @Test
    @DisplayName("Кредит за тур со значком Купить в кредит валидной картой с статусом DECLINED")
    public void testCreditCashValidCardDeclined() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getDeclinedCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageError();
        assertEquals("DECLINED", DataHelperDB.findCreditStatus());
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
        assertEquals(0, DataHelperDB.getOrderEntityCount());
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
        assertEquals(0, DataHelperDB.getOrderEntityCount());
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
        assertEquals(0, DataHelperDB.getOrderEntityCount());
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

    @Test
    @DisplayName("Ввод данных в поле Месяц со значением 1 цифры  во вкладке Купить")
    public void testInvalidNumber() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getMonthWithOneValue());
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
        webStranitsa.messageRequiredField();

    }

    @Test
    @DisplayName("Ввод данных в поле Владелец на кириллице во вкладке Купить")
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

    @Test
    @DisplayName("Ввод данных в поле Год с 1 значением во вкладке Купить")
    public void testYearWithOneValue() {
        webStranitsa.purcHaseCash();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getYearWithOneValue());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();
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
    @DisplayName("Ввод данных в поле Год со значением 6+ лет во вкладке Купить")
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
        webStranitsa.setCardYear(DataHelper.getInvalidYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageCardExpired();
    }

    @Test
    @DisplayName("Ввод данных в поле CVC/CVV с пустым значением во вкладке Купить")
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
    @DisplayName("Ввод данных в поле CVC/CVV с 1 значением во вкладке Купить")
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
    @DisplayName("Ввод данных в поле CVC/CVV с 2 значением во вкладке Купить")
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

    @Test
    @DisplayName("Ввод данных с пустым полем Номер карты во вкладке Купить в кредит")
    public void testCreditEmptyFieldNumberCard() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getEmptyNumberCard());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();

    }

    @Test
    @DisplayName("Ввод данных в поле Номер карты менее 16 символов во вкладке Купить в кредит")
    public void testCreditCardNumberLessThan16() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumberWithLength());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();

    }

    @Test
    @DisplayName("Ввод данных в поле Номер карты  с несуществующей картой во вкладке Купить в кредит")
    public void testCreditCashInvalidCard() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getCardNumberNothing());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageError();
    }

    @Test
    @DisplayName("Ввод данных с пустым данными в поле Месяц во вкладке Купить в кредит")
    public void testCreditEmptyMonth() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getEmptyMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();

    }

    @Test
    @DisplayName("Ввод данных в поле Месяц со значением 00 во вкладке Купить в кредит")
    public void tesCredittInvalidMonth() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getInvalidMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageInvalidDate();

    }

    @Test
    @DisplayName("Ввод данных в поле Месяц со значением больше 12 месяцев во вкладке Купить в кредит")
    public void testCreditNonExistentMonth() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getRandomMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageInvalidDate();

    }

    @Test
    @DisplayName("Ввод данных в поле Месяц со значением 1 цифры  во вкладке Купить в кредит")
    public void testCreditInvalidNumber() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getMonthWithOneValue());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();

    }

    @Test
    @DisplayName("Ввод данных в поле Владелец с пустым значением во вкладке Купить в кредит")
    public void testCreditEmptyOwner() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getEmptyOwner());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageRequiredField();

    }

    @Test
    @DisplayName("Ввод данных в поле Владелец на кириллице во вкладке Купить в кредит")
    public void testCreditOwnerCyrillic() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomCyrillicName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();

    }

    @Test
    @DisplayName("Ввод данных в поле Владелец в цифровом значении во вкладке Купить в кредит")
    public void testCreditNumbersOwner() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerNumber());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();

    }

    @Test
    @DisplayName("Ввод данных в поле Владелец со спецсимволами во вкладке Купить в кредит")
    public void testCreditSymbolsOwner() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getSpecialCharactersOwner());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();


    }

    @Test
    @DisplayName("Ввод данных в поле Год с пустым значением во вкладке Купить в кредит")
    public void testCreditBlankValueYear() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getEmptyYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Ввод данных в поле Год с 1 значением во вкладке Купить в кредит")
    public void testCreditYearWithOneValue() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getYearWithOneValue());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Ввод данных в поле Год с меньшим значением текущего года во вкладке Купить в кредит")
    public void testCreditLastYear() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getPreviousYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageCardExpired();

    }

    @Test
    @DisplayName("Ввод данных в поле Год со значением 5+ лет во вкладке Купить в кредит")
    public void testCreditYearPlus5() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYearPlus5());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageInvalidDate();

    }

    @Test
    @DisplayName("Ввод данных в поле Год со значением 00 во вкладке Купить в кредит")
    public void testCreditYear00() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getInvalidYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getRandomCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageCardExpired();
    }


    @Test
    @DisplayName("Ввод данных в поле CVC/CVV с пустым значением во вкладке Купить в кредит")
    public void testCreditEmptyCvcCvv() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getEmptyCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();


    }

    @Test
    @DisplayName("Ввод данных в поле CVC/CVV с 1 значением во вкладке Купить в кредит")
    public void testCredit1CVC() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getSingleDigitCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();

    }

    @Test
    @DisplayName("Ввод данных в поле CVC/CVV с 2 значением во вкладке Купить в кредит")
    public void testCredit2CVC() {
        webStranitsa.buyInCredit();
        webStranitsa.setCardNumber(DataHelper.getRandomCardNumber());
        webStranitsa.setCardMonth(DataHelper.getNextMonth());
        webStranitsa.setCardYear(DataHelper.getCurrentYear());
        webStranitsa.setCardOwner(DataHelper.getRandomOwnerName());
        webStranitsa.setCardCVV(DataHelper.getDoubleDigitCvc());
        webStranitsa.clickContinueButton();
        webStranitsa.messageIncorrectFormat();

    }
}


