package com.alibaba.langengine.opentripmap;

import com.alibaba.langengine.opentripmap.sdk.OpenTripMapClient;
import com.alibaba.langengine.opentripmap.sdk.OpenTripMapException;
import com.alibaba.langengine.opentripmap.sdk.request.*;
import com.alibaba.langengine.opentripmap.sdk.response.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@EnabledIfEnvironmentVariable(named = "OPEN_TRIP_MAP_API_KEY", matches = ".*")
class OpenTripMapClientTest {

    private OpenTripMapClient openTripMapClient;

    private static final String API_KEY = System.getenv("OPEN_TRIP_MAP_API_KEY");

    @BeforeEach
    void setUp() {
        assertNotNull(API_KEY, "API key must be provided via OPEN_TRIP_MAP_API_KEY environment variable");
        openTripMapClient = new OpenTripMapClient(API_KEY);
    }

    @Test
    void testConstructor() {
        OpenTripMapClient client = new OpenTripMapClient(API_KEY);
        assertNotNull(client);
    }

    @Test
    void testGetGeoname() throws OpenTripMapException {
        // 准备测试数据
        GeonameRequest request = new GeonameRequest();
        request.setLang("en");
        request.setName("Paris");
        request.setCountry("FR");

        // 执行测试
        Geoname result = openTripMapClient.getGeoname(request);

        // 验证结果
        assertNotNull(result);
        assertEquals("Paris", result.getName());
        assertEquals("FR", result.getCountry());
    }

    @Test
    void testGetListOfPlacesByLocation() throws OpenTripMapException {
        // 准备测试数据 - 巴黎市中心区域
        ListOfPlacesByLocationRequest request = new ListOfPlacesByLocationRequest();
        request.setLang("en");
        request.setLonMin(2.33);
        request.setLonMax(2.37);
        request.setLatMin(48.85);
        request.setLatMax(48.87);
        request.setLimit(5);

        // 执行测试
        List<SimpleFeature> result = openTripMapClient.getListOfPlacesByLocation(request);

        // 验证结果
        assertNotNull(result);
        assertTrue(result.size() > 0);
        assertNotNull(result.get(0).getXid());
        assertNotNull(result.get(0).getName());
        assertNotNull(result.get(0).getPoint());
        assertNotNull(result.get(0).getPoint().getLat());
        assertNotNull(result.get(0).getPoint().getLon());
    }

    @Test
    void testGetListOfPlacesByRadius() throws OpenTripMapException {
        // 准备测试数据 - 以埃菲尔铁塔为中心，半径1000米
        ListOfPlacesByRadiusRequest request = new ListOfPlacesByRadiusRequest();
        request.setLang("en");
        request.setLon(2.2945);  // 埃菲尔铁塔经度
        request.setLat(48.8584); // 埃菲尔铁塔纬度
        request.setRadius(1000); // 1公里半径
        request.setLimit(5);

        // 执行测试
        List<SimpleFeature> result = openTripMapClient.getListOfPlacesByRadius(request);

        // 验证结果
        assertNotNull(result);
        assertTrue(result.size() > 0);
        assertNotNull(result.get(0).getXid());
        assertNotNull(result.get(0).getName());
        assertNotNull(result.get(0).getPoint());
        assertNotNull(result.get(0).getPoint().getLat());
        assertNotNull(result.get(0).getPoint().getLon());
    }

    @Test
    void testGetPlaceByXid() throws OpenTripMapException {
        // 准备测试数据 - 使用一个已知的地点ID
        PlaceByXidRequest request = new PlaceByXidRequest();
        request.setLang("en");
        request.setXid("Q1771147"); // 埃菲尔铁塔的Wikidata ID

        // 执行测试
        Places result = openTripMapClient.getPlaceByXid(request);

        // 验证结果
        assertNotNull(result);
        assertEquals("Q1771147", result.getXid());
        assertNotNull(result.getName());
        assertNotNull(result.getPoint());
        assertNotNull(result.getPoint().getLat());
        assertNotNull(result.getPoint().getLon());
    }

    @Test
    void testGetListOfPlacesBySuggestions() throws OpenTripMapException {
        // 准备测试数据 - 搜索建议
        ListOfPlacesBySuggestionsRequest request = new ListOfPlacesBySuggestionsRequest();
        request.setLang("en");
        request.setName("Eiffel");
        request.setLon(2.2945);  // 埃菲尔铁塔经度
        request.setLat(48.8584); // 埃菲尔铁塔纬度
        request.setRadius(10000); // 10公里半径
        request.setLimit(5);

        // 执行测试
        List<SimpleSuggestFeature> result = openTripMapClient.getListOfPlacesBySuggestions(request);

        // 验证结果
        assertNotNull(result);
        assertTrue(result.size() > 0);
        assertNotNull(result.get(0).getXid());
        assertNotNull(result.get(0).getName());
        assertNotNull(result.get(0).getPoint().getLat());
        assertNotNull(result.get(0).getPoint().getLon());
    }

    @Test
    void testGetGeonameWithInvalidName() {
        // 准备测试数据 - 无效的地名
        GeonameRequest request = new GeonameRequest();
        request.setLang("en");
        request.setName("InvalidPlaceName12345");

        // 验证异常被抛出
        assertThrows(OpenTripMapException.class, () -> {
            openTripMapClient.getGeoname(request);
        });
    }
}
