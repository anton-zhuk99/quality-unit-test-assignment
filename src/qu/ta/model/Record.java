package qu.ta.model;

import java.util.Date;

public class Record {

    private Service service;
    private Question question;
    private ResponseType responseType;
    private Date date;
    private int time;

    /*
        CONSTRUCTORS
     */

    public Record(Service service, Question question, ResponseType responseType, Date date, int time) {
        this.service = service;
        this.question = question;
        this.responseType = responseType;
        this.date = date;
        this.time = time;
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

    public Date getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }

    /*
        SETTERS
     */

    public Record setService(Service service) {
        this.service = service;
        return this;
    }

    public Record setQuestion(Question question) {
        this.question = question;
        return this;
    }

    public Record setResponseType(ResponseType responseType) {
        this.responseType = responseType;
        return this;
    }

    public Record setDate(Date date) {
        this.date = date;
        return this;
    }

    public Record setTime(int time) {
        this.time = time;
        return this;
    }
}
