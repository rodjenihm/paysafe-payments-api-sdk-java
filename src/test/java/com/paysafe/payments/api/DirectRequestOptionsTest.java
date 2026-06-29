// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.api;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DirectRequestOptionsTest {

    @Test
    void testDefaultConstructor() {
        DirectRequestOptions options = new DirectRequestOptions();
        assertNotNull(options.getCustomHeaders());
        assertTrue(options.getCustomHeaders().isEmpty());
    }

    @Test
    void testConstructorWithNullCustomHeaders() {
        DirectRequestOptions options = new DirectRequestOptions(null);
        assertNotNull(options.getCustomHeaders());
        assertTrue(options.getCustomHeaders().isEmpty());
    }

    @Test
    void testConstructorWithCustomHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer token");

        DirectRequestOptions options = new DirectRequestOptions(headers);

        assertNotNull(options.getCustomHeaders());
        assertEquals(2, options.getCustomHeaders().size());
        assertEquals("application/json", options.getCustomHeaders().get("Content-Type"));
        assertEquals("Bearer token", options.getCustomHeaders().get("Authorization"));
    }

    @Test
    void testGetCustomHeaders() {
        DirectRequestOptions options = new DirectRequestOptions();
        Map<String, String> headers = options.getCustomHeaders();

        assertNotNull(headers);
        assertTrue(headers.isEmpty());

        headers.put("test", "value");
        assertEquals("value", options.getCustomHeaders().get("test"));
    }

    @Test
    void testSetCustomHeaders() {
        DirectRequestOptions options = new DirectRequestOptions();

        Map<String, String> newHeaders = new HashMap<>();
        newHeaders.put("X-Custom-Header", "custom-value");

        options.setCustomHeaders(newHeaders);

        assertEquals(1, options.getCustomHeaders().size());
        assertEquals("custom-value", options.getCustomHeaders().get("X-Custom-Header"));
    }

    @Test
    void testSetCustomHeadersWithNull() {
        DirectRequestOptions options = new DirectRequestOptions();
        options.addHeader("existing", "value");
        assertEquals(1, options.getCustomHeaders().size());

        options.setCustomHeaders(null);
        assertNull(options.getCustomHeaders());
    }

    @Test
    void testAddHeader() {
        DirectRequestOptions options = new DirectRequestOptions();
        DirectRequestOptions result = options.addHeader("key1", "value1");

        assertSame(options, result);
        assertEquals(1, options.getCustomHeaders().size());
        assertEquals("value1", options.getCustomHeaders().get("key1"));
        options.addHeader("key2", "value2")
               .addHeader("key3", "value3");

        assertEquals(3, options.getCustomHeaders().size());
        assertEquals("value2", options.getCustomHeaders().get("key2"));
        assertEquals("value3", options.getCustomHeaders().get("key3"));
    }

    @Test
    void testAddHeaderOverwrite() {
        DirectRequestOptions options = new DirectRequestOptions();
        options.addHeader("key", "value1");
        assertEquals("value1", options.getCustomHeaders().get("key"));

        options.addHeader("key", "value2");
        assertEquals("value2", options.getCustomHeaders().get("key"));
        assertEquals(1, options.getCustomHeaders().size());
    }

    @Test
    void testInheritanceFromRequestOptions() {
        DirectRequestOptions options = new DirectRequestOptions();
        assertTrue(options instanceof RequestOptions);
    }
}
