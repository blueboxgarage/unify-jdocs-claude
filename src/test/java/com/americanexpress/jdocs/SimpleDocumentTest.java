/*
 * Copyright 2020 American Express Travel Related Services Company, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.americanexpress.jdocs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Simple tests for the JDocument class
 * 
 * @author Deepak Arora
 */
public class SimpleDocumentTest {

    @BeforeAll
    public static void setup() {
        // Initialize JDocs
        JDocs.init();
    }
    
    @Test
    public void testEmptyDocument() {
        Document doc = new JDocument();
        assertNotNull(doc);
        assertEquals("{}", doc.getJson());
    }
    
    @Test
    public void testSimpleJsonDocument() {
        String json = "{\"name\":\"John\",\"age\":30}";
        Document doc = new JDocument(json);
        
        assertEquals("John", doc.getString("$.name"));
        assertEquals(30, doc.getInteger("$.age"));
    }
    
    @Test
    public void testSetValues() {
        Document doc = new JDocument();
        
        doc.setString("$.name", "Alice");
        doc.setInteger("$.age", 25);
        doc.setBoolean("$.active", true);
        doc.setBigDecimal("$.salary", new BigDecimal("5000.50"));
        
        assertEquals("Alice", doc.getString("$.name"));
        assertEquals(25, doc.getInteger("$.age"));
        assertTrue(doc.getBoolean("$.active"));
        assertEquals(new BigDecimal("5000.50"), doc.getBigDecimal("$.salary"));
    }
    
    @Test
    public void testNestedObjects() {
        Document doc = new JDocument();
        
        doc.setString("$.person.name", "Bob");
        doc.setString("$.person.address.city", "New York");
        
        assertEquals("Bob", doc.getString("$.person.name"));
        assertEquals("New York", doc.getString("$.person.address.city"));
    }
    
    @Test
    public void testArrays() {
        Document doc = new JDocument();
        
        doc.setString("$.users[0].name", "User1");
        doc.setString("$.users[1].name", "User2");
        
        assertEquals("User1", doc.getString("$.users[0].name"));
        assertEquals("User2", doc.getString("$.users[1].name"));
        assertEquals(2, doc.getArraySize("$.users[]"));
    }
    
    @Test
    public void testFlatten() {
        String json = "{\"person\":{\"name\":\"John\",\"age\":30,\"address\":{\"city\":\"New York\"}}}";
        Document doc = new JDocument(json);
        
        List<String> paths = doc.flatten();
        assertTrue(paths.contains("$.person.name"));
        assertTrue(paths.contains("$.person.age"));
        assertTrue(paths.contains("$.person.address.city"));
    }
    
    @Test
    public void testDelete() {
        Document doc = new JDocument();
        
        doc.setString("$.name", "John");
        doc.setInteger("$.age", 30);
        
        assertEquals("John", doc.getString("$.name"));
        
        doc.deletePath("$.name");
        assertNull(doc.getString("$.name"));
        assertEquals(30, doc.getInteger("$.age"));
    }
    
    @Test
    public void testReadOnlyDocument() {
        Document doc = new JDocument();
        doc.setString("$.name", "John");
        
        Document readOnlyDoc = new ReadOnlyDocument(doc);
        assertEquals("John", readOnlyDoc.getString("$.name"));
        
        assertThrows(JdocException.class, () -> readOnlyDoc.setString("$.age", "30"));
    }
}
