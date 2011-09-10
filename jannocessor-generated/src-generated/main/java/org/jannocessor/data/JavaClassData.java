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

    private List<JavaField> _getFields;

    private List<JavaConstructor> _getConstructors;

    private List<JavaMethod> _getMethods;

    private List<JavaStaticInit> _getStaticInits;

    private List<JavaInstanceInit> _getInstanceInits;


    public List<JavaField> getFields() {
        return this._getFields;
    }

    public void setFields(List<JavaField> value) {
        this._getFields = value;
    }

    public List<JavaConstructor> getConstructors() {
        return this._getConstructors;
    }

    public void setConstructors(List<JavaConstructor> value) {
        this._getConstructors = value;
    }

    public List<JavaMethod> getMethods() {
        return this._getMethods;
    }

    public void setMethods(List<JavaMethod> value) {
        this._getMethods = value;
    }

    public List<JavaStaticInit> getStaticInits() {
        return this._getStaticInits;
    }

    public void setStaticInits(List<JavaStaticInit> value) {
        this._getStaticInits = value;
    }

    public List<JavaInstanceInit> getInstanceInits() {
        return this._getInstanceInits;
    }

    public void setInstanceInits(List<JavaInstanceInit> value) {
        this._getInstanceInits = value;
    }


}


