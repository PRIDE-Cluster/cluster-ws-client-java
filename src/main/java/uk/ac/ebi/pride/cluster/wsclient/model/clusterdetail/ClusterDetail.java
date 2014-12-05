package uk.ac.ebi.pride.cluster.wsclient.model.clusterdetail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jadianes <jadianes@gmail.com>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClusterDetail {

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
