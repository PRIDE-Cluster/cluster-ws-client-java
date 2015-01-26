package uk.ac.ebi.pride.cluster.wsclient.client.cluster;

import org.springframework.web.client.RestTemplate;
import uk.ac.ebi.pride.cluster.wsclient.config.ClusterWsConfig;
import uk.ac.ebi.pride.cluster.wsclient.model.cluster.Cluster;
import uk.ac.ebi.pride.cluster.wsclient.model.cluster.ClusterSearchResults;
import uk.ac.ebi.pride.cluster.wsclient.model.cluster.ClusterSpeciesCounts;
import uk.ac.ebi.pride.cluster.wsclient.model.spectrum.Spectrum;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jose A. Dianes <jadianes@gmail.com>
 */
public class ClusterWsClient {

    private RestTemplate restTemplate;
    private ClusterWsConfig config;

    public ClusterWsClient(ClusterWsConfig config) {
        this.config = config;
        this.restTemplate = new RestTemplate();
    }

    public long totalSearchResults(String q) throws IOException {
        ClusterSearchResults clusterSearchResults = this.search(q,0,1);
        return clusterSearchResults.totalResults;
    }

    public ClusterSearchResults search(String q, int page, int size) throws IOException {

        Map<String, String> args = new HashMap<String, String>();
        args.put("q", q);
        args.put("page", "" + page);
        args.put("size", "" + size);

        String url = String.format("%s://%s/pride/ws/cluster/%s",
                config.getProtocol(), config.getHostName(), "cluster/search?q={q}&page={page}&size={size}");

        return this.restTemplate.getForObject(url, ClusterSearchResults.class, args);

    }

    public Cluster get(String clusterId) throws IOException {

        Map<String, String> args = new HashMap<String, String>();
        args.put("clusterId", clusterId);

        String url = String.format("%s://%s/pride/ws/cluster/%s",
                config.getProtocol(), config.getHostName(), "cluster/{clusterId}");

        return this.restTemplate.getForObject(url, Cluster.class, args);

    }

    public ClusterSpeciesCounts species(String clusterId) throws IOException {

        Map<String, String> args = new HashMap<String, String>();
        args.put("clusterId", clusterId);

        String url = String.format("%s://%s/pride/ws/cluster/%s",
                config.getProtocol(), config.getHostName(), "cluster/{clusterId}/species");

        return this.restTemplate.getForObject(url, ClusterSpeciesCounts.class, args);
    }

    public Spectrum consensus(String clusterId) throws IOException {

        Map<String, String> args = new HashMap<String, String>();
        args.put("clusterId", clusterId);

        String url = String.format("%s://%s/pride/ws/cluster/%s",
                config.getProtocol(), config.getHostName(), "cluster/{clusterId}/consensus");

        return this.restTemplate.getForObject(url, Spectrum.class, args);
    }

}
