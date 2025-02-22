package com.agileboot.common.utils.ip;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OfflineIpRegionUtilTest {

    @Test
    public void testGetIpRegionWhenIpv4() {
        IpRegion ipRegion = OfflineIpRegionUtil.getIpRegion("110.81.189.80");

        Assertions.assertEquals("中国", ipRegion.getCountry());
        Assertions.assertEquals("福建省", ipRegion.getProvince());
        Assertions.assertEquals("泉州市", ipRegion.getCity());
    }

    @Test
    public void testGetIpRegionWithIpv6() {
        IpRegion region = Assertions.assertDoesNotThrow(() ->
            OfflineIpRegionUtil.getIpRegion("2001:0DB8:0000:0023:0008:0800:200C:417A")
        );

        Assertions.assertNull(region);
    }

    @Test
    public void testGetIpRegionWithEmpty() {
        IpRegion region = Assertions.assertDoesNotThrow(() ->
            OfflineIpRegionUtil.getIpRegion("")
        );

        Assertions.assertNull(region);
    }

    @Test
    public void testGetIpRegionWithNull() {
        IpRegion region = Assertions.assertDoesNotThrow(() ->
            OfflineIpRegionUtil.getIpRegion(null)
        );

        Assertions.assertNull(region);
    }

    @Test
    public void testGetIpRegionWithWrongIpString() {
        IpRegion region = Assertions.assertDoesNotThrow(() ->
            OfflineIpRegionUtil.getIpRegion("asfdsfdsff")
        );
        Assertions.assertNull(region);
    }
}
