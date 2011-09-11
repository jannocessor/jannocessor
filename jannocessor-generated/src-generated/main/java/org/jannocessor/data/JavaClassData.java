package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.data.JavaTypeData;
import org.jannocessor.model.type.JavaClass;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.executable.JavaInstanceInit;


@Generated("JAnnocessor-bootstraped")
public class JavaClassData extends JavaTypeData implements JavaClass {

    private PowerList<JavaField> _getFields;

    private PowerList<JavaConstructor> _getConstructors;

    private PowerList<JavaMethod> _getMethods;

    private PowerList<JavaStaticInit> _getStaticInits;

    private PowerList<JavaInstanceInit> _getInstanceInits;


    public PowerList<JavaField> getFields() {
        return this._getFields;
    }

    public void setFields(PowerList<JavaField> value) {
        this._getFields = value;
    }

    public PowerList<JavaConstructor> getConstructors() {
        return this._getConstructors;
    }

    public void setConstructors(PowerList<JavaConstructor> value) {
        this._getConstructors = value;
    }

    public PowerList<JavaMethod> getMethods() {
        return this._getMethods;
    }

    public void setMethods(PowerList<JavaMethod> value) {
        this._getMethods = value;
    }

    public PowerList<JavaStaticInit> getStaticInits() {
        return this._getStaticInits;
    }

    public void setStaticInits(PowerList<JavaStaticInit> value) {
        this._getStaticInits = value;
    }

    public PowerList<JavaInstanceInit> getInstanceInits() {
        return this._getInstanceInits;
    }

    public void setInstanceInits(PowerList<JavaInstanceInit> value) {
        this._getInstanceInits = value;
    }


}


