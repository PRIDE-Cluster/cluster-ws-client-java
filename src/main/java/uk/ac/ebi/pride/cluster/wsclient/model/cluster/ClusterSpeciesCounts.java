package uk.ac.ebi.pride.cluster.wsclient.model.cluster;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jadianes <jadianes@gmail.com>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClusterSpeciesCounts {

    @JsonProperty
    public SpeciesCount[] speciesCounts;

}
