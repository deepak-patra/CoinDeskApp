package com.test.test_app.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * The Class BaseError.
 */
@AllArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseError implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3387516993124453948L;

    /** The field. */
    private final String field;

    /** The message. */
    private final String message;

    /** The messages. */
    private final List<String> messages;

    /**
     * Instantiates a new base error.
     *
     * @param fieldParam   the field
     * @param messageParam the message
     */
    public BaseError(final String fieldParam, final String messageParam) {
        field = fieldParam;
        message = messageParam;
        messages = new ArrayList<>();
    }
}
