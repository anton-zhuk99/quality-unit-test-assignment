package qu.ta.model;

import java.util.Objects;

public class Service {

    private int serviceId;
    private int variationId;

    /*
        CONSTRUCTORS
     */

    public Service(int serviceId, int variationId) {
        this.serviceId = serviceId;
        this.variationId = variationId;
    }

    public Service(int serviceId) {
        this.serviceId = serviceId;
        this.variationId = -1;
    }

    public Service() {
        this.serviceId = -1;
        this.variationId = -1;
    }

    /*
        GETTERS
     */

    public int getServiceId() {
        return serviceId;
    }

    public int getVariationId() {
        return variationId;
    }

    /*
        SETTERS
     */

    public Service setServiceId(int serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public Service setVariationId(int variationId) {
        this.variationId = variationId;
        return this;
    }

    /*
        EQUALS & HASHCODE
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Service)) return false;
        Service service = (Service) o;
        boolean result =
                (service.serviceId < 0) ||
                (service.serviceId == this.serviceId && service.variationId == this.variationId) ||
                (service.serviceId == this.serviceId && service.variationId < 0);
        return result;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result *= 31;
        result += serviceId;
        result *= 31;
        result += variationId;
        return result;
    }
}
