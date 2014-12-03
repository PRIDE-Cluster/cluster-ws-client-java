package uk.ac.ebi.pride.cluster.wsclient.config;

/**
 * @author Jose A. Dianes <jadianes@gmail.com>
 *
 */
public class ClusterWsConfig {

    private String hostName;
    private String protocol;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
