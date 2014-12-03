package uk.ac.ebi.pride.cluster.wsclient.model.clustersummary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author jadianes ${EMAIL}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClusterSummary {

    @JsonProperty("id")
    public String id;


}
