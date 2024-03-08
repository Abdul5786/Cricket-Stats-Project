package com.Abdulkhaliq.CricketStatsProject.exceptions;

public class ResponseMessageException extends RuntimeException
{
    public ResponseMessageException()
    {
    }

    public ResponseMessageException(String message)
    {
        super(message);
    }
}
