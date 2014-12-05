package uk.ac.ebi.pride.cluster.wsclient.model.spectrum;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jadianes <jadianes@gmail.com>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Spectrum {

    @JsonProperty
    public String clusterId;

    @JsonProperty
    public SpectrumPeak[] peaks;

    @JsonProperty
    public double mzStart;

    @JsonProperty
    public double mzStop;

}
