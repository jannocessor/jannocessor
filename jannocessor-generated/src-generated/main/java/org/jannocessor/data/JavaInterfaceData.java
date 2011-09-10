package org.jannocessor.data;

import org.jannocessor.data.JavaTypeData;
import org.jannocessor.model.type.JavaInterface;
import java.util.List;
import org.jannocessor.model.executable.JavaMethod;



public class JavaInterfaceData extends JavaTypeData implements JavaInterface {

    private List<JavaMethod> _getMethods;


    public List<JavaMethod> getMethods() {
        return this._getMethods;
    }

    public void setMethods(List<JavaMethod> value) {
        this._getMethods = value;
    }


}


