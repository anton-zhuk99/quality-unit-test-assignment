package qu.ta.model;

import java.util.Date;

public class Query {

    private Service service;
    private Question question;
    private ResponseType responseType;
    private Date from;
    private Date to;

    /*
        CONSTRUCTORS
     */

    public Query(Service service, Question question, ResponseType responseType, Date from, Date to) {
        this.service = service;
        this.question = question;
        this.responseType = responseType;
        this.from = from;
        this.to = to;
    }

    /*
        GETTERS
     */

    public Service getService() {
        return service;
    }

    public Question getQuestion() {
        return question;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    /*
        SETTERS
     */

    public Query setService(Service service) {
        this.service = service;
        return this;
    }

    public Query setQuestion(Question question) {
        this.question = question;
        return this;
    }

    public Query setResponseType(ResponseType responseType) {
        this.responseType = responseType;
        return this;
    }

    public Query setFrom(Date from) {
        this.from = from;
        return this;
    }

    public Query setTo(Date to) {
        this.to = to;
        return this;
    }
}
