package com.p2p.service;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;

public class LoanService {

    private static final Logger logger = LogManager.getLogger(LoanService.class);

    public Loan createLoan(Borrower borrower, BigDecimal amount) {
        // =========================
        // VALIDASI (delegasi ke domain)
        // =========================
        validateBorrower(borrower);

        // =========================
        // VALIDASI AMOUNT (TC-02)
        // =========================
        // Jika amount <= 0, maka proses harus dihentikan
        validateAmount(amount);

        // =========================
        // CREATE LOAN (domain object)
        // =========================
        logger.info("Creating loan for borrower with credit score {}", borrower.getCreditScore());
        Loan loan = new Loan();

        // =========================
        // BUSINESS ACTION (domain behavior)
        // =========================
        if (borrower.getCreditScore() >= 600) {
            loan.approve();
            logger.info("Loan APPROVED for borrower with credit score {}", borrower.getCreditScore());
        } else {
            loan.reject();
            logger.info("Loan REJECTED for borrower with credit score {}", borrower.getCreditScore());
        }

        return loan;
    }

    // =========================
    // PRIVATE VALIDATION METHOD
    // =========================
    private void validateBorrower(Borrower borrower) {
        if (!borrower.canApplyLoan()) {
            logger.error("Borrower not verified");
            throw new IllegalArgumentException("Borrower not verified");
        }
    }

    private void validateAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            logger.error("Amount must be greater than 0");
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
    }
}