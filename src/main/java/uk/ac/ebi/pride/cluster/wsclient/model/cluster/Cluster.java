package uk.ac.ebi.pride.cluster.wsclient.model.cluster;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jadianes <jadianes@gmail.com>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cluster {

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
    public String peptideSequence;

    @JsonProperty
    public String proteinAccession;

}
