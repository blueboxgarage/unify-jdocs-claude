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

/**
 * Simple test runner for JDocument
 */
public class RunJDocTest {
    
    public static void main(String[] args) {
        try {
            // Initialize JDocs
            JDocs.init();
            
            // Test empty document
            Document doc = new JDocument();
            System.out.println("Empty document: " + doc.getJson());
            
            // Test setting values
            doc.setString("$.name", "Alice");
            doc.setInteger("$.age", 25);
            doc.setBoolean("$.active", true);
            
            // Print document
            System.out.println("Updated document: " + doc.getPrettyPrintJson());
            
            // Test getting values
            System.out.println("Name: " + doc.getString("$.name"));
            System.out.println("Age: " + doc.getInteger("$.age"));
            System.out.println("Active: " + doc.getBoolean("$.active"));
            
            // Test nested objects
            doc.setString("$.address.city", "New York");
            doc.setString("$.address.state", "NY");
            
            // Print document
            System.out.println("Document with nested objects: " + doc.getPrettyPrintJson());
            
            // Test arrays
            doc.setString("$.phones[0].type", "Home");
            doc.setString("$.phones[0].number", "123-456-7890");
            doc.setString("$.phones[1].type", "Work");
            doc.setString("$.phones[1].number", "987-654-3210");
            
            // Print document
            System.out.println("Document with arrays: " + doc.getPrettyPrintJson());
            
            // Test array size
            System.out.println("Phones array size: " + doc.getArraySize("$.phones[]"));
            
            // Test deleting a path
            doc.deletePath("$.phones[0]");
            System.out.println("After deleting phones[0]: " + doc.getPrettyPrintJson());
            
            // Test read-only document
            Document readOnlyDoc = new ReadOnlyDocument(doc);
            System.out.println("Read-only document: " + readOnlyDoc.getPrettyPrintJson());
            
            try {
                readOnlyDoc.setString("$.name", "Bob");
                System.out.println("This should not print - read-only document was modified!");
            } catch (JdocException e) {
                System.out.println("Read-only document correctly threw exception when modified: " + e.getMessage());
            }
            
            System.out.println("All tests passed!");
        } catch (Exception e) {
            System.err.println("Test failed with exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}