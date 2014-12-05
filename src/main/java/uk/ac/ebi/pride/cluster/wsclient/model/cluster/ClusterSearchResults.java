package uk.ac.ebi.pride.cluster.wsclient.model.cluster;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jadianes <jadianes@gmail.com>
 */
public class ClusterSearchResults {

    @JsonProperty("totalResults")
    public long totalResults;

    @JsonProperty
    public long pageNumber;

    @JsonProperty
    public long pageSize;

    public Cluster[] results;

}
