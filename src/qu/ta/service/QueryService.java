package qu.ta.service;

import qu.ta.model.Query;
import qu.ta.model.Record;

public class QueryService {

    public boolean checkIfSatisfies(Record record, Query query) {
        boolean result =
                   (record.getService().equals(query.getService()))
                && (record.getQuestion().equals(query.getQuestion()))
                && (record.getResponseType() == query.getResponseType())
                && (record.getDate().after(query.getFrom()) && record.getDate().before(query.getTo()));
        return result;
    }

}
