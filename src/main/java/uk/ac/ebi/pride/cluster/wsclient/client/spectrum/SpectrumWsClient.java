package uk.ac.ebi.pride.cluster.wsclient.client.spectrum;

import org.springframework.web.client.RestTemplate;
import uk.ac.ebi.pride.cluster.wsclient.config.ClusterWsConfig;
import uk.ac.ebi.pride.cluster.wsclient.model.clustersummary.ClusterSummary;
import uk.ac.ebi.pride.cluster.wsclient.model.clustersummary.ClusterSummarySearchResults;
import uk.ac.ebi.pride.cluster.wsclient.model.spectrum.Spectrum;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jose A. Dianes <jadianes@gmail.com>
 */
public class SpectrumWsClient {

    private RestTemplate restTemplate;
    private ClusterWsConfig config;

    public SpectrumWsClient(ClusterWsConfig config) {
        this.config = config;
        this.restTemplate = new RestTemplate();
    }

    public Spectrum consensus(String clusterId) throws IOException {

        Map<String, String> args = new HashMap<String, String>();
        args.put("clusterId", clusterId);

        String url = String.format("%s://%s/pride/ws/cluster/%s",
                config.getProtocol(), config.getHostName(), "spectrum/{clusterId}/consensus");

        return this.restTemplate.getForObject(url, Spectrum.class, args);
    }

}
