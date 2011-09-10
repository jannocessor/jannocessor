package org.jannocessor.data;

import org.jannocessor.data.JavaTypeData;
import org.jannocessor.model.type.JavaClass;
import java.util.List;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.executable.JavaInstanceInit;



public class JavaClassData extends JavaTypeData implements JavaClass {

    //private List<JavaField> _${m.name.getClone().deleteParts(0)};

    //private List<JavaConstructor> _${m.name.getClone().deleteParts(0)};

    //private List<JavaMethod> _${m.name.getClone().deleteParts(0)};

    //private List<JavaStaticInit> _${m.name.getClone().deleteParts(0)};

    //private List<JavaInstanceInit> _${m.name.getClone().deleteParts(0)};


    public List<JavaField> getFields() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setFields(List<JavaField> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public List<JavaConstructor> getConstructors() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setConstructors(List<JavaConstructor> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public List<JavaMethod> getMethods() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setMethods(List<JavaMethod> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public List<JavaStaticInit> getStaticInits() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setStaticInits(List<JavaStaticInit> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public List<JavaInstanceInit> getInstanceInits() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setInstanceInits(List<JavaInstanceInit> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }


}


