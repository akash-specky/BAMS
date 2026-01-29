package accounts;

import java.time.LocalDateTime;

public class Transaction {
    private final String description;
    private final double amount;
    private final LocalDateTime timestamp;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return timestamp + " | " + description + " | Amount: " + amount;
    }
}

