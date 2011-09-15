package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.data.JavaTypeData;
import org.jannocessor.model.type.JavaInterface;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.executable.JavaMethod;


@Generated("JAnnocessor-bootstraped")
public class JavaInterfaceData extends JavaTypeData implements JavaInterface {

    private PowerList<JavaMethod> methods;


    public PowerList<JavaMethod> getMethods() {
        return this.methods;
    }

    public void setMethods(PowerList<JavaMethod> value) {
        this.methods = value;
    }


}


