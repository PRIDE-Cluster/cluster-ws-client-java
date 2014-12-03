package uk.ac.ebi.pride.cluster.wsclient;

import uk.ac.ebi.pride.cluster.wsclient.client.clustersummary.ClusterSummaryWsClient;
import uk.ac.ebi.pride.cluster.wsclient.config.ClusterWsConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.ac.ebi.pride.cluster.wsclient.model.clustersummary.ClusterSummarySearchResults;

import java.io.IOException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * @author Jose A. Dianes <jadianes@gmail.com>
 *
 */
@ContextConfiguration(locations = {"/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ClusterWsClientTemplateTest {

    @Autowired
    ClusterWsConfig clusterWsConfig;
    ClusterSummaryWsClient clusterSummaryWsClient;

    @Before
    public void init() {
        clusterSummaryWsClient = new ClusterSummaryWsClient(clusterWsConfig);
    }

    @Test
    public void testPredict() throws IOException {

        ClusterSummarySearchResults res = clusterSummaryWsClient.search("",1,10);

        assertNotNull(res);
        assertNotNull(res.results);
        assertTrue(res.totalResults > 0);
        assertTrue(res.pageNumber == 1);
        assertTrue(res.pageSize == 10);
        assertTrue(res.results.length == 10);

    }
}
