package uk.ac.ebi.pride.cluster.wsclient.client.clusterdetail;

import org.springframework.web.client.RestTemplate;
import uk.ac.ebi.pride.cluster.wsclient.config.ClusterWsConfig;
import uk.ac.ebi.pride.cluster.wsclient.model.clusterdetail.ClusterDetail;
import uk.ac.ebi.pride.cluster.wsclient.model.clusterdetail.ClusterSpeciesCounts;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jose A. Dianes <jadianes@gmail.com>
 */
public class ClusterDetailWsClient {

    private RestTemplate restTemplate;
    private ClusterWsConfig config;

    public ClusterDetailWsClient(ClusterWsConfig config) {
        this.config = config;
        this.restTemplate = new RestTemplate();
    }

    public ClusterDetail get(String clusterId) throws IOException {

        Map<String, String> args = new HashMap<String, String>();
        args.put("clusterId", clusterId);

        String url = String.format("%s://%s/pride/ws/cluster/%s",
                config.getProtocol(), config.getHostName(), "clusterDetail/{clusterId}");

        return this.restTemplate.getForObject(url, ClusterDetail.class, args);

    }

    public ClusterSpeciesCounts species(String clusterId) throws IOException {

        Map<String, String> args = new HashMap<String, String>();
        args.put("clusterId", clusterId);

        String url = String.format("%s://%s/pride/ws/cluster/%s",
                config.getProtocol(), config.getHostName(), "clusterDetail/{clusterId}/species");

        return this.restTemplate.getForObject(url, ClusterSpeciesCounts.class, args);
    }

}
