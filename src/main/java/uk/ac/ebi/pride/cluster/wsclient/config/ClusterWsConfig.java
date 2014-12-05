package uk.ac.ebi.pride.cluster.wsclient.config;

/**
 * @author Jose A. Dianes <jadianes@gmail.com>
 *
 */
public abstract class ClusterWsConfig {

    private String hostName;
    private String protocol;

    protected ClusterWsConfig(String protocol, String hostName) {
        this.hostName = hostName;
        this.protocol = protocol;
    }

    public String getHostName() {
        return hostName;
    }

    public String getProtocol() {
        return protocol;
    }

}
