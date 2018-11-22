package ru.academits.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContactValidation {
    private boolean valid;
    private String error;

    private static final Logger logger = LoggerFactory.getLogger(ContactValidation.class);

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        logger.error(error);
        this.error = error;
    }
}
