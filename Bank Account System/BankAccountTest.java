

// File: BankAccountTest.java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setup() {
        account = new BankAccount("123456", "Cindrella", 1000.0);
    }

    @Test
    public void testDeposit() {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    public void testDepositNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100);
        });
        assertEquals("Deposit amount must be positive.", exception.getMessage());
    }

    @Test
    public void testWithdraw() {
        account.withdraw(400);
        assertEquals(600, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(2000);
        });
        assertEquals("Insufficient balance.", exception.getMessage());
    }

    @Test
    public void testWithdrawNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-100);
        });
        assertEquals("Withdrawal amount must be positive.", exception.getMessage());
    }

    @Test
    public void testTransactionHistory() {
        account.deposit(200);
        account.withdraw(100);
        assertEquals(3, account.getTransactionHistory().size()); // Account creation + 2 transactions
    }

    @Test
    public void testGetBalance() {
        assertEquals(1000, account.getBalance());
    }
}

