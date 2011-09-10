package org.jannocessor.data;

import org.jannocessor.data.JavaTypeData;
import org.jannocessor.model.type.JavaInterface;
import java.util.List;
import org.jannocessor.model.executable.JavaMethod;



public class JavaInterfaceData extends JavaTypeData implements JavaInterface {

    //private List<JavaMethod> _${m.name.getClone().deleteParts(0)};


    public List<JavaMethod> getMethods() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setMethods(List<JavaMethod> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }


}


