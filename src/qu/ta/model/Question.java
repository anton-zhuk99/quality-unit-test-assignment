package qu.ta.model;

import java.util.Objects;

public class Question {

    private int questionTypeId;
    private int categoryId;
    private int subcategoryId;

    /*
        CONSTRUCTORS
     */

    public Question(int questionTypeId, int categoryId, int subcategoryId) {
        this.questionTypeId = questionTypeId;
        this.categoryId = categoryId;
        this.subcategoryId = subcategoryId;
    }

    public Question(int questionTypeId, int categoryId) {
        this.questionTypeId = questionTypeId;
        this.categoryId = categoryId;
        this.subcategoryId = -1;
    }

    public Question(int questionTypeId) {
        this.questionTypeId = questionTypeId;
        this.categoryId = -1;
        this.subcategoryId = -1;
    }

    public Question() {
        this.questionTypeId = -1;
        this.categoryId = -1;
        this.subcategoryId = -1;
    }

    /*
        GETTERS
     */

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getSubcategoryId() {
        return subcategoryId;
    }

    /*
        SETTERS
     */

    public Question setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
        return this;
    }

    public Question setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Question setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
        return this;
    }

    /*
        EQUALS & HASHCODE
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        boolean result =
                (question.questionTypeId < 0) || // x.x.x == *
                (question.questionTypeId == this.questionTypeId
                   && question.categoryId == this.categoryId
                   && question.subcategoryId == this.subcategoryId) || // x.x.x == x.x.x
                (question.questionTypeId == this.questionTypeId
                   && question.categoryId == this.categoryId
                   && question.subcategoryId < 0) || // x.x.x == x.x
                (question.questionTypeId == this.questionTypeId
                   && question.categoryId < 0
                   && question.subcategoryId < 0); // x.x.x == x
        return result;
    }

    @Override
    public int hashCode() {
        int result = 1;

        result *= 31;
        result += questionTypeId;

        result *= 31;
        result += categoryId;

        result *= 31;
        result += subcategoryId;

        return result;
    }
}
