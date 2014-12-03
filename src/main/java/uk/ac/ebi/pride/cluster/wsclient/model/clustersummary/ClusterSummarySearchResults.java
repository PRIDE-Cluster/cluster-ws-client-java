package uk.ac.ebi.pride.cluster.wsclient.model.clustersummary;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jadianes ${EMAIL}
 */
public class ClusterSummarySearchResults {

    @JsonProperty("totalResults")
    public long totalResults;

    @JsonProperty
    public long pageNumber;

    @JsonProperty
    public long pageSize;

    public ClusterSummary[] results;

}
