package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {//пополнение в интервале мин макс
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldNotAddMoreThanMaxBalance() {//пополнение в интервале больше макс
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(9000);

        Assertions.assertEquals(2000, account.getBalance());

    }

    @Test
    public void shouldThrowExceptionMinBalanceAboveMaxBalance() {//минимальный баланс не может быть больше максимального
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.getRate();
        });

    }

    @Test
    public void shouldThrowExceptionNegativeMinBalance() {//минимальный баланс не может быть отрицательным
        SavingAccount account = new SavingAccount(
                2_000,
                -1_000,
                10_000,
                5
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.getRate();
        });
    }

    @Test
    public void shouldAddTrueOnBorderMinBalancePay() {// нижняя граница при оплате
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(1000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldNotPayIfBalanceNegative() {//оплата не должна проходить, если баланс становится отрицательным

        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );


        account.pay(2_001);

        Assertions.assertEquals(2_000, account.getBalance());

    }

    @Test
    public void shouldAddPercent() {//добавление процента
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                15
        );


        Assertions.assertEquals(300, account.yearChange());
    }


}