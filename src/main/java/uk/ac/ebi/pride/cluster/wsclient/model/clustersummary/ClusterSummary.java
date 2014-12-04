package uk.ac.ebi.pride.cluster.wsclient.model.clustersummary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author jadianes <jadianes@gmail.com>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClusterSummary {

    @JsonProperty
    public String id;

    @JsonProperty
    public double averagePrecursorMz;

    @JsonProperty
    public double averagePrecursorCharge;

    @JsonProperty
    public long numberOfSpectra;

    @JsonProperty
    public double maxRatio;

    @JsonProperty
    public String clusterQuality;

    @JsonProperty
    public String proteinAccession;

    @JsonProperty
    public String peptideSequence;

}
