package uk.ac.ebi.pride.cluster.wsclient;

import uk.ac.ebi.pride.cluster.wsclient.client.cluster.ClusterWsClient;
import uk.ac.ebi.pride.cluster.wsclient.config.ClusterWsConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.ac.ebi.pride.cluster.wsclient.model.cluster.Cluster;
import uk.ac.ebi.pride.cluster.wsclient.model.cluster.ClusterSearchResults;
import uk.ac.ebi.pride.cluster.wsclient.model.cluster.ClusterSpeciesCounts;
import uk.ac.ebi.pride.cluster.wsclient.model.spectrum.Spectrum;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * @author Jose A. Dianes <jadianes@gmail.com>
 *
 */
@ContextConfiguration(locations = {"/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ClusterWsClientTemplateTest {

    static final String TEST_CLUSTER_ID = "4836857";

    @Autowired
    ClusterWsConfig clusterWsConfig;

    ClusterWsClient clusterWsClient;

    @Before
    public void init() {
        clusterWsClient = new ClusterWsClient(clusterWsConfig);
    }

    @Test
    public void testClusterSearch() throws IOException {

        ClusterSearchResults res = clusterWsClient.search("",0,10);

        assertNotNull(res);
        assertNotNull(res.results);
        assertTrue(res.totalResults > 0);
        assertTrue(res.pageNumber == 0);
        assertTrue(res.pageSize == 10);
        assertTrue(res.results.length == 10);

    }

    @Test
    public void testClusterGet() throws IOException {

        Cluster res = clusterWsClient.get(TEST_CLUSTER_ID);

        assertNotNull(res);
        assertEquals(TEST_CLUSTER_ID, res.id);
        assertTrue(res.numberOfSpectra > 0);

    }

    @Test
    public void testSpectrumConsensus() throws IOException {

        Spectrum res = clusterWsClient.consensus(TEST_CLUSTER_ID);

        assertNotNull(res);
        assertEquals(TEST_CLUSTER_ID, res.clusterId);
        assertTrue(res.peaks.length>0);

    }

    @Test
    public void testClusterSpecies() throws IOException {

        ClusterSpeciesCounts res = clusterWsClient.species(TEST_CLUSTER_ID);

        assertNotNull(res);
        assertNotNull(res.speciesCounts);
        assertTrue(res.speciesCounts.length > 0);

    }
}
