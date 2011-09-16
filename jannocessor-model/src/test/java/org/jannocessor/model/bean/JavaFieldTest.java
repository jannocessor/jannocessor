/**
 * Copyright 2011 jannocessor.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jannocessor.model.bean;

import java.util.List;

import junit.framework.Assert;

import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.util.Code;
import org.jannocessor.model.util.Fields;
import org.jannocessor.model.variable.JavaField;
import org.junit.Test;

public class JavaFieldTest {

    @Test
    public void testFieldConstruction1() {
        JavaElementType type = Code.type(List.class, String.class);

        JavaField field = Code.field(Fields.PRIVATE_FINAL, type, "field1");

        Assert.assertEquals("field1", field.getName().getText());
        Assert.assertEquals(Fields.PRIVATE_FINAL, field.getModifiers());
        Assert.assertEquals(type, field.getType());
    }

    @Test
    public void testFieldConstruction2() {
        JavaField field = Code.field(Fields.PUBLIC_STATIC_FINAL, String.class, "field2");

        Assert.assertEquals("field2", field.getName().getText());
        Assert.assertEquals(Fields.PUBLIC_STATIC_FINAL, field.getModifiers());
        Assert.assertEquals("java.lang.String", field.getType().getName().getText());
    }

}
