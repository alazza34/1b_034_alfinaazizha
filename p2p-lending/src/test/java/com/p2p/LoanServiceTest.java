package com.p2p;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import com.p2p.service.LoanService;

public class LoanServiceTest {

    @Test   // TC-01
    void shouldRejectLoanWhenBorrowerNotVerified() {
        // =====================================================
        // SCENARIO:
        // Borrower tidak terverifikasi (KYC = false)
        // Ketika borrower mengajukan pinjaman
        // Maka sistem harus menolak dengan melempar exception
        // =====================================================

        // =========================
        // Arrange (Initial Condition)
        // =========================
        // Borrower belum lolos proses KYC
        Borrower borrower = new Borrower(false, 700);

        // Service untuk pengajuan loan
        LoanService loanService = new LoanService();

        // Jumlah pinjaman valid
        BigDecimal amount = BigDecimal.valueOf(1000);

        // =========================
        // Act & Assert
        // =========================
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
    }

    @Test   // TC-02
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {
        // =====================================================
        // SCENARIO:
        // Borrower sudah terverifikasi (KYC = true)
        // Ketika borrower mengajukan pinjaman dengan amount <= 0
        // Maka sistem harus menolak dengan melempar exception
        // =====================================================

        // =========================
        // Arrange (Initial Condition)
        // =========================
        // Borrower sudah lolos proses KYC
        Borrower borrower = new Borrower(true, 700);

        // Service untuk pengajuan loan
        LoanService loanService = new LoanService();

        // Jumlah pinjaman tidak valid (0)
        BigDecimal amount = BigDecimal.valueOf(0);

        // =========================
        // Act & Assert
        // =========================
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
    }

    @Test   // TC-03
    void shouldApproveLoanWhenCreditScoreHigh() {
        // =====================================================
        // SCENARIO:
        // Borrower sudah terverifikasi (KYC = true)
        // Credit score >= 600
        // Ketika borrower mengajukan pinjaman
        // Maka loan harus di-APPROVE
        // =====================================================

        // =========================
        // Arrange (Initial Condition)
        // =========================
        // Borrower sudah lolos proses KYC dengan credit score tinggi
        Borrower borrower = new Borrower(true, 700);

        // Service untuk pengajuan loan
        LoanService loanService = new LoanService();

        // Jumlah pinjaman valid
        BigDecimal amount = BigDecimal.valueOf(1000);

        // =========================
        // Act (Action)
        // =========================
        Loan loan = loanService.createLoan(borrower, amount);

        // =========================
        // Assert (Expected Result)
        // =========================
        assertEquals(Loan.Status.APPROVED, loan.getStatus());
    }

    @Test   // TC-04
    void shouldRejectLoanWhenCreditScoreLow() {
        // =====================================================
        // SCENARIO:
        // Borrower sudah terverifikasi (KYC = true)
        // Credit score < 600
        // Ketika borrower mengajukan pinjaman
        // Maka loan harus di-REJECT
        // =====================================================

        // =========================
        // Arrange (Initial Condition)
        // =========================
        // Borrower sudah lolos proses KYC dengan credit score rendah
        Borrower borrower = new Borrower(true, 400);

        // Service untuk pengajuan loan
        LoanService loanService = new LoanService();

        // Jumlah pinjaman valid
        BigDecimal amount = BigDecimal.valueOf(1000);

        // =========================
        // Act (Action)
        // =========================
        Loan loan = loanService.createLoan(borrower, amount);

        // =========================
        // Assert (Expected Result)
        // =========================
        assertEquals(Loan.Status.REJECTED, loan.getStatus());
    }
}