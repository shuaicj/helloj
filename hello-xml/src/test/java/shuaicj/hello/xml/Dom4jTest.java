package shuaicj.hello.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test dom4j.
 *
 * @author shuaicj 2019/05/16
 */
public class Dom4jTest {

    @Test
    public void testRootElement() throws DocumentException {
        Element root = doc().getRootElement();
        assertThat(root.getName()).isEqualTo("pets");
    }

    @Test
    public void testAttribute() throws DocumentException {
        Element root = doc().getRootElement();
        assertThat(root.attribute("count").getValue()).isEqualTo("3");
        assertThat(root.attribute("non-exists")).isNull();
    }

    @Test
    public void testSingleElement() throws DocumentException {
        Element root = doc().getRootElement();
        assertThat(root.element("cat").attributeValue("id")).isEqualTo("1");
        assertThat(root.element("non-exists")).isNull();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testListElements() throws DocumentException {
        Element root = doc().getRootElement();
        List<Element> elements = doc().getRootElement().elements("cat");
        List<String> ids = elements.stream()
                                   .map(e -> e.attributeValue("id"))
                                   .collect(Collectors.toList());
        assertThat(ids).containsExactly("1", "2");
        assertThat(root.elements("non-exists")).isEmpty();
    }

    @Test
    public void testXpathSingleNode() throws DocumentException {
        Node node = doc().selectSingleNode("/pets/dog");
        assertThat(node.getNodeTypeName()).isEqualTo("Element");
        assertThat(((Element) node).attributeValue("id")).isEqualTo("3");
        assertThat(doc().selectSingleNode("/pets/non-exists")).isNull();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testXpathListNodes() throws DocumentException {
        List<Node> nodes = doc().selectNodes("/pets/cat");
        List<String> ids = nodes.stream()
                                .map(e -> ((Element) e).attributeValue("id"))
                                .collect(Collectors.toList());
        assertThat(ids).containsExactly("1", "2");
        assertThat(doc().selectNodes("/pets/non-exists")).isEmpty();
    }

    @Test
    public void testXpathComplicated() throws DocumentException {
        Node node = doc().selectSingleNode("//cat[pureblood[text()='true']]/name");
        assertThat(node.getText()).isEqualTo("bob");
    }

    private Document doc() throws DocumentException {
        SAXReader reader = new SAXReader();
        URL url = Thread.currentThread().getContextClassLoader().getResource("pets.xml");
        assert url != null;
        return reader.read(url);
    }
}
