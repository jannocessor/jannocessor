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

    private PowerList<JavaField> fields;

    private PowerList<JavaConstructor> constructors;

    private PowerList<JavaMethod> methods;

    private PowerList<JavaStaticInit> staticInits;

    private PowerList<JavaInstanceInit> instanceInits;


    public PowerList<JavaField> getFields() {
        return this.fields;
    }

    public void setFields(PowerList<JavaField> value) {
        this.fields = value;
    }

    public PowerList<JavaConstructor> getConstructors() {
        return this.constructors;
    }

    public void setConstructors(PowerList<JavaConstructor> value) {
        this.constructors = value;
    }

    public PowerList<JavaMethod> getMethods() {
        return this.methods;
    }

    public void setMethods(PowerList<JavaMethod> value) {
        this.methods = value;
    }

    public PowerList<JavaStaticInit> getStaticInits() {
        return this.staticInits;
    }

    public void setStaticInits(PowerList<JavaStaticInit> value) {
        this.staticInits = value;
    }

    public PowerList<JavaInstanceInit> getInstanceInits() {
        return this.instanceInits;
    }

    public void setInstanceInits(PowerList<JavaInstanceInit> value) {
        this.instanceInits = value;
    }


}


