package com.test.test_app.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.test.test_app.exception.BaseError;

import lombok.Data;


/**
 * The Class Response.
 *
 * @param <T> the generic type
 */
@SuppressWarnings({
    "PMD.UnusedPrivateField", "PMD.SingularField"})
@Data
public class Response<T> {

    /** The Constant SUCCESS. */
    public static final String SUCCESS = "success";

    /** The Constant FAILURE. */
    public static final String FAILURE = "failure";

    /** The Constant ACCEPTED. */
    public static final String ACCEPTED = "accepted";

    /** The event. */
    private final String event;

    /** The message. */
    private final String message;

    /** The result. */
    // in case of success
    private final T result;

    /** The code. */
    // in case of exception
    private final Integer code;

    /** The errors. */
    private List<BaseError> errors;


    /**
     * Instantiates a new response.
     *
     * @param eventParam the event
     * @param codeParam  the code
     */
    public Response(final String eventParam, final Integer codeParam) {
        this(eventParam, null, null, codeParam, null);
    }

    /**
     * Instantiates a new response.
     *
     * @param eventParam   the event
     * @param codeParam    the code
     * @param messageParam the message
     */
    public Response(final String eventParam, final Integer codeParam, final String messageParam) {
        this(eventParam, messageParam, null, codeParam, null);
    }

    /**
     * Instantiates a new response.
     *
     * @param eventParam   the event
     * @param codeParam    the code
     * @param messageParam the message
     * @param errorsParam  the errors
     */
    public Response(final String eventParam, final Integer codeParam, final String messageParam,
            final List<BaseError> errorsParam) {
        this(eventParam, messageParam, null, codeParam, errorsParam);
    }

    /**
     * Instantiates a new response.
     *
     * @param eventParam   the event
     * @param messageParam the message
     * @param resultParam  the result
     * @param codeParam    the code
     * @param errorsParam  the errors
     */
    private Response(final String eventParam, final String messageParam, final T resultParam,
            final Integer codeParam,
            final List<BaseError> errorsParam) {
        this.event = eventParam;
        this.message = messageParam;
        this.result = resultParam;
        this.code = codeParam;
        this.errors = errorsParam;
    }

    /**
     * Instantiates a new response.
     *
     * @param eventParam  the event
     * @param resultParam the result
     */
    public Response(final String eventParam, final T resultParam) {
        this(eventParam, null, resultParam, null, null);
    }

    /**
     * Adds the field errors.
     *
     * @param baseError the base error
     */
    public final void addFieldErrors(final BaseError baseError) {
        if (null == errors) {
            errors = new ArrayList<>();
        }
        errors.add(baseError);
    }
}
