package com.proofpoint.discovery;

import com.google.common.collect.ImmutableMap;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.UUID;

public class ServiceAnnouncement
{
    private final UUID id;
    private final String type;
    private final String pool;
    private final Map<String, String> properties;

    @JsonCreator
    public ServiceAnnouncement(@JsonProperty("id") UUID id,
                               @JsonProperty("type") String type,
                               @JsonProperty("pool") String pool,
                               @JsonProperty("properties") Map<String, String> properties)
    {
        this.id = id;
        this.type = type;
        this.pool = pool;

        if (properties != null) {
            this.properties = ImmutableMap.copyOf(properties);
        }
        else {
            this.properties = null;
        }
    }

    @NotNull
    public UUID getId()
    {
        return id;
    }

    @NotNull
    public String getType()
    {
        return type;
    }

    @NotNull
    public String getPool()
    {
        return pool;
    }

    @NotNull
    public Map<String, String> getProperties()
    {
        return properties;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ServiceAnnouncement that = (ServiceAnnouncement) o;

        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (pool != null ? !pool.equals(that.pool) : that.pool != null) {
            return false;
        }
        if (properties != null ? !properties.equals(that.properties) : that.properties != null) {
            return false;
        }
        if (type != null ? !type.equals(that.type) : that.type != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (pool != null ? pool.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }
}