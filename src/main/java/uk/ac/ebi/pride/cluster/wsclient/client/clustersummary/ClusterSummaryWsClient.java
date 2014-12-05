package uk.ac.ebi.pride.cluster.wsclient.client.clustersummary;

import org.springframework.web.client.RestTemplate;
import uk.ac.ebi.pride.cluster.wsclient.config.ClusterWsConfig;
import uk.ac.ebi.pride.cluster.wsclient.model.clustersummary.ClusterSummary;
import uk.ac.ebi.pride.cluster.wsclient.model.clustersummary.ClusterSummarySearchResults;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jose A. Dianes <jadianes@gmail.com>
 */
public class ClusterSummaryWsClient {

    private RestTemplate restTemplate;
    private ClusterWsConfig config;

    public ClusterSummaryWsClient(ClusterWsConfig config) {
        this.config = config;
        this.restTemplate = new RestTemplate();
    }

    public ClusterSummarySearchResults search(String q, int page, int size) throws IOException {

        Map<String, String> args = new HashMap<String, String>();
        args.put("q", q);
        args.put("page", "" + page);
        args.put("size", "" + size);

        String url = String.format("%s://%s/pride/ws/cluster/%s",
                config.getProtocol(), config.getHostName(), "clusterSummary/search?q={q}&page={page}&size={size}");

        return this.restTemplate.getForObject(url, ClusterSummarySearchResults.class, args);

    }

    public ClusterSummary get(String clusterId) throws IOException {

        Map<String, String> args = new HashMap<String, String>();
        args.put("clusterId", clusterId);

        String url = String.format("%s://%s/pride/ws/cluster/%s",
                config.getProtocol(), config.getHostName(), "clusterSummary/{clusterId}");

        return this.restTemplate.getForObject(url, ClusterSummary.class, args);

    }
}
