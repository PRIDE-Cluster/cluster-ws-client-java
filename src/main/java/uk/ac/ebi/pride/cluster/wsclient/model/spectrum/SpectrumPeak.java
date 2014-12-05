package uk.ac.ebi.pride.cluster.wsclient.model.spectrum;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jadianes <jadianes@gmail.com>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpectrumPeak {

    @JsonProperty
    public double intensity;

    @JsonProperty
    public double mz;

}
