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

package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.data.JavaElementData;
import org.jannocessor.model.executable.AbstractJavaExecutable;
import org.jannocessor.model.executable.ExecutableBody;


@Generated("JAnnocessor-bootstraped")
public class AbstractJavaExecutableData extends JavaElementData implements AbstractJavaExecutable {

    private ExecutableBody body;


    public ExecutableBody getBody() {
        return this.body;
    }

    public void setBody(ExecutableBody value) {
        this.body = value;
    }


}


